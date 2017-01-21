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

import com.huqiao.smartadmin.aimme.dao.IPropertyDao;
import com.huqiao.smartadmin.aimme.entity.Property;
import com.huqiao.smartadmin.common.dao.impl.BaseDaoImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.history.entity.TestRevisionEntity;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 资产DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements IPropertyDao {
    @Override
    public Long findListRowCount(Property property) {
        Criteria criteria = getSession().createCriteria(Property.class).setProjection(Projections.rowCount());
        queryCause(criteria,property);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Property property,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Property.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(property.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Property> findListPage(Property property, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Property.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,property);
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
	public List<HistoryRecord<Property>> findHistoryListPage(Property property, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Property.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(property.getManageKey()));
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
		List<HistoryRecord<Property>> res = new ArrayList<HistoryRecord<Property>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Property> record = new HistoryRecord<Property>();
			record.setRecord((Property)array[0]);
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
      * @param property 查询对象
	  */
    public void queryCause(Criteria criteria,Property property){
       if(property.getName()!=null
 && ! property.getName().trim().equals("")){
		criteria.add(Restrictions.like("name",property.getName(),MatchMode.ANYWHERE));
}
       if(property.getIncomePerMonth()!=null
){
		criteria.add(Restrictions.eq("incomePerMonth",property.getIncomePerMonth()));
}
       if(property.getPredictiveValue()!=null
){
		criteria.add(Restrictions.eq("predictiveValue",property.getPredictiveValue()));
}
    }
	@Override
	public Property findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Property.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Property)list.get(0);
		}
		return null;
	}
	@Override
	public List<Property> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Property.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Property.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Property> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Property.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}