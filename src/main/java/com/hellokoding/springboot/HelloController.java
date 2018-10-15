package com.hellokoding.springboot;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello(Model model) throws  IOException{
       	    String shutdownCommand;
		    String operatingSystem = System.getProperty("os.name");

		    if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
		        shutdownCommand = "shutdown -h now";
		    }
		    else if ("Windows".equals(operatingSystem)) {
		        shutdownCommand = "shutdown.exe -s -t 0";
		    }
		    else {
		        throw new RuntimeException("Unsupported operating system.");
		    }

		    Runtime.getRuntime().exec(shutdownCommand);
		    System.exit(0);
        return "hello";
    }
}
