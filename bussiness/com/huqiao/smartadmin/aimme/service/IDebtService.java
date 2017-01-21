package com.huqiao.smartadmin.aimme.service;
import java.util.List;

import com.huqiao.smartadmin.aimme.entity.Debt;
import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 负债Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IDebtService extends IBaseService<Debt> {
    /**
     * 负债分页查询
     * @param debt 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Debt> 负债分页信息对象
     */
    public Page<Debt> getListPage(Debt debt,Page pageInfo);
	/**
	  * 负债历史记录分页查询
	  * @param debt 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Debt>> 负债历史分页信息对象
	  */
	public Page<HistoryRecord<Debt>> getHistoryListPage(Debt debt,Page pageInfo);
	/**
	 * 负债版本号查询
	 * @param version 查询版本号
	 * @return Debt 负债历史记录
	 */
	public Debt findByVersion(Integer version);
	/**
	 * 负债关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Debt> 负债分页信息对象
	 * 
	 */
	Page<Debt> queryByKey(String queryKey, Page<Debt> pageInfo);
	/**
	 * 查找多个负债
	 * @param ids id数组
	 * @return List<Debt> 负债列表
	 * 
	 */
	List<Debt> queryById(Integer[] ids);
}