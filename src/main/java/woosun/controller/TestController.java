package woosun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import woosun.domain.RestResponse;
import woosun.service.RecaptchaService;


@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	@Value("${google.recaptcha.site.key}")
	private String recaptchaSiteKey;
	
	@Autowired
	private RecaptchaService recaptchaService;

	@RequestMapping(value = "/test1")
	public String test1(HttpServletRequest request, Model model){
		
		model.addAttribute("firstName", "Choi");
		model.addAttribute("lastName", "Woosun");
		
		return "test";
	}
	
	@RequestMapping(value = "/recaptcha")
	public String recaptchaGet(HttpServletRequest request, Model model){
		
		model.addAttribute("siteKey", recaptchaSiteKey);
		
		return "recaptcha_test";
	}
	
	@RequestMapping(value = "/recaptcha", method=RequestMethod.POST)
	@ResponseBody
	public RestResponse recaptchaPost(HttpServletRequest request, Model model,
			@RequestParam("g-recaptcha-response") String recaptchaResponse){
		
		boolean isSuccess = 
		recaptchaService.isAuthRecaptcha(recaptchaResponse);
		
		RestResponse restResponse = new RestResponse();
		if(!isSuccess){
			restResponse.setCode(99);
		}
		model.addAttribute("isSuccess", isSuccess);
		
		return restResponse;
	}


	
}
