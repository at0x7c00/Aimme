package com.huqiao.smartadmin.aimme.service;
import java.util.List;

import com.huqiao.smartadmin.aimme.entity.Clazz;
import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * ClassService接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IClazzService extends IBaseService<Clazz> {
    /**
     * Class分页查询
     * @param clazz 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Clazz> Class分页信息对象
     */
    public Page<Clazz> getListPage(Clazz clazz,Page pageInfo);
	/**
	  * Class历史记录分页查询
	  * @param clazz 查询对象
	  * @param pageInfo ���页查询对象
	  * @return Page<HistoryRecord<Clazz>> Class历史分页信息对象
	  */
	public Page<HistoryRecord<Clazz>> getHistoryListPage(Clazz clazz,Page pageInfo);
	/**
	 * Class版本号查询
	 * @param version 查询版本号
	 * @return Clazz Class历史记录
	 */
	public Clazz findByVersion(Integer version);
	/**
	 * Class关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Clazz> Class分页信息对象
	 * 
	 */
	Page<Clazz> queryByKey(String queryKey, Page<Clazz> pageInfo);
	/**
	 * 查找多个Class
	 * @param ids id数组
	 * @return List<Clazz> Class列表
	 * 
	 */
	List<Clazz> queryById(Integer[] ids);
}