package com.book.client.bean;

import java.util.List;

/**
 * @author Kamal Hassan
 *
 */
public class CustomQuestionPaperTO {
	public String user;
	public String assignmentName;
	//public Object paper;
	public List<Question> paper;
	
	
	public CustomQuestionPaperTO(String user, String assignmentName,
			 List<Question> papaer) {
		super();
		this.user = user;
		this.assignmentName = assignmentName;
		this.paper = paper;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Object getPaper() {
		return paper;
	}
	public void setPapaer( List<Question> paper) {
		this.paper = paper;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
	
	

}
