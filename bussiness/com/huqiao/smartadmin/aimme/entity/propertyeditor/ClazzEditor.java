package com.huqiao.smartadmin.aimme.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.aimme.entity.Clazz;
import com.huqiao.smartadmin.aimme.service.IClazzService;
/**
 * Class编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class ClazzEditor extends PropertyEditorSupport{
    public IClazzService clazzService;
    public ClazzEditor(IClazzService clazzService){
        this.clazzService = clazzService;
    }
    public String getAsText(){
        Clazz clazz = (Clazz)getValue();
        if(clazz==null){
            return "";
        }
        return String.valueOf(clazz.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Clazz clazz = null;
clazz = clazzService.getEntityByProperty(Clazz.class,"manageKey",key);
if(clazz==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            clazz = clazzService.getById(Clazz.class,integerId);
}
if(key!=null && !key.trim().equals("") && clazz==null){
clazz=new Clazz();
}
        setValue(clazz);
    }
}