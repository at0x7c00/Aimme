package com.huqiao.smartadmin.aimme.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.aimme.dao.IDebtDao;
import com.huqiao.smartadmin.aimme.entity.Debt;
import com.huqiao.smartadmin.aimme.service.IDebtService;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 负债Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class DebtServiceImpl extends BaseServiceImpl<Debt> implements IDebtService {
    /**负债DAO对象*/
    @Resource
    private IDebtDao debtDao;
    @Override
    public Page<Debt> getListPage(Debt debt,Page pageInfo) {
      	pageInfo.setTotalCount(debtDao.findListRowCount(debt).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(debtDao.findListPage(debt,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Debt>> getHistoryListPage(Debt debt, Page pageInfo) {
		pageInfo.setTotalCount(debtDao.findHistoryListRowCount(debt,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(debtDao.findHistoryListPage(debt,pageInfo));
        return pageInfo;
	}
	@Override
	public Debt findByVersion(Integer version) {
		return debtDao.findByVersion(version);
	}
	@Override
	public Page<Debt> queryByKey(String queryKey, Page<Debt> pageInfo) {
		int countRecord = debtDao.findRowCount(queryKey).intValue();
		Page<Debt> page = new Page<Debt>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Debt> debtList = debtDao.findByKey(pageInfo,queryKey);
		page.setList(debtList);
		return page;
	}
	@Override
	public List<Debt> queryById(Integer[] ids) {
		return debtDao.findById(ids);
	}
}