package com.huqiao.smartadmin.aimme.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.aimme.dao.IInvestmentDao;
import com.huqiao.smartadmin.aimme.entity.Investment;
import com.huqiao.smartadmin.aimme.service.IInvestmentService;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 投资Service接口实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class InvestmentServiceImpl extends BaseServiceImpl<Investment> implements IInvestmentService {
    /**投资DAO对象*/
    @Resource
    private IInvestmentDao investmentDao;
    @Override
    public Page<Investment> getListPage(Investment investment,Page pageInfo) {
      	pageInfo.setTotalCount(investmentDao.findListRowCount(investment).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(investmentDao.findListPage(investment,pageInfo));
        return pageInfo;
    }
	@Override
	public Page<HistoryRecord<Investment>> getHistoryListPage(Investment investment, Page pageInfo) {
		pageInfo.setTotalCount(investmentDao.findHistoryListRowCount(investment,pageInfo).intValue());
		pageInfo.setOrderField(pageInfo.getOrderField() == null ? "id": pageInfo.getOrderField());
		pageInfo.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc": pageInfo.getOrderDirection());
		pageInfo.setList(investmentDao.findHistoryListPage(investment,pageInfo));
        return pageInfo;
	}
	@Override
	public Investment findByVersion(Integer version) {
		return investmentDao.findByVersion(version);
	}
	@Override
	public Page<Investment> queryByKey(String queryKey, Page<Investment> pageInfo) {
		int countRecord = investmentDao.findRowCount(queryKey).intValue();
		Page<Investment> page = new Page<Investment>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<Investment> investmentList = investmentDao.findByKey(pageInfo,queryKey);
		page.setList(investmentList);
		return page;
	}
	@Override
	public List<Investment> queryById(Integer[] ids) {
		return investmentDao.findById(ids);
	}
}