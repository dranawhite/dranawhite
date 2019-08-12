package com.dranawhite.common.resource;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author dranawhite
 * @version : ClassScanner.java, v 0.1 2019-08-12 18:06 dranawhite Exp $$
 */
public class ClassScanner implements ResourceLoaderAware {

    private final List<AnnotationTypeFilter> includeFilters = new LinkedList<>();
    private final List<AnnotationTypeFilter> excludeFilters = new LinkedList<>();

    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(this.resourcePatternResolver);

    @SafeVarargs
    public static Set<Class<?>> scan(String[] basePackages, Class<? extends Annotation>... annotations) {
        ClassScanner cs = new ClassScanner();
        if (ArrayUtils.isNotEmpty(annotations)) {
            for (Class<? extends Annotation> ann : annotations) {
                cs.addIncludeFilter(new AnnotationTypeFilter(ann));
            }
        }

        Set<Class<?>> classSet = new HashSet<>();
        for (String basePackage : basePackages) {
            classSet.addAll(cs.doScan(basePackage));
        }
        return classSet;
    }

    @SafeVarargs
    public static Set<Class<?>> scan(String basePackages, Class<? extends Annotation>... annotations) {
        return ClassScanner.scan(StringUtils.tokenizeToStringArray(basePackages, ",; \t\n"), annotations);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        this.metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
    }

    private void addIncludeFilter(AnnotationTypeFilter includeFilter) {
        this.includeFilters.add(includeFilter);
    }

    private void addExcludeFilter(AnnotationTypeFilter excludeFilter) {
        this.excludeFilters.add(0, excludeFilter);
    }

    private Set<Class<?>> doScan(String basePackage) {
        Set<Class<?>> classSet = new HashSet<>();
        try {
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                    + ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage))
                    + "/**/*.class";
            Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);

            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
                    boolean isFilterEmpty = includeFilters.size() == 0 && excludeFilters.size() == 0;
                    if (isFilterEmpty || matches(metadataReader)) {
                        try {
                            classSet.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException ex) {
            throw new BeanDefinitionStoreException("I/O failure during classpath scanning", ex);
        }
        return classSet;
    }

    private boolean matches(MetadataReader metadataReader) throws IOException {
        for (AnnotationTypeFilter tf : this.excludeFilters) {
            if (tf.match(metadataReader, this.metadataReaderFactory)) {
                return false;
            }
        }
        for (AnnotationTypeFilter tf : this.includeFilters) {
            if (tf.match(metadataReader, this.metadataReaderFactory)) {
                return true;
            }
        }
        return false;
    }

}

