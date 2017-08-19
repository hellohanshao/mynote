package com.note.model;


public class TaskGroup {

	private int id;
	private String groupname;
	private int tasknumber;
	private String describe;
	private String isstart;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id =id;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public int getTasknumber() {
		return tasknumber;
	}
	public void setTasknumber(int tasknumber) {
		this.tasknumber = tasknumber;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getIsstart() {
		return isstart;
	}
	public void setIsstart(String isstart) {
		this.isstart = isstart;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((groupname == null) ? 0 : groupname.hashCode());
		result = prime * result + id;
		result = prime * result + ((isstart == null) ? 0 : isstart.hashCode());
		result = prime * result + tasknumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskGroup other = (TaskGroup) obj;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (groupname == null) {
			if (other.groupname != null)
				return false;
		} else if (!groupname.equals(other.groupname))
			return false;
		if (id != other.id)
			return false;
		if (isstart == null) {
			if (other.isstart != null)
				return false;
		} else if (!isstart.equals(other.isstart))
			return false;
		if (tasknumber != other.tasknumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TaskGroup [id=" + id + ", groupname=" + groupname + ", tasknumber=" + tasknumber + ", describe="
				+ describe + ", isstart=" + isstart + "]";
	}
	
	
	
	
}