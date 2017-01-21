package com.huqiao.smartadmin.aimme.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.huqiao.smartadmin.aimme.entity.MonthSummary;
import com.huqiao.smartadmin.common.dao.IBaseDao;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 月资金结余DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IMonthSummaryDao extends IBaseDao<MonthSummary> {
    /**
     * 月资金结余查询记录数量
     * @param monthSummary 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(MonthSummary monthSummary);
	/**
	 * 月资金结余历史记录数量
     * @param monthSummary 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(MonthSummary monthSummary,Page pageInfo);
    /**
     * 月资金结余分页查询
     * @param monthSummary 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<MonthSummary>  月资金结余列表 
     */
    List<MonthSummary> findListPage(MonthSummary monthSummary, Page pageInfo);
	/**
	 * 月资金结余历史记录分页查询
     * @param monthSummary 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<MonthSummary>>  月资金结余历史列表
	 */
    List<HistoryRecord<MonthSummary>> findHistoryListPage(MonthSummary monthSummary, Page pageInfo);
	/**
     * 月资金结余版本号查询
     * @param version 版本号
	 * @return MonthSummary 月资金结余历史记录
     */
	MonthSummary findByVersion(Integer version);
	/**
	 * 添加月资金结余查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param monthSummary 查询对象
	 */
	public void queryCause(Criteria criteria, MonthSummary monthSummary);
	/**
	 * 月资金结余关键���查询
	 * @param  queryKey 查询关键字
	 * @return List<MonthSummary> 月资金结余列表
	 */
	List<MonthSummary> findByKey(Page pageInfo,String queryKey);
	/**
	 * 月资金结余关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个月资金结余
     * @param  ids id数组
	 * @return List<MonthSummary>  月资金结余列表
     */
	List<MonthSummary> findById(Integer[] ids);
}