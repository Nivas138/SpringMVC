package com.learningspring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.learingspring.service.SaveService;
import com.learningspring.DAO.UserDetails;
import com.learningspring.DAO.UserNames;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
		int id;
		String username,email;
		id = Integer.parseInt(request.getParameter("id"));
		username = request.getParameter("uname");
		email = request.getParameter("emailid");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String middlename = request.getParameter("mname");
		UserNames us = new UserNames();
		us.setFirstname(firstname);
		us.setLastname(lastname);
		us.setMiddlename(middlename);
		
		UserDetails usr = new UserDetails();
		usr.setId(id);
		usr.setName(username);
		usr.setEmail(email);
		usr.setUserfullname(us);
		
		SaveService ss = new SaveService();
		ss.save(usr);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("res", "Done");
		return mv;
	}
	
	@RequestMapping("/user")
	public ModelAndView view(@RequestParam("id") int id) {
		ModelAndView mv1 = new ModelAndView();
		mv1.setViewName("display");
		SaveService ss = new SaveService();
		mv1.addObject("res",ss.get(id));
		return mv1;
		
	}

}
