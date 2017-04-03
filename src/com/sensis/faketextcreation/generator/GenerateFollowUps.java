package com.sensis.faketextcreation.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sensis.faketextcreation.filtersource.FilterArgsString;

public class GenerateFollowUps {

	/**
	 * To split string into words
	 */
	private final static String SPLITTER = " ";

	// Map holds pair of words (concatenated) as key and its possible follow
	// up as value

	// int countPairs = 0;
	// int pairObjects = 0;
	Map<PairWords, String> pairMap;

	// holds pair words
	PairWords pair;

	public GenerateFollowUps() {
		pairMap = new HashMap<>();
		pair = new PairWords();
	}

	/**
	 * Generates a Map containing all possible pair of words and possible its
	 * followUp
	 * 
	 * @param inputString
	 * @return pairMap
	 */
	public Map<PairWords, String> getPossibleFollowUps(InputStream input) {

		int count = 0;
		// int countWords = 0;
	//	 int repeatedPairs = 0;
		// int replacedValues = 0;
		String parseLine = null;
		int index = 0;
		int totlen = 0;
		int avg = 0;
		// PairWords pair = null;
		// StringBuilder adjustLine = new StringBuilder();
		long startTimeTotal = 0;
		long stopTimeTotal = 0;
		// long stopTime = 0;
		// List<String> arrayList = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input))) {
			String line = bufferedReader.readLine();

			startTimeTotal = System.currentTimeMillis();
			while (null != line) {

				System.out.println(count++);

				parseLine = FilterArgsString.removePunctuation((line));

				if (parseLine != null && parseLine != "") {

					String[] inputWord = parseLine.split("\\s+");
					int wordLenght = inputWord.length;
					
					avg = (avg + wordLenght);

					// countWords = countWords + wordLenght;
					// System.out.println("countWords" + countWords);

					// System.out.println("repeatedPairs:::" + repeatedPairs);
					// System.out.println("replacedValues:::" + replacedValues);
				//	System.out.println("pairMapSize:::" + pairMap.size());

					for (index = 0; index < wordLenght; index++) {

						String internedWord=inputWord[index].intern();
						
						totlen = totlen+internedWord.length();
						
						

						
							if (pair.getNextWord() != null) {
							if (pairMap.isEmpty())
								pairMap.put(null, pair.getWord() + SPLITTER + pair.getNextWord());

							if (pairMap.containsKey(pair)) {
								// repeatedPairs++;
								// System.out.println("repeatedPairs:::"+repeatedPairs);
								if (internedWord.length() > pairMap.get(pair).length()) {
									pairMap.put(pair, internedWord);
									// replacedValues++;
								}
							} else {
								pairMap.put(pair, internedWord);

							}

						}
						pair = createPair(internedWord);

					}

				}
			//	System.out.println("pairMapSize:::" + pairMap.size());
				stopTimeTotal = System.currentTimeMillis();
				System.out.println("Time to read file::" + (stopTimeTotal - startTimeTotal));
				System.out.println("totlen:::"+totlen);
				System.out.println("avg::::"+(totlen/avg));
				System.out.println("no of strings"+avg);
				line = bufferedReader.readLine();

			}

			if (pairMap.isEmpty() && pair.getWord() != null)
				pairMap.put(null, pair.getWord() + (pair.getNextWord() == null ? "" : (SPLITTER + pair.getNextWord())));

		//	System.out.println("pairMapSize:::" + pairMap.size());
			//System.out.println("pairMapContent:::" + pairMap);
			// System.out.println("countWords:::" + countWords);
			return pairMap;

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public PairWords createPair(String word) {

		// countPairs++;
		// System.out.println("countPairs"+countPairs);
		String prevWord;

		if (pair.getWord() == null)
			pair.setWord(word);
		else if (pair.getNextWord() == null)
			pair.setNextWord(word);
		else {
			
			prevWord = pair.getNextWord();
			pair = new PairWords();
			// pairObjects++;
			// System.out.println("pairObjects"+pairObjects);
			pair.setWord(prevWord);
			pair.setNextWord(word);

		}
		return pair;

	}

}
