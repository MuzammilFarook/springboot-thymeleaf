package com.hellokoding.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	public static final Double TWELTH_CUMMULATIVE = 30d;
	@Autowired
	private ResourceLoader resourceLoader;


	@RequestMapping("/")
	public String hello(Model model) throws IOException {
		
		return "markscalculator";
	}

	@RequestMapping("/about")
	public String about(Model model) throws IOException {

		return "hello";
	}

	//twelthmarkcalculator

	@RequestMapping(value = "/twelthMarkCalculator", method = RequestMethod.GET)
	public String twelthMarkCalculator() {
		return "markscalculator";
	}

//	@RequestMapping(value = "/twelthMarkCalculator", method = RequestMethod.GET)
//	public ModelAndView usersonboarding(ModelAndView modelAndView, Marks marks) {
//		logger.info("Using calc: "+ System.currentTimeMillis());
//		modelAndView.addObject("marks", marks);
//		modelAndView.setViewName("markscalculator");
//		return modelAndView;
//	}

//	@RequestMapping(value = "/twelthMarkCalculator", method = RequestMethod.POST)
//	public String twelthMarkCalculator(ModelAndView modelAndView, Marks marks) {
//
//		Double _10thCummulative = (((marks.getTenthBestOne() + marks.getTenthBestTwo() + marks.getTenthBestThree()) / 300d) * 100 ) / 2;
//		Double _11Language = (marks.getEleventhLanguage()/90d) * 20;
//		Double _11English = (marks.getEleventhEnglish()/90d) * 20;
//		Double _11Physics = (marks.getEleventhPhysics()/70d) * 20;
//		Double _11Chemistry = (marks.getEleventhChemistry()/70d) * 20;
//		Double _11Maths = (marks.getEleventhMaths()/90d) * 20;
//		Double _11Other = (marks.getEleventhOther()/70d) * 20;
//
//		int language = (int) Math.rint(_10thCummulative + TWELTH_CUMMULATIVE + _11Language);
//		int english = (int) Math.rint(_10thCummulative + TWELTH_CUMMULATIVE + _11English);
//		int physics = (int) Math.rint(_10thCummulative + TWELTH_CUMMULATIVE + _11Physics);
//		int chemistry = (int) Math.rint(_10thCummulative + TWELTH_CUMMULATIVE + _11Chemistry);
//		int maths = (int) Math.rint(_10thCummulative + TWELTH_CUMMULATIVE + _11Maths);
//		int other = (int) Math.rint(_10thCummulative + TWELTH_CUMMULATIVE + _11Other);
//
//		int mark = language + english + physics + chemistry + maths + other;
//		marks.setMark(mark);
//		String resultPercent = String.format("%.2f", mark/6d);
//		marks.setResult(resultPercent);
//		return "markscalculator";
//	}

//	@RequestMapping(value = { "/download-marksDocument" }, method = RequestMethod.GET)
//	public void downloadDocument(HttpServletResponse response, Model model) throws IOException {
//		Resource resource = resourceLoader.getResource("classpath:static/book.xlsx");
//		String mimeType = URLConnection.guessContentTypeFromName("static/book.xlsx");
//		response.setContentType(mimeType);
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + "static/book.xlsx" + "\"");
//		InputStream document = resource.getInputStream();
//		FileCopyUtils.copy(document, response.getOutputStream());
//	}
}
