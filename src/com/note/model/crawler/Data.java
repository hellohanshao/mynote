package com.note.model.crawler;

import java.sql.Timestamp;


public class Data {
	
	private int id;
	
	private String name;
	
	private String status;
	
	private String content;
	
	private Timestamp savetime;
	
	private String url;
	
	private String page;
	
	private String type;
	
	private String relation;
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println("====================");
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the savetime
	 */
	public Timestamp getSavetime() {
		return savetime;
	}

	/**
	 * @param savetime the savetime to set
	 */
	public void setSavetime(Timestamp savetime) {
		this.savetime = savetime;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the relation
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * @param relation the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 日期：2017年7月4日
	 * 作者：李小波
	 * TODO
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonModel [id=").append(id).append(", name=").append(name).append(", status=").append(status)
				.append(", content=").append(content).append(", savetime=").append(savetime).append(", url=")
				.append(url).append(", page=").append(page).append(", type=").append(type).append(", relation=")
				.append(relation).append("]");
		return builder.toString();
	}
	

	
}
