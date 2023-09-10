package com.sam.springboot.SpringTutorialYoutube;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class HomeController {
//	@RequestMapping(value = "/")
//	public static String Welcome() {
//		return "Welcome to springboot tutorial \n" +
//				"This is Home controller";
//	}
//}

@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public static String Welcome() {
		return "index";
	}
}
