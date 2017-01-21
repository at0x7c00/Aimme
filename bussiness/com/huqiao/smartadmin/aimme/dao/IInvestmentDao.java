package com.huqiao.smartadmin.aimme.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.huqiao.smartadmin.aimme.entity.Investment;
import com.huqiao.smartadmin.common.dao.IBaseDao;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 投资DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IInvestmentDao extends IBaseDao<Investment> {
    /**
     * 投资查询记录数量
     * @param investment 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Investment investment);
	/**
	 * 投资历史记录数量
     * @param investment 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Investment investment,Page pageInfo);
    /**
     * 投资分页查询
     * @param investment 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Investment>  投资列表 
     */
    List<Investment> findListPage(Investment investment, Page pageInfo);
	/**
	 * 投资历史记录分页查询
     * @param investment 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Investment>>  投资历史列表
	 */
    List<HistoryRecord<Investment>> findHistoryListPage(Investment investment, Page pageInfo);
	/**
     * 投资版本号查询
     * @param version 版本号
	 * @return Investment 投资历史记录
     */
	Investment findByVersion(Integer version);
	/**
	 * 添加投资查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param investment 查询对象
	 */
	public void queryCause(Criteria criteria, Investment investment);
	/**
	 * 投资关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Investment> 投资列表
	 */
	List<Investment> findByKey(Page pageInfo,String queryKey);
	/**
	 * 投资关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个投资
     * @param  ids id数组
	 * @return List<Investment>  投资列表
     */
	List<Investment> findById(Integer[] ids);
}