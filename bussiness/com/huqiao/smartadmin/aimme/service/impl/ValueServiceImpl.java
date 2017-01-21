package com.huqiao.smartadmin.aimme.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.aimme.dao.IValueDao;
import com.huqiao.smartadmin.aimme.entity.Value;
import com.huqiao.smartadmin.aimme.service.IValueService;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * ValueService接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class ValueServiceImpl extends BaseServiceImpl<Value> implements IValueService {
    /**ValueDAO对象*/
    @Resource
    private IValueDao valueDao;
    @Override
    public Page<Value> getListPage(Value value,Page pageInfo) {
      	pageInfo.setTotalCount(valueDao.findListRowCount(value).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(valueDao.findListPage(value,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Value>> getHistoryListPage(Value value, Page pageInfo) {
		pageInfo.setTotalCount(valueDao.findHistoryListRowCount(value,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(valueDao.findHistoryListPage(value,pageInfo));
        return pageInfo;
	}
	@Override
	public Value findByVersion(Integer version) {
		return valueDao.findByVersion(version);
	}
	@Override
	public Page<Value> queryByKey(String queryKey, Page<Value> pageInfo) {
		int countRecord = valueDao.findRowCount(queryKey).intValue();
		Page<Value> page = new Page<Value>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Value> valueList = valueDao.findByKey(pageInfo,queryKey);
		page.setList(valueList);
		return page;
	}
	@Override
	public List<Value> queryById(Integer[] ids) {
		return valueDao.findById(ids);
	}
}