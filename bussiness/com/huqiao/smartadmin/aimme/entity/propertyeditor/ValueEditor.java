package com.huqiao.smartadmin.aimme.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.aimme.entity.Value;
import com.huqiao.smartadmin.aimme.service.IValueService;
/**
 * Value编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class ValueEditor extends PropertyEditorSupport{
    public IValueService valueService;
    public ValueEditor(IValueService valueService){
        this.valueService = valueService;
    }
    public String getAsText(){
        Value value = (Value)getValue();
        if(value==null){
            return "";
        }
        return String.valueOf(value.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Value value = null;
value = valueService.getEntityByProperty(Value.class,"manageKey",key);
if(value==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            value = valueService.getById(Value.class,integerId);
}
if(key!=null && !key.trim().equals("") && value==null){
value=new Value();
}
        setValue(value);
    }
}