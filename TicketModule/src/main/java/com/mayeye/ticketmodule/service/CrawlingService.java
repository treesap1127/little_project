package com.mayeye.ticketmodule.service;

import java.util.List;

import com.mayeye.ticketmodule.model.Crawling;

public interface CrawlingService {

	void save(Crawling cra);

	Crawling view(int seq);

	List<Crawling> list();

	void Sesave(Crawling cra);

}
