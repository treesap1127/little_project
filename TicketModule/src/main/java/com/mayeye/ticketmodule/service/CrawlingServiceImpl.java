package com.mayeye.ticketmodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayeye.ticketmodule.dao.CrawlingDao;
import com.mayeye.ticketmodule.model.Crawling;
@Service

public class CrawlingServiceImpl implements CrawlingService {
	@Autowired
	CrawlingDao dao;
	@Override
	public void save(Crawling cra) {
		dao.save(cra);
	}
	@Override
	public Crawling view(int seq) {
		return dao.view(seq);
	}
	@Override
	public List<Crawling> list() {
		return dao.list();
	}

}
