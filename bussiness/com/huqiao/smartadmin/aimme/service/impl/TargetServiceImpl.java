package com.huqiao.smartadmin.aimme.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.aimme.dao.ITargetDao;
import com.huqiao.smartadmin.aimme.entity.Target;
import com.huqiao.smartadmin.aimme.service.ITargetService;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 目标Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class TargetServiceImpl extends BaseServiceImpl<Target> implements ITargetService {
    /**目标DAO对象*/
    @Resource
    private ITargetDao targetDao;
    @Override
    public Page<Target> getListPage(Target target,Page pageInfo) {
      	pageInfo.setTotalCount(targetDao.findListRowCount(target).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(targetDao.findListPage(target,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Target>> getHistoryListPage(Target target, Page pageInfo) {
		pageInfo.setTotalCount(targetDao.findHistoryListRowCount(target,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(targetDao.findHistoryListPage(target,pageInfo));
        return pageInfo;
	}
	@Override
	public Target findByVersion(Integer version) {
		return targetDao.findByVersion(version);
	}
	@Override
	public Page<Target> queryByKey(String queryKey, Page<Target> pageInfo) {
		int countRecord = targetDao.findRowCount(queryKey).intValue();
		Page<Target> page = new Page<Target>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Target> targetList = targetDao.findByKey(pageInfo,queryKey);
		page.setList(targetList);
		return page;
	}
	@Override
	public List<Target> queryById(Integer[] ids) {
		return targetDao.findById(ids);
	}
}