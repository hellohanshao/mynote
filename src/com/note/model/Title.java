package com.note.model;

public class Title {

	private int id;
	
	private String title;
	
	private String titleStatus;
	
	private String relation;
	
	private String remark;
	
	private String isdefaultload;
	
	private String controller;

	/**
	 * @return the controller
	 */
	public String getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(String controller) {
		this.controller = controller;
	}

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the titleStatus
	 */
	public String getTitleStatus() {
		return titleStatus;
	}

	/**
	 * @param titleStatus the titleStatus to set
	 */
	public void setTitleStatus(String titleStatus) {
		this.titleStatus = titleStatus;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the isdefaultload
	 */
	public String getIsdefaultload() {
		return isdefaultload;
	}

	/**
	 * @param isdefaultload the isdefaultload to set
	 */
	public void setIsdefaultload(String isdefaultload) {
		this.isdefaultload = isdefaultload;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 日期：2017年7月1日
	 * 作者：李小波
	 * TODO
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Title [id=").append(id).append(", title=").append(title).append(", titleStatus=")
				.append(titleStatus).append(", relation=").append(relation).append(", remark=").append(remark)
				.append(", isdefaultload=").append(isdefaultload).append("]");
		return builder.toString();
	}

	
	
	
}
