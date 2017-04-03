/*package com.sensis.faketextcreation.filtersource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.sensis.faketextcreation.generator.GenerateFollowUps;
import com.sensis.faketextcreation.generator.PairWords;

*//**
 * FilterArgsFile is used to read the input file line by line using
 * bufferedReader into a stringBuilder variable which is the parsed in
 * FilterArgsString to remove punctuation
 *
 * Returns punctuation striped string from file
 * 
 *//*
public class FilterArgsFile {

	private static String SPLITBYSPACE = " ";

	private GenerateFollowUps generateFollowUps;
	private Map<PairWords, String> pairMap;
	private FilterArgsString filterArgsString;

	private String lastWord;
	private String lastButOne;

	*//**
	 * Reads file into a string builder and returns it as string
	 * 
	 * @param InputStream
	 * @return String from given file
	 *//*
	public Map<PairWords, String> readFile(InputStream input) {

		generateFollowUps = new GenerateFollowUps();
		pairMap = new HashMap<>();

		int count=0;
		String parseLine = null;

		filterArgsString = new FilterArgsString();

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input))) {
			String line = bufferedReader.readLine();

			while (null != line) {

				System.out.println(++count);
				parseLine = filterArgsString.removePunctuation(appendLastTwoWords(line));

				if (parseLine != null) {

					pairMap = generateFollowUps.getPossibleFollowUps(parseLine);

					saveLastTwoWords(parseLine);

				}
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return pairMap;

	}

	private void saveLastTwoWords(String parseLine) {

		String[] splitLine = parseLine.split(SPLITBYSPACE);

		if (splitLine.length > 2) {

			this.lastWord = splitLine[splitLine.length - 1];
			this.lastButOne = splitLine[splitLine.length - 2];

		}

	}

	private String appendLastTwoWords(String parseLine) {

		if (this.lastButOne == null || this.lastWord == null)
			return parseLine;

		return this.lastButOne + SPLITBYSPACE + this.lastWord + SPLITBYSPACE + parseLine;

	}
}
*/