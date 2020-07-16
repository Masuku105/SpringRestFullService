package com.masuku105.restFullWebService.RestFullWebService.HelloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
	//@RequestMapping(method=RequestMethod.GET,path="/hello-wolrd")
	@GetMapping(path="/hello-wolrd")
	public String helloWorld() {
		return "Hello Wolrd";
	}

	@GetMapping(path="/hello-wolrd-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("Some error has happened");
		return new HelloWorldBean("Hello Wolrd Get Welcome Message called from the java Rest Controller");
	}
	
	@GetMapping(path="/hello-wolrd-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Ohh Hey Hello %s", name)); 
	}

}
