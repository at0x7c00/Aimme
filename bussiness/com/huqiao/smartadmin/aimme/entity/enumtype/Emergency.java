package com.huqiao.smartadmin.aimme.entity.enumtype;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 紧急程度<br>  Low("低"),Mid("中"),High("高");
 * @author NOVOTS
 * @version Version 1.0
 */
public enum Emergency{
    Low("低"),Mid("中"),High("高");
 /**  description 描述信息*/
    private String description;
    private Emergency(String description){this.description = description;}
    /**
	  *  获取描述信息
      * @return String 描述信息
	  */
    public String getDescription(){return description;}
    /**
	  * 枚举对象-描述信息 键值对
      * @return Map<Emergency,String> 枚举对象-描述信息 键值对
	  */
    public final static Map<Emergency,String> emergencyMap = new LinkedHashMap<Emergency,String>();
    static{
        for(Emergency s : Emergency.values()){
          emergencyMap.put(s,s.getDescription());  
        }
    }
}