package com.mayeye.ticketmodule.dao;

import java.util.List;

import com.mayeye.ticketmodule.model.Crawling;

public interface CrawlingDao {

	void save(Crawling cra);

	Crawling view(int seq);

	List<Crawling> list();

}
