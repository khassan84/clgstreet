package com.book.temp;

import com.book.client.bean.BookSugessionTO;
import com.book.client.bean.DispatchBookTO;
import com.book.client.bean.DispatchRackTO;

public class RandomUtil {
	
	
	public static BookSugessionTO getSugession(){
		
		BookSugessionTO bookSugessionTO = new BookSugessionTO();
		bookSugessionTO.getRacks().add(getRack());
		bookSugessionTO.getRacks().add(getRack());
		bookSugessionTO.getRacks().add(getRack());
		
		
		bookSugessionTO.getBooks().add(getBook());
		bookSugessionTO.getBooks().add(getBook());
		bookSugessionTO.getBooks().add(getBook());
		
		
		return bookSugessionTO;
		
		
	}
	
	public static DispatchRackTO getRack(){
		DispatchRackTO dispatchRackTO = new DispatchRackTO();
		dispatchRackTO.setName("dummy rack");
		dispatchRackTO.setIcon("/BookStoreWeb/resources/img/bookstore_1.jpg");
		
		for(int i=0; i<10; i++){
			dispatchRackTO.getBooks().add(getBook());
		}
		
		return dispatchRackTO;
	}
	
	public static DispatchBookTO getBook(){
		DispatchBookTO dispatchBookTO = new DispatchBookTO();
		dispatchBookTO.setTittle("dummy book");
		dispatchBookTO.setSource("/BookStoreWeb/resources/pdf/spring_tutorial.pdf");
		return dispatchBookTO;
		
		
	}

}
