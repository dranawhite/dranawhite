package com.dranawhite.common.common;

import com.dranawhite.common.converter.BeanConverter;

import lombok.Data;
import org.junit.Test;

/**
 * @author dranawhite
 * @version [1.0, 2018/6/5 14:45]
 */
public class BeanConverterTest {

	@Test
	public void testConvert() {
		PersonA pa = new PersonA();
		pa.setAge(28);
		pa.setId(1);
		pa.setName("tony");
		pa.setAddress("雨润大街");
		PersonB pb = BeanConverter.convert(pa, PersonB.class);
		System.out.println(pb);
	}

	@Data
	class PersonA {

		private int id;
		private String name;
		private String address;
		private int age;
	}

	@Data
	class PersonB {

		private int id;
		private String name;
		private String address;
		private int no;
	}
}
