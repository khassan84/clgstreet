package com.bookstoredb.bean.to;

import java.util.ArrayList;
import java.util.List;

public class Question {
	List<Option> options = new ArrayList();
	String answerType = null;
	List<String> answer = new ArrayList();
	String text = null;
	String choice = null;

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	

}
