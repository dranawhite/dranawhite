package com.dranawhite.common.util;

import com.dranawhite.common.model.Address;
import com.dranawhite.common.model.Person;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangyuquan
 * @version $Id: JsonUtilTest.java, v 0.1 2019-01-10 11:30 liangyuquan Exp $$
 */
public class JsonUtilTest {

    @Test
    public void testGenericTypes_Array() {
        Address address = new Address(1, "雨润大街108号");
        Person person = new Person(1, "tony", 18, address);
        Person[] personArr = new Person[]{person};

        String json = JsonUtil.toJsonString(personArr);
        Person[] result = JsonUtil.parseArray(json, Person.class);
        Person personResult = result[0];
        System.out.println(personResult);
    }

    @Test
    public void testGenericTypes_List() {
        Address address = new Address(1, "雨润大街108号");
        Person person = new Person(1, "tony", 18, address);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        String json = JsonUtil.toJsonString(personList);
        List<Person> result = JsonUtil.parseCollection(json, ArrayList.class, Person.class);
        Person personResult = result.get(0);
        System.out.println(personResult);
    }

    @Test
    public void testGenericTypes_Map() {
        Address address = new Address(1, "雨润大街108号");
        Person person = new Person(1, "tony", 18, address);
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("person", person);

        String json = JsonUtil.toJsonString(personMap);
        Map<String, Person> result = JsonUtil.parseMap(json, HashMap.class, String.class, Person.class);
        Person personResult = null;
        for (Map.Entry<String, Person> entry : result.entrySet()) {
            personResult = entry.getValue();
        }
        System.out.println(personResult);
    }

    @Test
    public void testGenericTypes_Multiple() {
        Address address = new Address(1, "雨润大街108号");
        Person person = new Person(1, "tony", 18, address);
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("person", person);
        List<Map<String, Person>> personList = new ArrayList<>();
        personList.add(personMap);

        String json = JsonUtil.toJsonString(personList);
        TypeFactory typeFactory = JsonUtil.getTypeFactory();
        JavaType inner = typeFactory.constructParametricType(HashMap.class, String.class, Person.class);
        JavaType javaType = typeFactory.constructParametricType(ArrayList.class, inner);
        List<Map<String, Person>> result = JsonUtil.parseObject(json, javaType);
        Map<String, Person> mapResult = result.get(0);
        Person personResult = null;
        for (Map.Entry<String, Person> entry : mapResult.entrySet()) {
            personResult = entry.getValue();
        }

        System.out.println(personResult);
    }

    @Test
    public void testIgnoreField() {
        Address address = new Address(1, "雨润大街108号");
        Person person = new Person(1, "tony", 18, address);
        String json = JsonUtil.toJsonString(person);
        System.out.println("JSON = " + json);
    }

}

