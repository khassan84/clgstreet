package com.common.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	public static final String SPACE = " ";
	
	/**
	 * @param text
	 * @return list of word
	 */
	public static List<String> getWords(String text){
		if(text == null)
			return new ArrayList();
		return rectifyWords(text.split(SPACE));
	}
	
	/**
	 * @param words
	 * @return list of word
	 * iterate array and remove space from it
	 */
	public static List<String> rectifyWords(String[] words){
		List<String> finalKeyWords = new ArrayList();
		for(String key : words){
			if(key.trim().length() > 0){
				finalKeyWords.add(key);
			}
		}
		return finalKeyWords;
	}

}
