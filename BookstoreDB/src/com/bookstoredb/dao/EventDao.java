package com.bookstoredb.dao;

import org.hibernate.Session;

import com.bookstoredb.bean.EventIDO;

public interface EventDao {
	
	public EventIDO createEventI(Session session, EventIDO eventIDO);

}
