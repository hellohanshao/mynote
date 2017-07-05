package com.note.model;

public class Detail {
	
	private int id;
	
	private String detailname;
	
	private String detailstatus;
	
	private String detail;
	
	private String relation;
	
	private String detailtype;
	
	private String savepath;

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
	 * @return the detailname
	 */
	public String getDetailname() {
		return detailname;
	}

	/**
	 * @param detailname the detailname to set
	 */
	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}

	/**
	 * @return the detailstatus
	 */
	public String getDetailstatus() {
		return detailstatus;
	}

	/**
	 * @param detailstatus the detailstatus to set
	 */
	public void setDetailstatus(String detailstatus) {
		this.detailstatus = detailstatus;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
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
	 * @return the detailtype
	 */
	public String getDetailtype() {
		return detailtype;
	}

	/**
	 * @param detailtype the detailtype to set
	 */
	public void setDetailtype(String detailtype) {
		this.detailtype = detailtype;
	}

	/**
	 * @return the savepath
	 */
	public String getSavepath() {
		return savepath;
	}

	/**
	 * @param savepath the savepath to set
	 */
	public void setSavepath(String savepath) {
		this.savepath = savepath;
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
		builder.append("Detail [id=").append(id).append(", detailname=").append(detailname).append(", detailstatus=")
				.append(detailstatus).append(", detail=").append(detail).append(", relation=").append(relation)
				.append(", detailtype=").append(detailtype).append(", savepath=").append(savepath).append("]");
		return builder.toString();
	}
	
}
