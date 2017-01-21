package com.huqiao.smartadmin.aimme.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.aimme.entity.Target;
import com.huqiao.smartadmin.aimme.service.ITargetService;
/**
 * 目标编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class TargetEditor extends PropertyEditorSupport{
    public ITargetService targetService;
    public TargetEditor(ITargetService targetService){
        this.targetService = targetService;
    }
    public String getAsText(){
        Target target = (Target)getValue();
        if(target==null){
            return "";
        }
        return String.valueOf(target.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Target target = null;
target = targetService.getEntityByProperty(Target.class,"manageKey",key);
if(target==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            target = targetService.getById(Target.class,integerId);
}
if(key!=null && !key.trim().equals("") && target==null){
target=new Target();
}
        setValue(target);
    }
}