package com.huqiao.smartadmin.aimme.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.aimme.entity.Property;
import com.huqiao.smartadmin.aimme.service.IPropertyService;
/**
 * 资产编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class PropertyEditor extends PropertyEditorSupport{
    public IPropertyService propertyService;
    public PropertyEditor(IPropertyService propertyService){
        this.propertyService = propertyService;
    }
    public String getAsText(){
        Property property = (Property)getValue();
        if(property==null){
            return "";
        }
        return String.valueOf(property.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Property property = null;
property = propertyService.getEntityByProperty(Property.class,"manageKey",key);
if(property==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            property = propertyService.getById(Property.class,integerId);
}
if(key!=null && !key.trim().equals("") && property==null){
property=new Property();
}
        setValue(property);
    }
}