package com.huqiao.smartadmin.aimme.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.aimme.entity.MonthSummary;
import com.huqiao.smartadmin.aimme.service.IMonthSummaryService;
/**
 * 月资金结余编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class MonthSummaryEditor extends PropertyEditorSupport{
    public IMonthSummaryService monthSummaryService;
    public MonthSummaryEditor(IMonthSummaryService monthSummaryService){
        this.monthSummaryService = monthSummaryService;
    }
    public String getAsText(){
        MonthSummary monthSummary = (MonthSummary)getValue();
        if(monthSummary==null){
            return "";
        }
        return String.valueOf(monthSummary.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        MonthSummary monthSummary = null;
monthSummary = monthSummaryService.getEntityByProperty(MonthSummary.class,"manageKey",key);
if(monthSummary==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            monthSummary = monthSummaryService.getById(MonthSummary.class,integerId);
}
if(key!=null && !key.trim().equals("") && monthSummary==null){
monthSummary=new MonthSummary();
}
        setValue(monthSummary);
    }
}