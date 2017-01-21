package com.huqiao.smartadmin.aimme.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.huqiao.smartadmin.aimme.entity.Value;
import com.huqiao.smartadmin.common.dao.IBaseDao;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * ValueDAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IValueDao extends IBaseDao<Value> {
    /**
     * Value查询记录数量
     * @param value 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Value value);
	/**
	 * Value历史记录数量
     * @param value 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Value value,Page pageInfo);
    /**
     * Value分页查询
     * @param value 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Value>  Value列表 
     */
    List<Value> findListPage(Value value, Page pageInfo);
	/**
	 * Value历史记录分页查询
     * @param value 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Value>>  Value历史列表
	 */
    List<HistoryRecord<Value>> findHistoryListPage(Value value, Page pageInfo);
	/**
     * Value版本号查询
     * @param version 版本号
	 * @return Value Value历史记录
     */
	Value findByVersion(Integer version);
	/**
	 * 添加Value查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param value 查询对象
	 */
	public void queryCause(Criteria criteria, Value value);
	/**
	 * Value关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Value> Value列表
	 */
	List<Value> findByKey(Page pageInfo,String queryKey);
	/**
	 * Value关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个Value
     * @param  ids id数组
	 * @return List<Value>  Value列表
     */
	List<Value> findById(Integer[] ids);
}