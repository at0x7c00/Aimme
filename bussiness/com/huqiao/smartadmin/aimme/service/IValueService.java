package com.huqiao.smartadmin.aimme.service;
import java.util.List;

import com.huqiao.smartadmin.aimme.entity.Value;
import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * ValueService接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IValueService extends IBaseService<Value> {
    /**
     * Value分页查询
     * @param value 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Value> Value分页信息对象
     */
    public Page<Value> getListPage(Value value,Page pageInfo);
	/**
	  * Value历史记录分页查询
	  * @param value 查询对象
	  * @param pageInfo ���页查询对象
	  * @return Page<HistoryRecord<Value>> Value历史分页信息对象
	  */
	public Page<HistoryRecord<Value>> getHistoryListPage(Value value,Page pageInfo);
	/**
	 * Value版本号查询
	 * @param version 查询版本号
	 * @return Value Value历史记录
	 */
	public Value findByVersion(Integer version);
	/**
	 * Value关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Value> Value分页信息对象
	 * 
	 */
	Page<Value> queryByKey(String queryKey, Page<Value> pageInfo);
	/**
	 * 查找多个Value
	 * @param ids id数组
	 * @return List<Value> Value列表
	 * 
	 */
	List<Value> queryById(Integer[] ids);
}