package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}

//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "dunia") String name,
//			Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}

	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}

//	@RequestMapping(value = {"/multiplication", "/multiplication/{a}/{b}"})
//	public String perkalianPath(@PathVariable Optional<Integer> a, @PathVariable Optional<Integer> b, Model model) {
//		int c = 0;
//		if (a.isPresent() && b.isPresent()) {
//			model.addAttribute("a", a.get());
//			model.addAttribute("b", b.get());
//			c = a.get() * b.get();
//			model.addAttribute("c", c);
//		} else {
//			model.addAttribute("a", c);
//			model.addAttribute("b", c);
//			model.addAttribute("c", c);
//		}
//		return "perkalian";
//	}

	@RequestMapping("/perkalian")
	public String kali(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b, Model model) {
		int c = 0;
		if (a != 0 && b != 0) {
			model.addAttribute("a", a);
			model.addAttribute("b", b);
			c = a * b;
			model.addAttribute("c", c);
		} else {
			model.addAttribute("a", c);
			model.addAttribute("b", c);
			model.addAttribute("c", c);
		}
		return "perkalian";
	}
}