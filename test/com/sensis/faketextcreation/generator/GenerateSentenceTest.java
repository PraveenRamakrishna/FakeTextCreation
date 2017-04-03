/*package com.sensis.faketextcreation.generator;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GenerateSentenceTest {

	GenerateSentence generateSentence;

	@Before
	public void setUp() {
		generateSentence = new GenerateSentence();

	}

	@After
	public void tearDown() {
		generateSentence = null;

	}

	@Test
	public void testGenerateOutput() {

		String inputString = "I WISH I MAY I WISH I MIGHT";
		String expected = "I WISH I MIGHT";
		String actual = generateSentence.generateOutput(new ByteArrayInputStream(inputString.getBytes()));

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateOutputInfinite() {

		String inputString = "A A A";
		int expected = 50;
		String result = generateSentence.generateOutput(new ByteArrayInputStream(inputString.getBytes()));
		int actual = result.split(" ").length;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateOutputOneWord() {

		String inputString = "A";
		String expected = "A";
		String actual = generateSentence.generateOutput(new ByteArrayInputStream(inputString.getBytes()));
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateOutputEnpty() {

		String inputString = "";
		String expected = null;
		String actual = generateSentence.generateOutput(new ByteArrayInputStream(inputString.getBytes()));
		Assert.assertEquals(expected, actual);
	}
}
*/