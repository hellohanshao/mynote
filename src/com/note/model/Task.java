package com.note.model;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

	private int id;
	
	private String taskname;
	
	private String domain;
	
	private String pattern;
	
	private String keyword;
	
	private String isadd;
	
	private String fid;
	
	private String immediately;
	
	private String describe;
	
	private String groupname;
	
	private Date starttime;
	
	public Date getStarttime() {
		return starttime;
	}
	
	public void setStarttime(Date starttime) {
		
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		if(starttime==null || starttime.equals("")){
			this.starttime = new Timestamp(System.currentTimeMillis());
		}else{
			Timestamp t = new Timestamp(System.currentTimeMillis());
			starttime = dateFormat.format(starttime);
			this.starttime = t.valueOf(starttime);
		}
		*/
		this.starttime = starttime;
		
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	private Date endtime;
	
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getIsadd() {
		return isadd;
	}

	public void setIsadd(String isadd) {
		this.isadd = isadd;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getImmediately() {
		return immediately;
	}

	public void setImmediately(String immediately) {
		this.immediately = immediately;
	}

/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((endtime == null) ? 0 : endtime.hashCode());
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		result = prime * result + id;
		result = prime * result + ((immediately == null) ? 0 : immediately.hashCode());
		result = prime * result + ((isadd == null) ? 0 : isadd.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + ((starttime == null) ? 0 : starttime.hashCode());
		result = prime * result + ((taskname == null) ? 0 : taskname.hashCode());
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
		Task other = (Task) obj;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (endtime == null) {
			if (other.endtime != null)
				return false;
		} else if (!endtime.equals(other.endtime))
			return false;
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
			return false;
		if (id != other.id)
			return false;
		if (immediately == null) {
			if (other.immediately != null)
				return false;
		} else if (!immediately.equals(other.immediately))
			return false;
		if (isadd == null) {
			if (other.isadd != null)
				return false;
		} else if (!isadd.equals(other.isadd))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		if (starttime == null) {
			if (other.starttime != null)
				return false;
		} else if (!starttime.equals(other.starttime))
			return false;
		if (taskname == null) {
			if (other.taskname != null)
				return false;
		} else if (!taskname.equals(other.taskname))
			return false;
		return true;
	}
*/
	@Override
	public String toString() {
		return "Task [id=" + id + ", taskname=" + taskname + ", domain=" + domain + ", pattern=" + pattern
				+ ", keyword=" + keyword + ", isadd=" + isadd + ", fid=" + fid + ", immediately=" + immediately
				+ ", describe=" + describe + ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}

	
	
}