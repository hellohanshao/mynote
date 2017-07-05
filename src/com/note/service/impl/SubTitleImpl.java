package com.note.service.impl;

import com.note.dao.SubTitleMapper;
import com.note.dao.TitleMapper;
import com.note.model.SubTitle;
import com.note.service.ISubTitle;
import com.note.util.BaseLogger;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTitleImpl
  extends BaseLogger
  implements ISubTitle
{
  @Autowired
  private SubTitleMapper subtitle;
  public List<SubTitle> getSubTitleList()
  {
    getLogger().info("获取子标题列表");
    return this.subtitle.getSubTitleList();
  }
  
  public SubTitle getSubTitle(int id)
  {
    getLogger().info("获取子标题:id="+id);
    return this.subtitle.getSubTitle(id);
  }
  
  public void insertSubTitleOne(SubTitle title)
  {
    getLogger().info("插入子标题:[" + title + "]");
    this.subtitle.insertSubTitleOne(title);
  }
  
  public void updateSubTitleOne(int id, SubTitle title)
  {
    getLogger().info("更新子标题id:[" + id + "][title:][" + title + "]");
    this.subtitle.updateSubTitleOne(id, title);
  }
  
  public void deleteSubTitleOne(int id)
  {
    getLogger().info("删除子标题id:[" + id + "]");
    this.subtitle.deleteSubTitleOne(id);
  }
  
  public void deleteSubTitleOneReal(int id)
  {
    getLogger().info("彻底删除子标题id:[" + id + "]");
    this.subtitle.deleteSubTitleOneReal(id);
  }
  
  public List<SubTitle> getSubTitleByArr(int[] id)
  {
	 getLogger().info("获取子标题id[]:[" + id + "]");
    return this.subtitle.getSubTitleByArr(id);
  }

	@Override
	public List<SubTitle> getSubTitleByMasterID(int relation) {
		getLogger().info("获取子标题主表TITLE ID:[" + relation + "]");
		return this.subtitle.getSubTitleByMasterID(relation);
	}
}
