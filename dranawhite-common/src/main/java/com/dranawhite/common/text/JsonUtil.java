package com.dranawhite.common.text;

import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.file.DranaJsonException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * JSON工具类
 *
 * @author dranawhite
 * @version [1.0, 2018/4/28 10:19]
 */
public final class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 解析JSON
     *
     * @param json     json字符串
     * @param javaType 对象类型
     * @param <T>      外层对象
     * @return 复合对象
     */
    public static <T> T parseObject(String json, JavaType javaType) {
        try {
            return objectMapper.readValue(json, javaType);
        } catch (IOException ex) {
            throw new DranaJsonException("解析JSON失败", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    /**
     * 解析JSON
     *
     * @param json json字符串
     * @param clz  对象类型
     * @param <T>  外层对象
     * @return 复合对象
     */
    public static <T> T parseObject(String json, Class<T> clz) {
        try {
            return objectMapper.readValue(json, clz);
        } catch (IOException ex) {
            throw new DranaJsonException("解析JSON失败", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    /**
     * 解析JSON
     *
     * @param json    json字符串
     * @param collClz 集合类型
     * @param elemClz 元素类型
     * @param <T>     外层对象
     * @return 集合对象
     */
    public static <T extends Collection, G> T parseCollection(String json, Class<T> collClz, Class<G> elemClz) {
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            JavaType javaType = typeFactory.constructCollectionType(collClz, elemClz);
            return objectMapper.readValue(json, javaType);
        } catch (IOException ex) {
            throw new DranaJsonException("解析JSON失败!", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    /**
     * 解析JSON
     *
     * @param json    json字符串
     * @param elemClz 元素类型
     * @param <T>     外层对象
     * @return 数组
     */
    public static <T, G> T parseArray(String json, Class<G> elemClz) {
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            JavaType javaType = typeFactory.constructArrayType(elemClz);
            return objectMapper.readValue(json, javaType);
        } catch (IOException ex) {
            throw new DranaJsonException("解析JSON失败", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    /**
     * 解析JSON
     *
     * <pre>
     *     keyClz只能是基本数据类型，或者自定义key deserializer
     * </pre>
     *
     * @param json     json字符串
     * @param mapClz   元素类型
     * @param keyClz   Key类型
     * @param valueClz Value类型
     * @param <T>      外层对象
     * @return 图
     */
    public static <T extends Map, K, V> T parseMap(String json, Class<T> mapClz, Class<K> keyClz, Class<V> valueClz) {
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            JavaType javaType = typeFactory.constructMapType(mapClz, keyClz, valueClz);
            return objectMapper.readValue(json, javaType);
        } catch (IOException ex) {
            throw new DranaJsonException("解析JSON失败", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    /**
     * 生成JSON
     *
     * @param obj 对象
     * @param <T> 对象类型
     * @return 字符串
     */
    public static <T> String toJsonString(T obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            throw new DranaJsonException("生成JSON失败!", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    public static TypeFactory getTypeFactory() {
        return objectMapper.getTypeFactory();
    }
}
