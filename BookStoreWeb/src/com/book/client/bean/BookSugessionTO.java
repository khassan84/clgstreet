package com.book.client.bean;

import java.util.ArrayList;
import java.util.List;

public class BookSugessionTO {
	
	List<DispatchRackTO> racks = new ArrayList<DispatchRackTO>();
	List<DispatchBookTO> books = new ArrayList<DispatchBookTO>();
	
	
	public List<DispatchRackTO> getRacks() {
		return racks;
	}
	public List<DispatchBookTO> getBooks() {
		return books;
	}
	
	

}
