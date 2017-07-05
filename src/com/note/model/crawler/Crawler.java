package com.note.model.crawler;

import java.sql.Timestamp;

public class Crawler {
	
	//调度顺序
	private int id;
	
	//是否提前执行
	private int ifahead;
	
	//关键词
	private String keyword;
	
	//该调度状态
	private String status;
	
	//本次执行爬取数量
	private int num;
	
	//开启几个线程执行该任务
	private int threadnum;
	
	//资源类型图片 歌曲 视频
	private String type;
	
	//是否开启保存页面，默认不开启
	private String savepage;
	
	private String relation;
	
	private Timestamp starttime;
	
	private Timestamp endttime;
	
	//regex样式规则
	private String nameregex;
	private String contentregex;
	private String urlregex;
	
	private String helpurl;
	
	private String targeturl;
	//css样式规则
	private String css;
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
	 * @return the ifahead
	 */
	public int getIfahead() {
		return ifahead;
	}
	/**
	 * @param ifahead the ifahead to set
	 */
	public void setIfahead(int ifahead) {
		this.ifahead = ifahead;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the threadnum
	 */
	public int getThreadnum() {
		return threadnum;
	}
	/**
	 * @param threadnum the threadnum to set
	 */
	public void setThreadnum(int threadnum) {
		this.threadnum = threadnum;
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
	 * @return the savepage
	 */
	public String getSavepage() {
		return savepage;
	}
	/**
	 * @param savepage the savepage to set
	 */
	public void setSavepage(String savepage) {
		this.savepage = savepage;
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
	/**
	 * @return the starttime
	 */
	public Timestamp getStarttime() {
		return starttime;
	}
	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	/**
	 * @return the endttime
	 */
	public Timestamp getEndttime() {
		return endttime;
	}
	/**
	 * @param endttime the endttime to set
	 */
	public void setEndttime(Timestamp endttime) {
		this.endttime = endttime;
	}
	/**
	 * @return the nameregex
	 */
	public String getNameregex() {
		return nameregex;
	}
	/**
	 * @param nameregex the nameregex to set
	 */
	public void setNameregex(String nameregex) {
		this.nameregex = nameregex;
	}
	/**
	 * @return the contentregex
	 */
	public String getContentregex() {
		return contentregex;
	}
	/**
	 * @param contentregex the contentregex to set
	 */
	public void setContentregex(String contentregex) {
		this.contentregex = contentregex;
	}
	/**
	 * @return the urlregex
	 */
	public String getUrlregex() {
		return urlregex;
	}
	/**
	 * @param urlregex the urlregex to set
	 */
	public void setUrlregex(String urlregex) {
		this.urlregex = urlregex;
	}
	/**
	 * @return the helpurl
	 */
	public String getHelpurl() {
		return helpurl;
	}
	/**
	 * @param helpurl the helpurl to set
	 */
	public void setHelpurl(String helpurl) {
		this.helpurl = helpurl;
	}
	/**
	 * @return the targeturl
	 */
	public String getTargeturl() {
		return targeturl;
	}
	/**
	 * @param targeturl the targeturl to set
	 */
	public void setTargeturl(String targeturl) {
		this.targeturl = targeturl;
	}
	/**
	 * @return the css
	 */
	public String getCss() {
		return css;
	}
	/**
	 * @param css the css to set
	 */
	public void setCss(String css) {
		this.css = css;
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
		builder.append("Crawler [id=").append(id).append(", ifahead=").append(ifahead).append(", keyword=")
				.append(keyword).append(", status=").append(status).append(", num=").append(num).append(", threadnum=")
				.append(threadnum).append(", type=").append(type).append(", savepage=").append(savepage)
				.append(", relation=").append(relation).append(", starttime=").append(starttime).append(", endttime=")
				.append(endttime).append(", nameregex=").append(nameregex).append(", contentregex=")
				.append(contentregex).append(", urlregex=").append(urlregex).append(", helpurl=").append(helpurl)
				.append(", targeturl=").append(targeturl).append(", css=").append(css).append("]");
		return builder.toString();
	}
	
}
