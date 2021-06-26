package com.hellokoding.springboot;
import java.io.IOException;

import com.hellokoding.springboot.model.Marks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	public static final Double TWELTH_CUMMULATIVE = 30d;

	@RequestMapping("/")
	public String hello(Model model) throws IOException {
		
		return "hello";
	}

	//twelthmarkcalculator

	@RequestMapping(value = "/twelthMarkCalculator", method = RequestMethod.GET)
	public ModelAndView usersonboarding(ModelAndView modelAndView, Marks marks) {
		modelAndView.addObject("marks", marks);
		modelAndView.setViewName("markscalculator");
		return modelAndView;
	}

	@RequestMapping(value = "/twelthMarkCalculator", method = RequestMethod.POST)
	public String twelthMarkCalculator(ModelAndView modelAndView, Marks marks) {

		Double _10thCummulative = (((marks.getTenthBestOne() + marks.getTenthBestTwo() + marks.getTenthBestThree()) / 300d) * 100 ) / 2;
		Double _11thCummulative = ((((marks.getEleventhTotal() - 120)/480d) * 100) / 100d ) * 20;

		Double result = _10thCummulative + _11thCummulative + TWELTH_CUMMULATIVE;
		marks.setResult(String.format("%.2f", result));
		return "markscalculator";
	}
}
