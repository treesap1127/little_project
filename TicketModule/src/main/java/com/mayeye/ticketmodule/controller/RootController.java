package com.mayeye.ticketmodule.controller;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
	@RequestMapping(value = "/make",produces = "application/text; charset=utf8")
	public @ResponseBody String make(@RequestBody Crawling cra) {
		System.out.println(cra.getUrl()+"++URL++"+cra.getField()+"++Field++"+cra.getTitle()+"++Title");
		String info = "";
		try {
			Document doc = Jsoup.connect(cra.getUrl()).get();//연결해서 가져옴
			Elements element= doc.select(cra.getField());// 원하는 부분 가져오기
				for(Element e: element) {
					info+=e.text();
				System.out.println("info="+info);
				System.out.println("test="+e.text());
				System.out.println("html="+e.html());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(info.isEmpty()) {
			return "불러오기에 실패했습니다";
		}
		System.out.println("****************************************");
		System.out.println("info="+info);
		return info;
	}
	
}
