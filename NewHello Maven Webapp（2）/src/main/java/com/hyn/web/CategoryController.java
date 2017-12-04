package com.hyn.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hyn.common.CommonConstant;
import com.hyn.domain.Category;
import com.hyn.domain.Topic;
import com.hyn.domain.User;
import com.hyn.service.CategoryService;
import com.hyn.service.TopicService;
import com.hyn.service.UserService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@Autowired
	private TopicService topicservice;
	
	@Autowired
	private UserService userservice;
	
	/**
	 * 显示所有分类和文章
	 * @return
	 */
	@RequestMapping(value = "/Blogindex", method = RequestMethod.GET)
	public ModelAndView listAllCategories() {
		ModelAndView view =new ModelAndView();
		List<Category> categories = categoryservice.getAllBoards();
		view.addObject("categoryList", categories);
		List<Topic> topics = topicservice.getAllBoards();
		view.addObject("topicList",topics);
		User user = userservice.getUserById(1);
		view.addObject("user",user);
		System.out.println(categories.get(0));
		System.out.println(categories.get(1));
		System.out.println(topics.get(0).getCreateTime());
		System.out.println(topics.get(1).getCreateTime());
		view.setViewName("/Blogindex");
		return view;
	}
	
	/**
	 * 显示最新文章的相关信息
	 * @return
	 */
	
	@RequestMapping(value = "/hyntopic", method = RequestMethod.GET)
	public ModelAndView listAllTopics() {
		ModelAndView view =new ModelAndView();
		List<Category> categories = categoryservice.getAllBoards();
		view.addObject("categoryList", categories);
		List<Topic> topics = topicservice.getAllBoards();
		view.addObject("topicList",topics);
		User user = userservice.getUserById(1);
		view.addObject("user",user);
		System.out.println(categories.get(0));
		System.out.println(categories.get(1));
		view.setViewName("/hyntopic");
		return view;
	}
	
}
