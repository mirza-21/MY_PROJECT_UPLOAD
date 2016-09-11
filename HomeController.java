package com.niit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView showlandingpage() {

		ModelAndView mv = new ModelAndView("Home");

		return mv;
	}
	@RequestMapping("home")
	public ModelAndView showHome() {

		ModelAndView mv = new ModelAndView("Home");

		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView showLogin() {

		ModelAndView mv = new ModelAndView("Login");

		return mv;
	}

	@RequestMapping("/Register")
	public ModelAndView showregister() {

		ModelAndView mv = new ModelAndView("Register");

		return mv;
	}

	@RequestMapping("/Contact")
	public ModelAndView showcontact() {

		ModelAndView mv = new ModelAndView("Contact");

		return mv;
	}

	@RequestMapping("/Aboutus")
	public ModelAndView showaboutus() {

		ModelAndView mv = new ModelAndView("Aboutus");

		return mv;
	}



	
}