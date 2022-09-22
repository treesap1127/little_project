package com.mayeye.ticketmodule.model;

public class Crawling {
	private int seq;
	private String url;
	private String field;
	private String title;
	private String reserData;
	private String info;
	private String tag;
	private String scriptText;
	private String header;
	
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
	public String getScriptText() {
		return scriptText;
	}
	public void setScriptText(String scriptText) {
		this.scriptText = scriptText;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}

}
