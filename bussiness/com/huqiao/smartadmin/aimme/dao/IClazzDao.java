package com.huqiao.smartadmin.aimme.dao;
import java.util.List;

import org.hibernate.Criteria;

import com.huqiao.smartadmin.aimme.entity.Clazz;
import com.huqiao.smartadmin.common.dao.IBaseDao;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * ClassDAO接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IClazzDao extends IBaseDao<Clazz> {
    /**
     * Class查询记录数量
     * @param clazz 查询对象
     * @return Long 记录数量
     */
	Long findListRowCount(Clazz clazz);
	/**
	 * Class历史记录数量
     * @param clazz 查询对象
     * @param pageInfo 分页查询对象
	 * @return Long 历史记录数量
     */
	Long findHistoryListRowCount(Clazz clazz,Page pageInfo);
    /**
     * Class分页查询
     * @param clazz 查询对象
     * @param pageInfo 分页查询对象
     * @return  List<Clazz>  Class列表 
     */
    List<Clazz> findListPage(Clazz clazz, Page pageInfo);
	/**
	 * Class历史记录分页查询
     * @param clazz 查询对象
     * @param pageInfo 分页查询对象
     * @return List<HistoryRecord<Clazz>>  Class历史列表
	 */
    List<HistoryRecord<Clazz>> findHistoryListPage(Clazz clazz, Page pageInfo);
	/**
     * Class版本号查询
     * @param version 版本号
	 * @return Clazz Class历史记录
     */
	Clazz findByVersion(Integer version);
	/**
	 * 添加Class查询条件
	 * @param criteria Hibernate Criteria对象
	 * @param clazz 查询对象
	 */
	public void queryCause(Criteria criteria, Clazz clazz);
	/**
	 * Class关键字查询
	 * @param  queryKey 查询关键字
	 * @return List<Clazz> Class列表
	 */
	List<Clazz> findByKey(Page pageInfo,String queryKey);
	/**
	 * Class关键字查询数量
	 * @param queryKey 查询关键字
	 * @return Long 记录数量
	 */
	Long findRowCount(String queryKey);
    /**
     * 查找多个Class
     * @param  ids id数组
	 * @return List<Clazz>  Class列表
     */
	List<Clazz> findById(Integer[] ids);
}