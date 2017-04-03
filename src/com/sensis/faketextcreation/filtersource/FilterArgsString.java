package com.sensis.faketextcreation.filtersource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FilterArgsString helps to strip off the punctuation from string
 *
 */
public class FilterArgsString {

	/**
	 * Removes all punctuation and extra spaces from given string.
	 * 
	 * @param input
	 * @return String
	 */
	public static String removePunctuation(String input) {

		
		//System.out.println("input"+input);
		String regex = "[^a-zA-Z\\s]";
		Pattern pattern = Pattern.compile(regex);
		/*
		 * if (input.trim().isEmpty()) { return null; }
		 * 
		 */
		Matcher matcher = pattern.matcher(input);
		
		/*for(String matche : matcher.)
		{
			
		}*/
	//	String parseInput = matcher.group();
		
		String parseInput = matcher.replaceAll("");
		// System.out.println("temp:::"+parseInput);

		if (parseInput.equals("")) {
			return null;
		}
		//System.out.println("parseInput"+parseInput);
		//System.out.println(parseInput);
		return parseInput;

	}
}
