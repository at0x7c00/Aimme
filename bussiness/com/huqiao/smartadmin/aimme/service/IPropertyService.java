package com.huqiao.smartadmin.aimme.service;
import java.util.List;

import com.huqiao.smartadmin.aimme.entity.Property;
import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 资产Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IPropertyService extends IBaseService<Property> {
    /**
     * 资产分页查询
     * @param property 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Property> 资产分页信息对象
     */
    public Page<Property> getListPage(Property property,Page pageInfo);
	/**
	  * 资产历史记录分页查询
	  * @param property 查��对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Property>> 资产历史分页信息对象
	  */
	public Page<HistoryRecord<Property>> getHistoryListPage(Property property,Page pageInfo);
	/**
	 * 资产版本号查询
	 * @param version 查询版本号
	 * @return Property 资产历史记录
	 */
	public Property findByVersion(Integer version);
	/**
	 * 资产关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Property> 资产分页信息对象
	 * 
	 */
	Page<Property> queryByKey(String queryKey, Page<Property> pageInfo);
	/**
	 * 查找多个资产
	 * @param ids id数组
	 * @return List<Property> 资产列表
	 * 
	 */
	List<Property> queryById(Integer[] ids);
}