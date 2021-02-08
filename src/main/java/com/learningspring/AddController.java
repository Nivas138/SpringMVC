package com.learningspring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	
	@RequestMapping("/addition")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
		int i,j,k;
		i = Integer.parseInt(request.getParameter("ip1"));
		j = Integer.parseInt(request.getParameter("ip2"));
		k = i + j;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("res", k);
		return mv;
	}

}
