package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	String answer="";
	String question="";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {
		LoginBean bean = new LoginBean();
		System.out.println(bean.getAnswer());
		System.out.println(bean.getQuestion());
		answer = bean.getAnswer();
		question=bean.getQuestion();  
		model.addAttribute("question", question);  
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		model.addAttribute("question", question);  	
		if (loginBean.getAnswer().equals(answer) ) {
			model.addAttribute("msg", loginBean.getAnswer());
			return "success";
		} else {
			model.addAttribute("error", "Invalid Details");
			return "login";
		}
	}
}
