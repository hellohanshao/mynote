package com.note.controller.ftl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TestFtl {

	
	@RequestMapping(value="test",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView test(){
		ModelAndView modelAndView = new ModelAndView("ftl/test");
		modelAndView.addObject("test", "helleworld");
		return modelAndView;
	}
	
}
