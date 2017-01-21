package com.huqiao.smartadmin.aimme.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.aimme.dao.IMonthSummaryDao;
import com.huqiao.smartadmin.aimme.entity.MonthSummary;
import com.huqiao.smartadmin.aimme.service.IMonthSummaryService;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 月资金结余Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class MonthSummaryServiceImpl extends BaseServiceImpl<MonthSummary> implements IMonthSummaryService {
    /**月资金结余DAO对象*/
    @Resource
    private IMonthSummaryDao monthSummaryDao;
    @Override
    public Page<MonthSummary> getListPage(MonthSummary monthSummary,Page pageInfo) {
      	pageInfo.setTotalCount(monthSummaryDao.findListRowCount(monthSummary).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(monthSummaryDao.findListPage(monthSummary,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<MonthSummary>> getHistoryListPage(MonthSummary monthSummary, Page pageInfo) {
		pageInfo.setTotalCount(monthSummaryDao.findHistoryListRowCount(monthSummary,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(monthSummaryDao.findHistoryListPage(monthSummary,pageInfo));
        return pageInfo;
	}
	@Override
	public MonthSummary findByVersion(Integer version) {
		return monthSummaryDao.findByVersion(version);
	}
	@Override
	public Page<MonthSummary> queryByKey(String queryKey, Page<MonthSummary> pageInfo) {
		int countRecord = monthSummaryDao.findRowCount(queryKey).intValue();
		Page<MonthSummary> page = new Page<MonthSummary>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<MonthSummary> monthSummaryList = monthSummaryDao.findByKey(pageInfo,queryKey);
		page.setList(monthSummaryList);
		return page;
	}
	@Override
	public List<MonthSummary> queryById(Integer[] ids) {
		return monthSummaryDao.findById(ids);
	}
}