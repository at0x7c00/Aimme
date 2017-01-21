package com.huqiao.smartadmin.aimme.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.huqiao.smartadmin.aimme.entity.Target;
import com.huqiao.smartadmin.common.dao.IBaseDao;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 目标DAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ITargetDao extends IBaseDao<Target> {
    /**
     * 目标查询记录数量
     * @param target 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Target target);
	/**
	 * 目标历史记录数量
     * @param target 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Target target,Page pageInfo);
    /**
     * 目标分页查询
     * @param target 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Target>  目标列表 
     */
    List<Target> findListPage(Target target, Page pageInfo);
	/**
	 * 目标历史记录分页查询
     * @param target 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Target>>  目标历史列表
	 */
    List<HistoryRecord<Target>> findHistoryListPage(Target target, Page pageInfo);
	/**
     * 目标版本号查询
     * @param version 版本号
	 * @return Target 目标历史记录
     */
	Target findByVersion(Integer version);
	/**
	 * 添加目标查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param target 查询对象
	 */
	public void queryCause(Criteria criteria, Target target);
	/**
	 * 目标关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Target> 目标列表
	 */
	List<Target> findByKey(Page pageInfo,String queryKey);
	/**
	 * 目标关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个目标
     * @param  ids id数组
	 * @return List<Target>  目标列表
     */
	List<Target> findById(Integer[] ids);
}