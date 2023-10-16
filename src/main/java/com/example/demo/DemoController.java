package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@RequestMapping("/hellowww")
    @ResponseBody
    // Method
    public String helloWorld(){
 
        // Print statement
        return "Hello World!";
    }
	
	@Autowired
	public DemoService demoService;
	
	@GetMapping("/")//http://localhost:8080?source=USD&target=JPY&amount=$1,525
	@ResponseBody
	public DemoVO doTransCurrency(@RequestParam String source,
									@RequestParam String target,
									@RequestParam String amount) {
		
		
		return demoService.getResult(source, target, amount);
	}
	
}
