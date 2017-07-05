package com.note.model;

import java.sql.Timestamp;

/**
 * 
 * 日期：2017年7月2日 作者：李小波 TODO
 */
public class Setting {

	private int id;
	private String setname;
	private String relation;
	private String remark;
	private String status;
	private Timestamp createtime;
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
	 * @return the setname
	 */
	public String getSetname() {
		return setname;
	}
	/**
	 * @param setname the setname to set
	 */
	public void setSetname(String setname) {
		this.setname = setname;
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
	 * @return the createtime
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 日期：2017年7月2日
	 * 作者：李小波
	 * TODO
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Setting [id=").append(id).append(", setname=").append(setname).append(", relation=")
				.append(relation).append(", remark=").append(remark).append(", status=").append(status)
				.append(", createtime=").append(createtime).append("]");
		return builder.toString();
	}
	
}
