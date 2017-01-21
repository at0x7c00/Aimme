package com.huqiao.smartadmin.aimme.service;
import java.util.List;

import com.huqiao.smartadmin.aimme.entity.MonthSummary;
import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 月资金结余Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IMonthSummaryService extends IBaseService<MonthSummary> {
    /**
     * 月资金结余分页查询
     * @param monthSummary 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<MonthSummary> 月资金结余分页信息对象
     */
    public Page<MonthSummary> getListPage(MonthSummary monthSummary,Page pageInfo);
	/**
	  * 月资金结余历史记录分页查询
	  * @param monthSummary 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<MonthSummary>> 月资金结余历史分页信息对象
	  */
	public Page<HistoryRecord<MonthSummary>> getHistoryListPage(MonthSummary monthSummary,Page pageInfo);
	/**
	 * 月资金结余版本号查询
	 * @param version 查询版本号
	 * @return MonthSummary 月资金结余历史记录
	 */
	public MonthSummary findByVersion(Integer version);
	/**
	 * 月资金结余关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<MonthSummary> 月资金结余分页信息对象
	 * 
	 */
	Page<MonthSummary> queryByKey(String queryKey, Page<MonthSummary> pageInfo);
	/**
	 * 查找多个月资金结余
	 * @param ids id数组
	 * @return List<MonthSummary> 月资金结余列表
	 * 
	 */
	List<MonthSummary> queryById(Integer[] ids);
}