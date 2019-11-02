package com.book.client.bean;

import java.util.ArrayList;
import java.util.List;

public class DispatchRackTO {
	
	public String name;
	public String icon;
	List<DispatchBookTO> books = new ArrayList<DispatchBookTO>();

	public List<DispatchBookTO> getBooks() {
		return books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(List<DispatchBookTO> books) {
		this.books = books;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
 }
