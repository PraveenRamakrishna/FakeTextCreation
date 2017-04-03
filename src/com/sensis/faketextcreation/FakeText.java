package com.sensis.faketextcreation;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import com.sensis.faketextcreation.generator.GenerateFollowUps;
import com.sensis.faketextcreation.generator.GenerateSentence;
import com.sensis.faketextcreation.generator.PairWords;

/**
 * 
 * User input (file location) containing text from which a new sentence to be
 * generated is captured via command line and a semi-realistic sentences is
 * generated and printed on command line
 * 
 * 
 */
public class FakeText {

	private static final long MEGABYTE = 1024L * 1024L;

	/**
	 * Main Method User is prompted to enter file location which is read via
	 * scanner from command line
	 * 
	 * @param args
	 *            required for main method signature
	 */
	public static void main(String[] args) {

		String result = null;

		try (Scanner reader = new Scanner(System.in)) {

			System.out.println("-----------------------------------------------------");

			System.out.println("1. Input a file");
			System.out.println("2. Input a sentence");

			String key = reader.nextLine();
			String input = null;
			long startTime = 0;

			switch (key) {
			case "1":
				System.out.println("Please input a file");
				input = reader.nextLine();

				startTime = System.currentTimeMillis();

				if (input.trim().length() == 0) {
					System.err.println("Nothing was entered. Usage: Please input a file path");
					System.exit(1);
				}

				/*
				 * String test = "test"; String test2 = "test check"; String
				 * test3 = "test check";
				 * 
				 * String[] split = test2.split(" "); String[] split2 =
				 * test3.split(" ");
				 * 
				 * String chr = (String) test2.subSequence(0,
				 * 4);//charAt(index)(0)+test2.charAt(1)+test2.charAt(2)+test2.
				 * charAt(3); String chr2 = (String) test3.subSequence(0,
				 * 4);//String chr2 =
				 * ""+test3.charAt(0)+test3.charAt(1)+test3.charAt(2)+test3.
				 * charAt(3); //System.(chr, 0, test2, 0, 4);
				 * 
				 * System.out.println("chr:::"+chr);
				 * 
				 * PairWords pairWords = new PairWords();
				 * pairWords.setWord((chr));
				 * pairWords.setNextWord(test2.substring(5,10));
				 * 
				 * PairWords pairWords2 = new PairWords();
				 * pairWords2.setWord(chr2);
				 * pairWords2.setNextWord(test3.substring(5,10));
				 * 
				 * System.out.println("pairWords"+(pairWords.equals(pairWords2))
				 * );
				 * 
				 * System.out.println((pairWords.getWord()==pairWords2.getWord()
				 * )); System.out.println(test); System.out.println(split[0]);
				 * System.out.println(split[0].intern()==split2[0].intern());
				 * System.out.println(split[0].equals(split2[0]));
				 * System.exit(0);
				 */

				try (InputStream inputStream = new FileInputStream(input)) {
					// new
					// GenerateFollowUps().getPossibleFollowUps(inputString);
					result = generateOutput(inputStream);

				} catch (IOException e) {
					System.err.println("Please input a valid file name!");
					System.exit(1);
				}

				break;

			case "2":
				System.out.println("Please input a sentence");
				input = reader.nextLine();

				try (InputStream inputStream = new ByteArrayInputStream(input.getBytes())) {
					result = generateOutput(inputStream);

				} catch (IOException e) {
					System.err.println("Please input a valid sentence");
					System.exit(1);
				}

				break;

			default:
				System.out.println("Please enter a valid input");
				System.exit(1);

			}

			if (result == null) {
				System.err.println("Please input a file with valid content");
			} else {
				System.out.println("=====semi-realistic sentences=======");
				System.out.println(result);
			}
			long stopTime = System.currentTimeMillis();
			System.out.println("Total time" + (stopTime - startTime));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static String generateOutput(InputStream inputStream) {

		Map<PairWords, String> pairMap = new GenerateFollowUps().getPossibleFollowUps(inputStream);

		return new GenerateSentence().generateSentence(pairMap);

	}

}
