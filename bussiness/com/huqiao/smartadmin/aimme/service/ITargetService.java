package com.huqiao.smartadmin.aimme.service;
import java.util.List;

import com.huqiao.smartadmin.aimme.entity.Target;
import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 目标Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface ITargetService extends IBaseService<Target> {
    /**
     * 目标分页查询
     * @param target 查询对象
     * @param pageInfo 分页查询对象
     * @return Page<Target> 目标分页信息对象
     */
    public Page<Target> getListPage(Target target,Page pageInfo);
	/**
	  * 目标历史记录分页查询
	  * @param target 查询对象
	  * @param pageInfo 分页查询对象
	  * @return Page<HistoryRecord<Target>> 目标历史分页信息对象
	  */
	public Page<HistoryRecord<Target>> getHistoryListPage(Target target,Page pageInfo);
	/**
	 * 目标版本号查询
	 * @param version 查询版本号
	 * @return Target 目标历史记录
	 */
	public Target findByVersion(Integer version);
	/**
	 * 目标关键字查询
	 * @param  queryKey 关键字
	 * @param  pageInfo 分页查询对象
	 * @return Page<Target> 目标分页信息对象
	 * 
	 */
	Page<Target> queryByKey(String queryKey, Page<Target> pageInfo);
	/**
	 * 查找多个目标
	 * @param ids id数组
	 * @return List<Target> 目标列表
	 * 
	 */
	List<Target> queryById(Integer[] ids);
}