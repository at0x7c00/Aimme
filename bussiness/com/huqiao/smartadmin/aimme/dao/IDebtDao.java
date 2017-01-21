package com.huqiao.smartadmin.aimme.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.huqiao.smartadmin.aimme.entity.Debt;
import com.huqiao.smartadmin.common.dao.IBaseDao;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 负债DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IDebtDao extends IBaseDao<Debt> {
    /**
     * 负债查询记录数量
     * @param debt 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Debt debt);
	/**
	 * 负债历史记录数量
     * @param debt 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Debt debt,Page pageInfo);
    /**
     * 负债分页查询
     * @param debt 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Debt>  负债列表 
     */
    List<Debt> findListPage(Debt debt, Page pageInfo);
	/**
	 * 负债历史记录分页查询
     * @param debt 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Debt>>  负债历史列表
	 */
    List<HistoryRecord<Debt>> findHistoryListPage(Debt debt, Page pageInfo);
	/**
     * 负债版本号查询
     * @param version 版本号
	 * @return Debt 负债历史记录
     */
	Debt findByVersion(Integer version);
	/**
	 * 添加负债查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param debt 查询对象
	 */
	public void queryCause(Criteria criteria, Debt debt);
	/**
	 * 负债关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Debt> 负债列表
	 */
	List<Debt> findByKey(Page pageInfo,String queryKey);
	/**
	 * 负债关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个负债
     * @param  ids id数组
	 * @return List<Debt>  负债列表
     */
	List<Debt> findById(Integer[] ids);
}