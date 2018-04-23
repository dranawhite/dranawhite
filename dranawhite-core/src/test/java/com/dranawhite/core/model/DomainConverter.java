package com.dranawhite.core.model;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/20 11:21]
 */
public class DomainConverter {

	public static void main(String[] args) {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(UserDO.class, UserVO.class)
				.byDefault()
				.register();
		UserDO user = new UserDO();
		user.setId(123);
		user.setName("小明");
		MapperFacade mapper = mapperFactory.getMapperFacade();
		UserVO userVO = mapper.map(user, UserVO.class);
		System.out.println(userVO.toString());
	}

}
