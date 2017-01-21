package com.huqiao.smartadmin.tag.fns;

import com.huqiao.smartadmin.util.web.Page;

/**
 * 计算DataTable列的排序样式
 * @author NOVOTS
 * @version Version 1.0
 */
public class SortClassFunction {

	public static String sortClass(Page pageInfo,String fieldName){
		if(pageInfo==null){
			return "";
		}
		if(pageInfo.getOrderField()!=null && pageInfo.getOrderField().equals(fieldName)){
			return "sorting sorting_" + pageInfo.getOrderDirection();
		}
		return "sorting";
	}
}
