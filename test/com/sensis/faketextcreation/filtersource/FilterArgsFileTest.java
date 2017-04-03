/*package com.sensis.faketextcreation.filtersource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

public class FilterArgsFileTest {
	InputStream inputStream;
		
	@Test
	public void readFileEmpty() throws FileNotFoundException {

		inputStream = new FileInputStream("test/resource/UnitTestInputNull.txt");		
		Assert.assertEquals(null,new FilterArgsFile().readFile(inputStream));

	}
	@Test
	public void readFileBlank() throws FileNotFoundException {

		inputStream = new FileInputStream("test/resource/UnitTestInputBlank.txt");
		Assert.assertEquals(null,new FilterArgsFile().readFile(inputStream));

	}
	@Test
	public void readFileValid() throws FileNotFoundException {

		inputStream = new FileInputStream("test/resource/UnitTestInputValid.txt");
		Assert.assertEquals("I Wish I May I Wish I Might",new FilterArgsFile().readFile(inputStream));

	}

	
}
*/