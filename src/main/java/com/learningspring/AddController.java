package com.learningspring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learingspring.service.AddService;
import com.learingspring.service.SaveService;
import com.learningspring.DAO.UserDetails;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
		int id;
		String username,email;
		id = Integer.parseInt(request.getParameter("id"));
		username = request.getParameter("name");
		email = request.getParameter("emailid");
		
		UserDetails us = new UserDetails();
		us.setId(id);
		us.setName(username);
		us.setEmail(email);
		
		SaveService ss = new SaveService();
		ss.save(us);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("res", "done");
		return mv;
	}

}
