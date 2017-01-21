package com.huqiao.smartadmin.aimme.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.aimme.dao.IPropertyDao;
import com.huqiao.smartadmin.aimme.entity.Property;
import com.huqiao.smartadmin.aimme.service.IPropertyService;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 资产Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements IPropertyService {
    /**资产DAO对象*/
    @Resource
    private IPropertyDao propertyDao;
    @Override
    public Page<Property> getListPage(Property property,Page pageInfo) {
      	pageInfo.setTotalCount(propertyDao.findListRowCount(property).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(propertyDao.findListPage(property,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Property>> getHistoryListPage(Property property, Page pageInfo) {
		pageInfo.setTotalCount(propertyDao.findHistoryListRowCount(property,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(propertyDao.findHistoryListPage(property,pageInfo));
        return pageInfo;
	}
	@Override
	public Property findByVersion(Integer version) {
		return propertyDao.findByVersion(version);
	}
	@Override
	public Page<Property> queryByKey(String queryKey, Page<Property> pageInfo) {
		int countRecord = propertyDao.findRowCount(queryKey).intValue();
		Page<Property> page = new Page<Property>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Property> propertyList = propertyDao.findByKey(pageInfo,queryKey);
		page.setList(propertyList);
		return page;
	}
	@Override
	public List<Property> queryById(Integer[] ids) {
		return propertyDao.findById(ids);
	}
}