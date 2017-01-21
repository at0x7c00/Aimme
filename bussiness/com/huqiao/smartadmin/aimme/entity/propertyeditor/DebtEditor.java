package com.huqiao.smartadmin.aimme.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.aimme.entity.Debt;
import com.huqiao.smartadmin.aimme.service.IDebtService;
/**
 * 负债编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class DebtEditor extends PropertyEditorSupport{
    public IDebtService debtService;
    public DebtEditor(IDebtService debtService){
        this.debtService = debtService;
    }
    public String getAsText(){
        Debt debt = (Debt)getValue();
        if(debt==null){
            return "";
        }
        return String.valueOf(debt.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Debt debt = null;
debt = debtService.getEntityByProperty(Debt.class,"manageKey",key);
if(debt==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            debt = debtService.getById(Debt.class,integerId);
}
if(key!=null && !key.trim().equals("") && debt==null){
debt=new Debt();
}
        setValue(debt);
    }
}