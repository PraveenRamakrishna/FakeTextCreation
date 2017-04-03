package com.sensis.faketextcreation.generator;

public class PairWords {
	private String word;
	private String nextWord;

	public String getWord() {
		return word;
	}

	public String getNextWord() {
		return nextWord;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setNextWord(String nextWord) {
		this.nextWord = nextWord;
	}

	public PairWords(String word, String nextWord) {
		this.word = word;
		this.nextWord = nextWord;
	}

	public PairWords() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nextWord == null) ? 0 : nextWord.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PairWords other = (PairWords) obj;
		if (nextWord == null) {
			if (other.nextWord != null)
				return false;
		} else if (!nextWord.equals(other.nextWord))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

}
