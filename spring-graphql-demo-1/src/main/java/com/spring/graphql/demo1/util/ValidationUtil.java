package com.spring.graphql.demo1.util;

import java.util.List;

public class ValidationUtil {
	
	
	public static <T> boolean isNull(T object){
		return object == null ? true : false;
	}
	
	public static <T> boolean isNotNull(T object){
		return !isNull(object);
	}

	public static <T> boolean isEmpty(List<T> list){
		return (list == null || list.isEmpty()) ? true: false;
	}
	
	public static <T> boolean isNotEmpty(List<T> list){
		return !isEmpty(list);
	}
}
