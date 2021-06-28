package com.hellokoding.springboot;
import java.io.IOException;
import java.util.Date;

import com.hellokoding.springboot.model.Marks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	public static final Double TWELTH_CUMMULATIVE = 30d;

	@RequestMapping("/")
	public String hello(Model model) throws IOException {
		
		return "hello";
	}

	//twelthmarkcalculator

	@RequestMapping(value = "/twelthMarkCalculator", method = RequestMethod.GET)
	public ModelAndView usersonboarding(ModelAndView modelAndView, Marks marks) {
		logger.info("Using calc: "+ System.currentTimeMillis());
		modelAndView.addObject("marks", marks);
		modelAndView.setViewName("markscalculator");
		return modelAndView;
	}

	@RequestMapping(value = "/twelthMarkCalculator", method = RequestMethod.POST)
	public String twelthMarkCalculator(ModelAndView modelAndView, Marks marks) {

		Double _10thCummulative = (((marks.getTenthBestOne() + marks.getTenthBestTwo() + marks.getTenthBestThree()) / 300d) * 100 ) / 2;
		Double _11Language = (marks.getEleventhLanguage()/100d) * 20;
		Double _11English = (marks.getEleventhEnglish()/100d) * 20;
		Double _11Physics = (marks.getEleventhPhysics()/100d) * 20;
		Double _11Chemistry = (marks.getEleventhChemistry()/100d) * 20;
		Double _11Maths = (marks.getEleventhMaths()/100d) * 20;
		Double _11Other = (marks.getEleventhOther()/100d) * 20;

		Double _11thCummulative = ((_11Language + _11English + _11Physics + _11Chemistry + _11Maths + _11Other )/100d * 20);

		double result = _10thCummulative + _11thCummulative + TWELTH_CUMMULATIVE;
		marks.setMark((int) (result * 6));
		String resultPercent = String.format("%.2f", result);
		marks.setResult(resultPercent);
		return "markscalculator";
	}
}
