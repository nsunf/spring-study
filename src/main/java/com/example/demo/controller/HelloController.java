package com.example.demo.controller;


import java.util.HashMap;
import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Person;

@RestController
public class HelloController {
	
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)

	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!!!";
	}
	
	@GetMapping("/var/{variable}")
	public String getVar(@PathVariable String variable) {
		return "Hello, " + variable + "!!";
	}

	@GetMapping("/var2/{variable}")
	public String getVar2(@PathVariable("variable") String hoho) {
		return "Hello, " + hoho + "!!";
	}
	
	@GetMapping("/param")
	public String getParam(@RequestParam String id, @RequestParam("name") String n) {
		return id + " " + n;
	}

	@GetMapping("/param2")
	public String getParam2(@RequestParam HashMap<String, String> map) {
		Iterator<String> it = map.keySet().iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			String key = it.next();
			sb.append(key).append(" | ").append(map.get(key));
			System.out.println("--> " + map.get(key));
		}

		return sb.toString();
	}
	
	@GetMapping("/person")
	public String getPerson(Person person) {
		return person.toString();
	}
}
