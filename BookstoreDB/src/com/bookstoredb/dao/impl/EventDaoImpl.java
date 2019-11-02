package com.bookstoredb.dao.impl;

import org.hibernate.Session;

import com.bookstoredb.bean.EventIDO;
import com.bookstoredb.dao.EventDao;

public class EventDaoImpl implements EventDao{

	@Override
	public EventIDO createEventI(Session session, EventIDO eventIDO) {
		// TODO Auto-generated method stub
		session.save(eventIDO);
		return eventIDO;
	}

}
