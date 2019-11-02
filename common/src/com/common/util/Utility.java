package com.common.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Kamal Hassan
 *
 */
public class Utility {
	
	public static void main (String[] args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException{/*
		System.out.println("----------------" +convertDbToJavaName("first_visit_fees"));
		System.out.println(convertDbToJavaClassName("first_visit_fees"));
		Test t = new Test();
		PropertyDescriptor pdCompareIdentifierColumnName = new PropertyDescriptor(convertDbToJavaName("first_visit_fees"),Test.class);
		pdCompareIdentifierColumnName.getWriteMethod().invoke(t, "200");
		System.out.println("first visit fees :"+t.getFirstVisitFees());
		
		
		List<SearchResutRulesDO> doList = new ArrayList<SearchResutRulesDO>();
		List<SearchResutRulesTO> toList = new ArrayList<SearchResutRulesTO>();
		SearchResutRulesDO dos = new SearchResutRulesDO();
		SearchResutRulesTO tos = new SearchResutRulesTO();
		
		dos.setCategory("doctor");
		dos.setResultParam("name");
		doList.add(dos);
		dos = new SearchResutRulesDO();
		dos.setCategory("treatment");
		dos.setResultParam("location");
		doList.add(dos);
		//tos = convertDosToTos(dos, tos);
		toList = convertDosToTos(doList, tos);
		System.out.println(toList.size());
		for(SearchResutRulesTO to : toList){
			System.out.println(to.getCategory());
			System.out.println(to.getResultParam());
		}
	*/
		
	String name = "preliminary test   papaer wbcs";
	String[] keyWords = name.split(" ");
	List<String> finalKeyWords = new ArrayList();
	System.out.println(keyWords);
	for(String key : keyWords){
		System.out.println(key);
		if(key.trim().length() > 0){
			finalKeyWords.add(key);
		}
	}
	System.out.println(finalKeyWords);
	
	}
	
	
	
	/**
	 * @param objectName
	 * @return
	 */
	public static String convertDbToJavaClassName(String objectName) {
		return toTitleCase(convertDbToJavaName(objectName));
	}
	
	/**
	 * @param columnName
	 * @return
	 */
	public static String convertDbToJavaName(String columnName) {
		StringBuilder name = new StringBuilder();
		boolean nextIsUpper = false;
		for (int i = 0; i < columnName.length(); i++) {
			char c = columnName.charAt(i);
			if (c == '_') {
				nextIsUpper = true;
				continue;
			}
			if (nextIsUpper) {
				name.append(Character.toUpperCase(c));
				nextIsUpper = false;
			} else {
				name.append(Character.toLowerCase(c));
			}
		}
		return name.toString();
	}
	
	
	 /**
	 * @param javaName
	 * @return
	 */
	public static String convertJavaToDbName(String javaName) {
	        StringBuilder name = new StringBuilder();
	        for (int i = 0; i < javaName.length(); i++) {
	            char c = javaName.charAt(i);
	            if (Character.isUpperCase(c) && i != 0) {
	                name.append('_');
	            }
	            name.append(Character.toLowerCase(c));
	        }
	        return name.toString();
	    }
	 
	 /**
	 * @param s
	 * @return
	 */
	public static String toTitleCase(String s) {
			if(s == null || s.isEmpty()) {
				return s;
			} else {
				char c = s.charAt(0);
				if(Character.isTitleCase(c)) {
					return s;
				} else {
					return Character.toTitleCase(c) + s.substring(1);
				}
			}
		}
	 
	 /**
	  * this method is designed to receive list of data object and convert it to list of transfer object
	 * @param source this is data object which need to convert to transfer object
	 * @param This is transfer object
	 * @return list of transfer object
	 */
	public static <T, S> List<T> convertDosToTos(List<S> source, T target){
		 List<T> targetList = new ArrayList<T>();
		 for(Object s : source){
			 try {
				target = convertDosToTos(s, target);
				 targetList.add(target);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 }
		 return targetList;
	 }

	 /**
	 * @param source data object
	 * @param target empty transfer object which will not have any value to any of its parameter 
	 * @return transfer object
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public static <T, S> T convertDosToTos(S source, T target) throws InstantiationException, IllegalAccessException{
		//target = (T) target.getClass().newInstance();
		 BeanUtils.copyProperties(source, target);
		 return target;
	 }
	 
	/**
	 * @param paramName
	 * @param obj
	 * @return
	 */
	public static Object readParam(String paramName, Object obj){
		String javaValue = null;
		try {
			String javaParam = convertDbToJavaName(paramName);
			PropertyDescriptor pd = new PropertyDescriptor(javaParam, obj.getClass());
			Class type = pd.getPropertyType();
			//System.out.println("type :" + type.getClass());
			
			if(type.getName().equals(String.class.getName())){
				javaValue = (String) pd.getReadMethod().invoke(obj);
			}else if(type.getName().equals(Double.class.getName())){
				Double d = (Double) pd.getReadMethod().invoke(obj);
				javaValue = d.toString();
			}
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		
		return javaValue;
	}
	
	/**
	 * @param paramName which need to populate
	 * @param targetObject object which will be populated
	 * @param value with this value param name will be populated
	 */
	public static void writeParam(String paramName, Object targetObject, Object value){
		try {
			String javaParam = convertDbToJavaName(paramName);
			PropertyDescriptor pd = new PropertyDescriptor(javaParam, targetObject.getClass());
			pd.getWriteMethod().invoke(targetObject, value);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param obhect, which will be converted to json
	 * @return json string
	 */
	public static String createJsonString(Object obj){
    	ObjectMapper mapper = new ObjectMapper();
    	String json = null;
    	  try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return json;
    }
	
	/**
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
        return (str != null && (str.trim().length()>0));
    }
	
	/**
	 * @param objects
	 * @return
	 */
	public static boolean isEmpty(Object... objects) {
		if(objects != null) {
			for(Object object : objects) {
				if(object != null) {
					if(object instanceof String) {
						if( !((String)object).isEmpty() ) {
							return false;
						}
					} else if(object instanceof Collection<?>) {
						if( !((Collection<?>)object).isEmpty() ) {
							return false;
						}
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * @param target destination object which will be created and returned
	 * @param surceDO from this do to object will be created
	 * @return target to with filled property
	 */
	public static Object prepareTo(Object surceDO,Class target ){
			
			Object obj = null;
			try {
				 obj = target.newInstance();
				BeanUtils.copyProperties(surceDO, obj);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return obj;
		}
	/**
	 * @param target
	 * @param testDOs
	 * @return
	 */
	public static List prepareTos(Class target, List testDOs){
		List l = new ArrayList<>();
		for (Object  testDO: testDOs){
			Object obj = prepareTo(testDO, target);
			if(obj != null){
				l.add(obj);
			}
		}
		return l;
	}
	
}
