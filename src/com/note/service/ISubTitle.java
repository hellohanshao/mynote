package com.note.service;

import com.note.model.SubTitle;
import java.util.List;

public abstract interface ISubTitle
{
  public abstract List<SubTitle> getSubTitleList();
  
  public abstract SubTitle getSubTitle(int ID);
  
  public abstract List<SubTitle> getSubTitleByArr(int[] ID);
  
  //通过主表id去从表中查询数据
  public abstract List<SubTitle> getSubTitleByMasterID(int id);
  
  public abstract void insertSubTitleOne(SubTitle SubTitle);
  
  public abstract void updateSubTitleOne(SubTitle SubTitle);
  
  public abstract void deleteSubTitleOne(int ID);
  
  public abstract void deleteSubTitleOneReal(int ID);
}
