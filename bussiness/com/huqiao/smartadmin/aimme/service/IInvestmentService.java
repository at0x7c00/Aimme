package com.huqiao.smartadmin.aimme.service;
import java.util.List;

import com.huqiao.smartadmin.aimme.entity.Investment;
import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 投资Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IInvestmentService extends IBaseService<Investment> {
    /**
     * 投资分页查询
     * @param investment 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Investment> 投资分页信息对象
     */
    public Page<Investment> getListPage(Investment investment,Page pageInfo);
	/**
	  * 投资历史记录分页查询
	  * @param investment 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Investment>> 投资历史分页信息对象
	  */
	public Page<HistoryRecord<Investment>> getHistoryListPage(Investment investment,Page pageInfo);
	/**
	 * 投资版本号查询
	 * @param version 查询版本号
	 * @return Investment 投资历史记录
	 */
	public Investment findByVersion(Integer version);
	/**
	 * 投资关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Investment> 投资分页信息对象
	 * 
	 */
	Page<Investment> queryByKey(String queryKey, Page<Investment> pageInfo);
	/**
	 * 查找多个投资
	 * @param ids id数组
	 * @return List<Investment> 投资列表
	 * 
	 */
	List<Investment> queryById(Integer[] ids);
}