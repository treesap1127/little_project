package com.mayeye.ticketmodule.model;

public class Crawling {
	private int seq;
	private String url;
	private String field;
	private String title;
	private String reserData;
	private String info;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getReserData() {
		return reserData;
	}
	public void setReserData(String reserData) {
		this.reserData = reserData;
	}

}
