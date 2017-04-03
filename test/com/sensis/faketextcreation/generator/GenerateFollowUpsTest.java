package com.sensis.faketextcreation.generator;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import com.sensis.faketextcreation.generator.GenerateFollowUps.PairWords;

public class GenerateFollowUpsTest {

	GenerateFollowUps followUps;
	Map<String, String> hashMap;

	@Before
	public void setUp() {
		followUps = new GenerateFollowUps();
		hashMap = new HashMap<>();

	}

	@After
	public void tearDown() {
		followUps = null;
		hashMap = null;
	}
	
/*	@Test
	public void testGenerateOutputMultiFollowUp() {

		String inputString = "A AB A AB ABC";
		hashMap.put("A AB", "A");
		hashMap.put("A AB", "ABC");
		hashMap.put("AB A", "AB");
		Map<String, String> expected = hashMap;
		Map<PairWords, String> actual = followUps.getPossibleFollowUps(inputString);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateOutput() {

		String inputString = "A A A";
		hashMap.put("A A", "A");
		Map<String, String> expected = hashMap;
		Map<PairWords, String> actual = followUps.getPossibleFollowUps(inputString);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateOutputInfinite() {

		String inputString = "A A";
		Map<String, String> expected = hashMap;
		Map<PairWords, String> actual = followUps.getPossibleFollowUps(inputString);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateOutputOneWord() {
		String inputString = "A";		
		Map<String, String> expected = hashMap;
		Map<PairWords, String> actual = followUps.getPossibleFollowUps(inputString);

		Assert.assertEquals(expected, actual);
	}*/
}
