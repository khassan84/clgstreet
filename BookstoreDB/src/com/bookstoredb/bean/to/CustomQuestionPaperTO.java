package com.bookstoredb.bean.to;

import java.util.List;


/**
 * @author Kamal Hassan
 *
 */
public class CustomQuestionPaperTO {
	public String user;
	public String assignmentName;
	public String paper;
	//public List<Question> paper;
	
	
	public CustomQuestionPaperTO(String user, String assignmentName,
			String paper) {
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
	public String getPaper() {
		return paper;
	}
	public void setPapaer(String paper) {
		this.paper = paper;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
}
