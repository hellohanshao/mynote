package com.note.dao;

import com.note.model.SubTitle;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SubTitleMapper
{
  public abstract List<SubTitle> getSubTitleList();
  
  public abstract SubTitle getSubTitle(int paramInt);
  
  public abstract List<SubTitle> getSubTitleByArr(int[] paramArrayOfInt);
  
  //通过主表id去从表中查询数据
  public abstract List<SubTitle> getSubTitleByMasterID(int relation);
  
  public abstract void insertSubTitleOne(SubTitle paramSubTitle);
  
  public abstract void updateSubTitleOne(@Param("subtitle") SubTitle paramSubTitle);
  
  public abstract void deleteSubTitleOne(int paramInt);
  
  public abstract void deleteSubTitleOneReal(int paramInt);
}