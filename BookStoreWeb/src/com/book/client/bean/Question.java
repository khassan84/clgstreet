package com.book.client.bean;

import java.util.ArrayList;
import java.util.List;

public class Question {
	List<Option> options = new ArrayList();
	String answerType = null;
	List<String> answer = new ArrayList();
	String text = null;
	String choice = null;

	
	
	
	public Question(List<Option> options, String answerType,
			List<String> answer, String text, String choice) {
		super();
		this.options = options;
		this.answerType = answerType;
		this.answer = answer;
		this.text = text;
		this.choice = choice;
	}

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
