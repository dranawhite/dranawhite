package com.dranawhite.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dranawhite
 * @version $Id: Address.java, v 0.1 2019-01-10 20:19 dranawhite Exp $$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private int id;

    private String address;
}
