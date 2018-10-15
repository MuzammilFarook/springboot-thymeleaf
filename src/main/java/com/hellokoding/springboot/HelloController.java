package com.hellokoding.springboot;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/shutdown")
	public String hello(Model model) throws IOException {
		String shutdownCommand;
		String operatingSystem = System.getProperty("os.name");
		System.out.println(operatingSystem + "Operating sys");
		if (operatingSystem.contains("Linux") || operatingSystem.contains("Mac OS X")) {
			shutdownCommand = "shutdown -h now";
		} else if (operatingSystem.contains("Windows")) {
			shutdownCommand = "shutdown.exe -s -t 0";
		} else {
			throw new RuntimeException("Unsupported operating system...........");
		}

		Runtime.getRuntime().exec(shutdownCommand);
		System.exit(0);
		return "hello";
	}
}
