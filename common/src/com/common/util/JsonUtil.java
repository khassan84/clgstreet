package com.common.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	public static void main(String[] args){
		TestBean bean = new TestBean();
		bean.setId("1");
		bean.setName("Kamal");
		TestBean bean2 = new TestBean();
		bean2.setId("2");
		bean2.setName("Hassan");
		
		
		List<TestBean> l = new ArrayList();
		l.add(bean);
		l.add(bean2);
		getJson(l);
	}
	
	public static String getJson(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		String str = null;
		try {
			str = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
