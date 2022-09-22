package com.mayeye.ticketmodule.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mayeye.ticketmodule.model.Crawling;
import com.mayeye.ticketmodule.service.CrawlingService;
@Controller
public class RootController {
	@Autowired
	CrawlingService service;
	

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
			System.out.println(doc.getAllElements()); 
			Elements element= doc.select(cra.getField());// 원하는 부분 가져오기
			int num=1;
				for(Element e: element) {
					//info+=e.text()+"="+num+"\n" ;
					info+=e.html();
					System.out.println("info="+info);// 몇번째까지 넣은
					System.out.println("test="+e.text());// 이게 순수 정보
					System.out.println("html="+e.html());// 이게 태그 포함 정보
					num++;
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
	
	@RequestMapping(value = "/save",produces = "application/text; charset=utf8")
	public @ResponseBody String save(@RequestBody Crawling cra) {
		System.out.println(cra.getUrl()+"++URL++"+cra.getField()+"++Field++"+cra.getTitle()+"++Title");
		Date now=new Date();
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd");
		cra.setReserData(sfd.format(now));
		
			service.save(cra);
		
		return "success";
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<Crawling> list = service.list();
		model.addAttribute("list", list);
		return "crawling/list";
	}
	@GetMapping("/view")
	public String view(@RequestParam int seq,Model model) {
		Crawling item =service.view(seq);
		String info="";
		try {
			Document doc = Jsoup.connect(item.getUrl()).get();//연결해서 가져옴
			Elements element= doc.select(item.getField());// 원하는 부분 가져오기
			int num=1;
				for(Element e: element) {
					info+=e.text()+"="+num+"\n" ;
				System.out.println("info="+info);// 몇번째까지 넣은
				System.out.println("test="+e.text());// 이게 순수 정보
				System.out.println("html="+e.html());// 이게 태그 포함 정보
				num++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(info.isEmpty()) {
			return "crawling/list";
		}
		item.setInfo(info);
		
		model.addAttribute("item", item);
		return "crawling/view";
	}
	
	@GetMapping("selenium")
	public String selenium() {
		return "selenium/make";
	}
	@RequestMapping(value = "/makeSe",produces = "application/text; charset=utf8")
	public @ResponseBody String makeSe(@RequestBody Crawling cra) {
		// 1. 드라이버 설치 경로
		String DRIVER_ID = "webdriver.chrome.driver";
		String DRIVER_PATH = "D:/selenium/chromedriver.exe";
				
		System.setProperty(DRIVER_ID, DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		String info = "";
		try {
			driver.get(cra.getUrl());
			Thread.sleep(3000);
			System.out.println(driver.getPageSource());
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeAsyncScript(cra.getScriptText());
			Thread.sleep(4000);
			List<WebElement> webElement=driver.findElements(By.cssSelector(cra.getField()));
			
			for(WebElement el: webElement) {
				info+=el.getText();
				el.getText();
			}
			 driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(info.isEmpty()) {
			return "fail";
		}
		return info;
	}
	
	@RequestMapping(value = "/saveSe",produces = "application/text; charset=utf8")
	public @ResponseBody String saveSe(@RequestBody Crawling cra) {
		System.out.println(cra.getUrl()+"++URL++"+cra.getField()+"++Field++"+cra.getTitle()+"++Title");
		Date now=new Date();
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd");
		cra.setReserData(sfd.format(now));
		
			service.Sesave(cra);
		
		return "success";
	}
}
