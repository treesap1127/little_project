package com.mayeye.ticketmodule.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayeye.ticketmodule.model.Crawling;
@Repository
public class CrawlingDaoImpl implements CrawlingDao {
	@Autowired
	SqlSession sql;
	@Override
	public void save(Crawling cra) {
		sql.insert("crawling.save", cra);
	}
	@Override
	public Crawling view(int seq) {
		return sql.selectOne("crawling.view", seq);
	}
	@Override
	public List<Crawling> list() {
		return sql.selectList("crawling.list");
	}

}
