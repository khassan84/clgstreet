package com.book.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.client.bean.CustomQuestionPaperTO;
//import com.book.client.bean.CustomQuestionPaperTO;
import com.bookstoredb.bean.QuestionPaperDO;
import com.bookstoredb.bean.ResponseCode;
import com.bookstoredb.bean.to.ResponseTO;
import com.bookstoredb.service.impl.PaperServiceImpl;

@RestController
public class CreatePaperController {
	
	@Autowired
	PaperServiceImpl paperServiceImpl;
	
	
	@RequestMapping(value= "/savequestionpaper", method = RequestMethod.POST  )
	public void saveQuestion2(@RequestBody Object str){
		System.out.println(str);
		
	}
	
	@RequestMapping("/savequestionpaper2")
	public void saveQuestion(@RequestBody CustomQuestionPaperTO paperTO){
		System.out.println(paperTO);
		System.out.println(paperTO.getUser());
		System.out.println(paperTO.getPaper());
		QuestionPaperDO questionPaperDO = new QuestionPaperDO();
		questionPaperDO.setCreateDate(new Date());
		questionPaperDO.setData(paperTO.getPaper().toString());
		questionPaperDO.setPaperName(paperTO.getAssignmentName());
		questionPaperDO.setUserName(paperTO.getUser());
		//paperServiceImpl.savePaper(null, questionPaperDO);
		
		
		ResponseTO responseTO = new ResponseTO();
		responseTO.setResponseCode(ResponseCode.PAPERCREATED.getCode());
		responseTO.setResponseMessage(ResponseCode.PAPERCREATED.getDesc());
	}


}
