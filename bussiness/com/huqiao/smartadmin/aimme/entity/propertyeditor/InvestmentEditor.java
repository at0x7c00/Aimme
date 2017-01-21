package com.huqiao.smartadmin.aimme.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.aimme.entity.Investment;
import com.huqiao.smartadmin.aimme.service.IInvestmentService;
/**
 * 投资编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class InvestmentEditor extends PropertyEditorSupport{
    public IInvestmentService investmentService;
    public InvestmentEditor(IInvestmentService investmentService){
        this.investmentService = investmentService;
    }
    public String getAsText(){
        Investment investment = (Investment)getValue();
        if(investment==null){
            return "";
        }
        return String.valueOf(investment.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Investment investment = null;
investment = investmentService.getEntityByProperty(Investment.class,"manageKey",key);
if(investment==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            investment = investmentService.getById(Investment.class,integerId);
}
if(key!=null && !key.trim().equals("") && investment==null){
investment=new Investment();
}
        setValue(investment);
    }
}