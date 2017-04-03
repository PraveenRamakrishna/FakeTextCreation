package com.sensis.faketextcreation.filtersource;

import org.junit.Assert;
import org.junit.Test;

public class FileArgsStringTest {

	@Test
	public void removePunctuation() {

		String result = FilterArgsString.removePunctuation("I Wish! I Wish.");
		
		Assert.assertEquals(result, "I Wish I Wish");

	}
	@Test
	public void removePunctuationAll() {

		String result = FilterArgsString.removePunctuation("!.#$");		
		Assert.assertEquals(result,"");

	}
	@Test
	public void removePunctuationNull() {

		String result = FilterArgsString.removePunctuation("");		
		Assert.assertEquals(result,null);

	}
}
