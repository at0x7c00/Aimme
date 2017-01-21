package com.huqiao.smartadmin.aimme.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.aimme.dao.IClazzDao;
import com.huqiao.smartadmin.aimme.entity.Clazz;
import com.huqiao.smartadmin.aimme.service.IClazzService;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * ClassService接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class ClazzServiceImpl extends BaseServiceImpl<Clazz> implements IClazzService {
    /**ClassDAO对象*/
    @Resource
    private IClazzDao clazzDao;
    @Override
    public Page<Clazz> getListPage(Clazz clazz,Page pageInfo) {
      	pageInfo.setTotalCount(clazzDao.findListRowCount(clazz).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(clazzDao.findListPage(clazz,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Clazz>> getHistoryListPage(Clazz clazz, Page pageInfo) {
		pageInfo.setTotalCount(clazzDao.findHistoryListRowCount(clazz,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(clazzDao.findHistoryListPage(clazz,pageInfo));
        return pageInfo;
	}
	@Override
	public Clazz findByVersion(Integer version) {
		return clazzDao.findByVersion(version);
	}
	@Override
	public Page<Clazz> queryByKey(String queryKey, Page<Clazz> pageInfo) {
		int countRecord = clazzDao.findRowCount(queryKey).intValue();
		Page<Clazz> page = new Page<Clazz>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Clazz> clazzList = clazzDao.findByKey(pageInfo,queryKey);
		page.setList(clazzList);
		return page;
	}
	@Override
	public List<Clazz> queryById(Integer[] ids) {
		return clazzDao.findById(ids);
	}
}