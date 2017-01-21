package com.huqiao.smartadmin.aimme.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.huqiao.smartadmin.aimme.entity.Property;
import com.huqiao.smartadmin.common.dao.IBaseDao;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 资产DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IPropertyDao extends IBaseDao<Property> {
    /**
     * 资产查询记录数量
     * @param property 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Property property);
	/**
	 * 资产历史记录数量
     * @param property 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Property property,Page pageInfo);
    /**
     * 资产分页查询
     * @param property 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Property>  资产列表 
     */
    List<Property> findListPage(Property property, Page pageInfo);
	/**
	 * 资产历史记录分页查询
     * @param property 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Property>>  资产历史列表
	 */
    List<HistoryRecord<Property>> findHistoryListPage(Property property, Page pageInfo);
	/**
     * 资产版本号查询
     * @param version 版本号
	 * @return Property 资产历史记录
     */
	Property findByVersion(Integer version);
	/**
	 * 添加资产查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param property 查询对象
	 */
	public void queryCause(Criteria criteria, Property property);
	/**
	 * 资产关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Property> 资产列表
	 */
	List<Property> findByKey(Page pageInfo,String queryKey);
	/**
	 * 资产关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个资产
     * @param  ids id数组
	 * @return List<Property>  资产列表
     */
	List<Property> findById(Integer[] ids);
}