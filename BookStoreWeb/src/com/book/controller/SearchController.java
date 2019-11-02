package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.book.client.bean.BookSugessionTO;
import com.book.client.bean.CreateUserTO;
import com.book.client.bean.SearchParameter;
import com.book.temp.RandomUtil;
import com.bookstoredb.bean.UserPasswordDO;
import com.bookstoredb.bean.UsersDO;
import com.bookstoredb.bean.to.CustomQuestionPaperTO;
import com.bookstoredb.bean.to.LoginResponseTO;
import com.bookstoredb.service.impl.PaperServiceImpl;
import com.bookstoredb.service.impl.SearchServiceImpl;
import com.bookstoredb.service.impl.UserServiceImpl;
import com.common.util.Utility;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
public class SearchController {
	
	@Autowired
	UserServiceImpl userservice;
	
	@Autowired
	SearchServiceImpl searchService;
	
	@Autowired
	PaperServiceImpl paperServiceImpl;
	
	
	@RequestMapping("/searchResult")
	@ResponseBody
	public String searchResult(@ModelAttribute("searchParam") SearchParameter searchParam) throws JsonProcessingException{
		System.out.println("search text : "+searchParam.getText());
		String path = "./pdf/spring_tutorial.pdf";
		return path;
	}
	
	//@RequestMapping(value= "/createuser", method = RequestMethod.POST  )
	@RequestMapping(value="/search", method = RequestMethod.POST)
	@ResponseBody
	public String search(@RequestBody SearchParameter searchParam) throws JsonProcessingException{

		ModelAndView modelAndView = new ModelAndView("search");
		System.out.println("search text : "+searchParam.getText());
		/*StringBuilder hql = new StringBuilder();
		StringBuilder likeClause = new StringBuilder();
		likeClause.append(QueryHelper.getWhereClauseToMatchAllCaseInsensitiveWord("name", searchParam.getText()));
		hql.append("content from EventADO where "+ likeClause.toString());*/
		String content = searchService.getSearchResult(null, searchParam.getText());
		System.out.println(content);
		return content;
	}
	
	
	//@RequestMapping(value = "/sugession", method = RequestMethod.GET)
	@RequestMapping("/sugession")
	@ResponseBody
	public ModelAndView sugessions(@ModelAttribute("searchParam") SearchParameter searchParam){
		System.out.println("in sugessions method ");
		ModelAndView modelAndView = new ModelAndView("sugession");
		BookSugessionTO bookSugessionTO = RandomUtil.getSugession();
		modelAndView.addObject("sugession","text...");
		
		return modelAndView;
	}
	
	@RequestMapping("/search2")
	@ResponseBody
	public BookSugessionTO search2(@ModelAttribute("searchParam") SearchParameter searchParam) throws JsonProcessingException{
	//public String searchResult() throws JsonProcessingException{
		System.out.println("in search method " + searchParam);
		System.out.println("in search method ");
		if(searchParam != null){
			System.out.println("Text :" + searchParam.getText());
		}
		return RandomUtil.getSugession();
	}
	
	@RequestMapping("/preparequestion")
	@ResponseBody
	public ModelAndView prepareQuestion(@ModelAttribute("searchParam") SearchParameter searchParam){
		System.out.println("in prepareQuestion method ");
		ModelAndView modelAndView = new ModelAndView("preparequestion");
		BookSugessionTO bookSugessionTO = RandomUtil.getSugession();
		modelAndView.addObject("sugession","text...");
		
		return modelAndView;
	}

	
	@RequestMapping(value= "/createuser", method = RequestMethod.POST  )
	@ResponseBody
	public LoginResponseTO createUser(@RequestBody CreateUserTO createUser){
	//public String createUser(@ModelAttribute("createUser") CreateUserTO createUser) throws JsonProcessingException{
		System.out.println(createUser);
		UsersDO userDo = new UsersDO();
		UserPasswordDO passwordDO = new UserPasswordDO();
		try {
			Utility.convertDosToTos(createUser, userDo);
		} catch (InstantiationException e) {
			System.err.println(e);
		} catch (IllegalAccessException e) {
			System.err.println(e);
		}
		userservice.createUser(null, userDo, createUser.getPassword());
		
		LoginResponseTO createUserResponseTO = new LoginResponseTO();
		createUserResponseTO.setUserName("khassan");
		
		createUserResponseTO.setResponseCode("O300");
		createUserResponseTO.setResponseDesc("User created");
		
		return createUserResponseTO;
	}
	
	
	@RequestMapping(value= "/test", method = RequestMethod.GET  )
	public SearchParameter test(){
		System.out.println("user service hash code "+userservice.hashCode());
		//userservice.testOuterTransaction(null, null);
		SearchParameter parameter =  new SearchParameter();
		parameter.setText("search text");
		parameter.setUser("user");
		return parameter;
	}

	@RequestMapping(value= "/getcontent", method = RequestMethod.POST)
	@ResponseBody
	//public CustomQuestionPaperTO getcontent(@RequestBody String code){
	public String getcontent(@RequestBody String code){
		System.out.println("getcontent :"+code);
		Long id = Long.parseLong(code);
		CustomQuestionPaperTO questionPaperTOs = null;
		CustomQuestionPaperTO customQuestionPaperTO = paperServiceImpl.getPaperById(null, id);
		//return customQuestionPaperTO;
		//JSON.stringify(customQuestionPaperTO.getPaper());
		//String content = "[{\"name\":\"WBCS prilim test paper\",\"preparedBy\":\"khassan\",\"code\":6,\"info\":null,\"age\":null}]";
		//String content ="[{\"options\":[{\"text\":\"o1\"}, {\"text\":\"o2\"}, {\"text\":\"o3\"}, {\"text\":\"o4\"}], \"answerType\":\"radio\", \"answer\":[\"o2\"], \"choice\":\"o2\", \"text\":\"q1\"}]";
		
		String content ="[{\"options\":[{\"text\":\"o1\"}, {\"text\":\"o2\"}, {\"text\":\"o3\"}, {\"text\":\"o4\"}], \"answerType\":\"radio\", \"answer\":[\"o1\"], \"choice\":\"o1\", \"text\":\"q1\"}, {\"answer\":[\"o3\"], \"options\":[{\"text\":\"o1\"}, {\"text\":\"o2\"}, {\"text\":\"o3\"}, {\"text\":\"o4\"}], \"text\":\"q2\", \"answerType\":\"radio\", \"choice\":\"o3\"}]";
		return content;
	}
	

}
