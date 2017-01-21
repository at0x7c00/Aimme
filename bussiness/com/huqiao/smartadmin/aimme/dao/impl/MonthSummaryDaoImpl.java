package com.huqiao.smartadmin.aimme.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.query.AuditQueryCreator;
import org.springframework.stereotype.Repository;

import com.huqiao.smartadmin.aimme.dao.IMonthSummaryDao;
import com.huqiao.smartadmin.aimme.entity.MonthSummary;
import com.huqiao.smartadmin.common.dao.impl.BaseDaoImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.history.entity.TestRevisionEntity;
import com.huqiao.smartadmin.util.web.Page;

/**
 * 月资金结余DAO实现
 * 
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class MonthSummaryDaoImpl extends BaseDaoImpl<MonthSummary> implements
		IMonthSummaryDao {
	@Override
	public Long findListRowCount(MonthSummary monthSummary) {
		Criteria criteria = getSession().createCriteria(MonthSummary.class)
				.setProjection(Projections.rowCount());
		queryCause(criteria, monthSummary);
		return (Long) criteria.uniqueResult();
	}

	@Override
	public Long findHistoryListRowCount(MonthSummary monthSummary, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(
				MonthSummary.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(
				monthSummary.getManageKey()));
		queryCause(query, pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MonthSummary> findListPage(MonthSummary monthSummary,
			Page pageInfo) {
		Criteria criteria = getSession().createCriteria(MonthSummary.class)
				.setFirstResult(pageInfo.getStartIndex())
				.setMaxResults(pageInfo.getNumPerPage());
		queryCause(criteria, monthSummary);
		if (pageInfo.getOrderField() != null
				&& !pageInfo.getOrderField().trim().equals("")) {
			if (pageInfo.getOrderDirection() == null
					|| pageInfo.getOrderDirection().trim().equals("asc")) {
				criteria.addOrder(Order.asc(pageInfo.getOrderField()));
			} else {
				criteria.addOrder(Order.desc(pageInfo.getOrderField()));
			}
		} else {
			criteria.addOrder(Order.asc("id"));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoryRecord<MonthSummary>> findHistoryListPage(
			MonthSummary monthSummary, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(
				MonthSummary.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(
				pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(
				monthSummary.getManageKey()));
		queryCause(query, pageInfo);
		if (pageInfo.getOrderField() != null
				&& !pageInfo.getOrderField().trim().equals("")) {
			if (pageInfo.getOrderDirection() == null
					|| pageInfo.getOrderDirection().trim().equals("asc")) {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField())
						.asc());
			} else {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField())
						.desc());
			}
		} else {
			query.addOrder(AuditEntity.property("id").desc());
		}
		List list = query.getResultList();
		List<HistoryRecord<MonthSummary>> res = new ArrayList<HistoryRecord<MonthSummary>>();
		for (Object obj : list) {
			Object[] array = (Object[]) obj;
			HistoryRecord<MonthSummary> record = new HistoryRecord<MonthSummary>();
			record.setRecord((MonthSummary) array[0]);
			record.setRevisionEntity((TestRevisionEntity) array[1]);
			record.setType((RevisionType) array[2]);
			res.add(record);
		}
		return res;
	}

	/**
	 * 添加历史记录查询条件
	 * 
	 * @param query
	 *            历史查询对象
	 * @param pageInfo
	 *            历史记录分页查询对象
	 */
	public void queryCause(AuditQuery query, Page pageInfo) {
		if (pageInfo.getOperateDateStart() != null) {
			query.add(AuditEntity.revisionProperty("timestamp").ge(
					pageInfo.getOperateDateStart()));
		}
		if (pageInfo.getOperateDateEnd() != null) {
			query.add(AuditEntity.revisionProperty("timestamp").le(
					pageInfo.getOperateDateEnd()));
		}
		if (pageInfo.getOperator() != null
				&& !pageInfo.getOperator().trim().equals("")) {
			query.add(AuditEntity.revisionProperty("username").like(
					pageInfo.getOperator(), MatchMode.ANYWHERE));
		}
		if (pageInfo.getOperateType() != null
				&& !pageInfo.getOperateType().trim().equals("")) {
			query.add(AuditEntity.revisionType().eq(
					RevisionType.valueOf(pageInfo.getOperateType())));
		}
	}

	/**
	 * 根据查询对象往criteria对象增加查询条件
	 * 
	 * @param criteria
	 *            Hibernate criteria对象
	 * @param monthSummary
	 *            查询对象
	 */
	public void queryCause(Criteria criteria, MonthSummary monthSummary) {
		if (monthSummary.getCreateTimeStart() != null) {
			criteria.add(Restrictions.ge("createTime",
					monthSummary.getCreateTimeStart()));
		}
		if (monthSummary.getCreateTimeEnd() != null) {
			criteria.add(Restrictions.le("createTime",
					monthSummary.getCreateTimeEnd()));
		}
	}

	@Override
	public MonthSummary findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(
				MonthSummary.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if (list != null && list.size() > 0) {
			return (MonthSummary) list.get(0);
		}
		return null;
	}

	@Override
	public List<MonthSummary> findByKey(Page pageInfo, String queryKey) {
		Criteria criteria = getSession()
				.createCriteria(MonthSummary.class)
				.setFirstResult(pageInfo.getStartIndex())
				.setMaxResults(pageInfo.getNumPerPage())
				.add(Restrictions.like("manageKey", queryKey,
						MatchMode.ANYWHERE));
		return criteria.list();
	}

	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession()
				.createCriteria(MonthSummary.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("manageKey", queryKey,
						MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MonthSummary> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(MonthSummary.class)
				.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}