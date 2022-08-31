package com.mayeye.ticketmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import crawling.Crawling;
@Controller
public class RootController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("crawling")
	public String crawling() {
		
		return "crawling/make";
	}
	@ResponseBody
	@PostMapping("/make")
	public String make(@RequestBody Crawling cra) {
		System.out.println(cra.getURL()+"++URL++"+cra.getField()+"++Field++"+cra.getTitle()+"++Title");
		return "test";
	}
}
