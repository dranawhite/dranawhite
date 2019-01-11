package com.dranawhite.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dranawhite
 * @version $Id: Person.java, v 0.1 2019-01-10 20:18 dranawhite Exp $$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;

    private String name;

    private int age;

    @JsonIgnore
    private Address address;
}


