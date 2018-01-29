package com.dranawhite.common.mybatis;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 根据数据库备注生成实体注释
 * <pre>
 * 配置用法：
 *      suppressDate：               取消生成日期注释，默认值false
 *      suppressAllComments:         取消生成所有注释，默认值false
 *      suppressModelAlias:          取消生成Model类@Alias注解，默认值为true
 *      addRemarkComments:           添加表备注作为注释，默认值false，若suppressAllComments设置为true，则忽略该字段
 *      author:                      类文件创建者，默认不生成，若suppressAllComments设置为true，则忽略该字段
 *      version:                     类文件版本，默认不生成，若suppressAllComments设置为true，则忽略该字段
 * </pre>
 *
 * @author dranawhite 2018/1/26
 */
public class DbCommentGenerator implements CommentGenerator {

    /**
     * properties配置
     */
    private Properties properties;

    /**
     * 是否生成日期注释
     */
    private boolean suppressDate;

    /**
     * 是否生成所有注释
     */
    private boolean suppressAllComments;

    /**
     * 添加备注作为注释
     * 若suppressAllComments设置为true，则忽略该字段
     */
    private boolean addRemarkComments;

    private SimpleDateFormat dateFormat;

    /**
     * 类文件创建者
     */
    private String author;

    /**
     * 类创建者邮箱
     */
    private String email;

    /**
     * 类文件版本号
     */
    private String version;

    /**
     * copyright路径
     */
    private String vmPath;

    /**
     * 是否生成@Alias注解
     */
    private boolean suppressModelAlias;

    private VelocityReader reader;

    public DbCommentGenerator() throws IOException {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        addRemarkComments = false;
        author = null;
        email = null;
        version = null;
        vmPath = null;
        suppressModelAlias = true;

        reader = new VelocityReader();
        reader.init();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
        addRemarkComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));
        suppressModelAlias = isTrue(properties
                .getProperty(DbPropertyRegistry.COMMENT_GENERATOR_SUPPRESS_MODEL_ALIAS));
        author = properties.getProperty(DbPropertyRegistry.COMMENT_GENERATOR_AUTHOR);
        email = properties.getProperty(DbPropertyRegistry.COMMENT_GENERATOR_EMAIL);
        version = properties.getProperty(DbPropertyRegistry.COMMENT_GENERATOR_VERSION);
        vmPath = properties.getProperty(DbPropertyRegistry.COMMENT_GENERATOR_VM_PATH);
        String dateFormatString =
                properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        if (introspectedColumn == null) {
            return;
        }

        field.addJavaDocLine("/**");
        String remark = introspectedColumn.getRemarks();
        StringBuilder sb = new StringBuilder(" * ");
        sb.append(remark);
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        addFieldComment(field, introspectedTable, null);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments  || !addRemarkComments) {
            return;
        }

        topLevelClass.addJavaDocLine("/**");
        String remark = introspectedTable.getRemarks();
        if (remark != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" * ").append(remark);
            topLevelClass.addJavaDocLine(sb.toString());
        }
        if (author != null && email != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" * @author ").append(author).append(" ").append(email);
            topLevelClass.addJavaDocLine(sb.toString());
        } else if (author != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" * @author ").append(author);
            topLevelClass.addJavaDocLine(sb.toString());
        } else if (email != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" * @author ").append(email);
            topLevelClass.addJavaDocLine(sb.toString());
        }


        if (version != null) {
            StringBuilder sb = new StringBuilder();
            Date curTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String curFormattedTime = sdf.format(curTime);
            sb.append(" * @version [V").append(version).append(", ").append(curFormattedTime)
                    .append("]");
            topLevelClass.addJavaDocLine(sb.toString());
        }
        topLevelClass.addJavaDocLine(" */");
        if (!suppressModelAlias) {
            String annotation = "@Alias(\"" + topLevelClass.getType().getShortName() + "\")";
            topLevelClass.addAnnotation(annotation);
            topLevelClass.addImportedType("org.apache.ibatis.type.Alias");
        }
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        // Do Nothing
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable,
            boolean markAsDoNotDelete) {
        // Do Nothing
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        // Do Nothing
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        if (vmPath != null) {
            reader.setVmPath(vmPath + "/getter.vm");
        } else {
            reader.setVmPath("velocity/getter.vm");
        }
        String methodName = method.getName();
        char[] methodNameChs = methodName.toCharArray();
        methodNameChs[3] = (char) (methodNameChs[3] + 32);
        char[] fieldNameChs = Arrays.copyOfRange(methodNameChs, 3, methodNameChs.length);
        Writer writer = reader
                .putVariables(assembleSetOrGetVariable(new String(fieldNameChs)));
        method.addJavaDocLine(writer.toString());
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        if (vmPath != null) {
            reader.setVmPath(vmPath + "/setter.vm");
        } else {
            reader.setVmPath("velocity/setter.vm");
        }
        Writer writer = reader
                .putVariables(assembleSetOrGetVariable(method.getParameters().get(0).getName()));
        method.addJavaDocLine(writer.toString());
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        // Do Nothing
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        if (vmPath != null) {
            reader.setVmPath(vmPath + "/copyright.vm");
        } else {
            reader.setVmPath("velocity/copyright.vm");
        }
        Writer writer = reader
                .putVariables(assembleCopyrightVariables(compilationUnit.getType().getShortName()));
        compilationUnit.addFileCommentLine(writer.toString());
    }

    @Override
    public void addComment(XmlElement xmlElement) {
        // Do Nothing
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
        // Do Nothing
    }

    private Map<String, String> assembleCopyrightVariables(String fileName) {
        Map<String, String> variableMap = new HashMap<>(16);
        if (author != null) {
            variableMap.put("author", author);
        }
        if (email != null) {
            variableMap.put("email", email);
        }
        if (version != null) {
            variableMap.put("version", version);
        }
        variableMap.put("fileName", fileName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        variableMap.put("curTime", sdf.format(new Date()));
        return variableMap;
    }

    private Map<String, String> assembleSetOrGetVariable(String fieldName) {
        Map<String, String> variableMap = new HashMap<>(1);
        variableMap.put("param", fieldName);
        return variableMap;
    }
}
