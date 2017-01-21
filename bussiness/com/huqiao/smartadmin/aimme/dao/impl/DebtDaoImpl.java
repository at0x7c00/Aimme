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

import com.huqiao.smartadmin.aimme.dao.IDebtDao;
import com.huqiao.smartadmin.aimme.entity.Debt;
import com.huqiao.smartadmin.common.dao.impl.BaseDaoImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.history.entity.TestRevisionEntity;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 负债DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class DebtDaoImpl extends BaseDaoImpl<Debt> implements IDebtDao {
    @Override
    public Long findListRowCount(Debt debt) {
        Criteria criteria = getSession().createCriteria(Debt.class).setProjection(Projections.rowCount());
        queryCause(criteria,debt);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Debt debt,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Debt.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(debt.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Debt> findListPage(Debt debt, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Debt.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,debt);
        if(pageInfo.getOrderField()!=null && !pageInfo.getOrderField().trim().equals("")){
         	if(pageInfo.getOrderDirection()==null || pageInfo.getOrderDirection().trim().equals("asc")){
         		criteria.addOrder(Order.asc(pageInfo.getOrderField()));
         	}else{
         		criteria.addOrder(Order.desc(pageInfo.getOrderField()));
         	}
         }else{
         	criteria.addOrder(Order.asc("id")); 
         }
        return criteria.list();
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoryRecord<Debt>> findHistoryListPage(Debt debt, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Debt.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(debt.getManageKey()));
		queryCause(query,pageInfo);
		if (pageInfo.getOrderField() != null && !pageInfo.getOrderField().trim().equals("")) {
			if (pageInfo.getOrderDirection() == null || pageInfo.getOrderDirection().trim().equals("asc")) {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField()).asc());
			} else {
				query.addOrder(AuditEntity.property(pageInfo.getOrderField()).desc());
			}
		} else {
			query.addOrder(AuditEntity.property("id").desc());
		}
		List list = query.getResultList();
		List<HistoryRecord<Debt>> res = new ArrayList<HistoryRecord<Debt>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Debt> record = new HistoryRecord<Debt>();
			record.setRecord((Debt)array[0]);
			record.setRevisionEntity((TestRevisionEntity)array[1]);
			record.setType((RevisionType)array[2]);
			res.add(record);
		}
		return res;
	}
	/**
	  * 添加历史记录查询条件
      * @param query 历史查询对象
      * @param pageInfo 历史记录分页查询对象
	  */
	public void queryCause(AuditQuery query,Page pageInfo) {
		if(pageInfo.getOperateDateStart()!=null){
			query.add(AuditEntity.revisionProperty("timestamp").ge(pageInfo.getOperateDateStart()));
		}
		if(pageInfo.getOperateDateEnd()!=null){
			query.add(AuditEntity.revisionProperty("timestamp").le(pageInfo.getOperateDateEnd()));
		}
		if(pageInfo.getOperator()!=null && !pageInfo.getOperator().trim().equals("")){
			query.add(AuditEntity.revisionProperty("username").like(pageInfo.getOperator(),MatchMode.ANYWHERE));
		}
		if(pageInfo.getOperateType()!=null && !pageInfo.getOperateType().trim().equals("")){
			query.add(AuditEntity.revisionType().eq(RevisionType.valueOf(pageInfo.getOperateType())));
		}
	}
	/**
	  * 根据查询对象往criteria对象增加查询条件
      * @param criteria Hibernate criteria对象
      * @param debt 查询对象
	  */
    public void queryCause(Criteria criteria,Debt debt){
       if(debt.getName()!=null
 && ! debt.getName().trim().equals("")){
		criteria.add(Restrictions.like("name",debt.getName(),MatchMode.ANYWHERE));
}
       if(debt.getPayPerMonth()!=null
){
		criteria.add(Restrictions.eq("payPerMonth",debt.getPayPerMonth()));
}
       if(debt.getPayOnce()!=null
){
		criteria.add(Restrictions.eq("payOnce",debt.getPayOnce()));
}
    }
	@Override
	public Debt findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Debt.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Debt)list.get(0);
		}
		return null;
	}
	@Override
	public List<Debt> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Debt.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Debt.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Debt> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Debt.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}