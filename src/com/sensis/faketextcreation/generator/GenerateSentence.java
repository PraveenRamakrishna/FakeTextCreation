package com.sensis.faketextcreation.generator;

import java.util.Map;

/**
 * Contains the actual algorithm, where all possible followUps are first stored
 * into a HashMap and then the semi-realistic sentences is generated using the
 * key value pair of Map
 * 
 */
public class GenerateSentence {

	/**
	 * To split string into words
	 */
	private final static String SPLITTER = " ";
	/**
	 * First word in the given pair of words
	 */
	private final static int FIRST_PAIR_WORD = 0;
	/**
	 * Second word in the given pair of words
	 */
	private final static int SECOND_PAIR_WORD = 1;
	/**
	 * maximum words that can be generated
	 */
	private final static int MAX_WORDS = 50;

	public String generateSentence(Map<PairWords, String> pairMap) {

		// Map<PairWords, String> pairMap = new
		// GenerateFollowUps().getPossibleFollowUps(pairMap);

		String firstPair = pairMap.get(null);
		PairWords newKey = getFirstPair(firstPair);

		StringBuilder reslut = new StringBuilder();
		reslut.append(newKey.getWord()).append(SPLITTER).append(newKey.getNextWord());

		while (reslut.toString().split(SPLITTER).length < MAX_WORDS && pairMap.containsKey(newKey)) {

			String next = pairMap.get(newKey);
			reslut.append(SPLITTER + next);

			String split = newKey.getNextWord();

			newKey = new PairWords(split, next);

		}

		return reslut.toString();

	}

	/**
	 * Returns First pair words of given string
	 * 
	 * @param inputString,
	 *            input string
	 */
	private PairWords getFirstPair(String inputString) {

		String words[] = inputString.split(SPLITTER);

		return new PairWords(words[FIRST_PAIR_WORD], words.length == 2 ? words[SECOND_PAIR_WORD] : "");

	}

}
