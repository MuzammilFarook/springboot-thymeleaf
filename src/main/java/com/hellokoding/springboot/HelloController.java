package com.hellokoding.springboot;

import com.hellokoding.springboot.model.Marks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;

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
		Double _11Language = (marks.getEleventhLanguage()/90d) * 20;
		Double _11English = (marks.getEleventhEnglish()/90d) * 20;
		Double _11Physics = (marks.getEleventhPhysics()/70d) * 20;
		Double _11Chemistry = (marks.getEleventhChemistry()/70d) * 20;
		Double _11Maths = (marks.getEleventhMaths()/90d) * 20;
		Double _11Other = (marks.getEleventhOther()/70d) * 20;

		Double _11thCummulative = _11Language + _11English + _11Physics + _11Chemistry + _11Maths + _11Other;

		double v = ((_10thCummulative + TWELTH_CUMMULATIVE) * 6) + _11thCummulative;
		marks.setMark(new BigDecimal(String.valueOf(v)).setScale(2, BigDecimal.ROUND_HALF_UP).intValue());
		String resultPercent = String.format("%.2f", v/6d);
		marks.setResult(resultPercent);
		return "markscalculator";
	}
}
