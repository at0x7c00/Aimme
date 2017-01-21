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

import com.huqiao.smartadmin.aimme.dao.ITargetDao;
import com.huqiao.smartadmin.aimme.entity.Target;
import com.huqiao.smartadmin.common.dao.impl.BaseDaoImpl;
import com.huqiao.smartadmin.history.entity.HistoryRecord;
import com.huqiao.smartadmin.history.entity.TestRevisionEntity;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 目标DAO实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Repository
public class TargetDaoImpl extends BaseDaoImpl<Target> implements ITargetDao {
    @Override
    public Long findListRowCount(Target target) {
        Criteria criteria = getSession().createCriteria(Target.class).setProjection(Projections.rowCount());
        queryCause(criteria,target);
        return (Long) criteria.uniqueResult();
    }
	@Override
	public Long findHistoryListRowCount(Target target,Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Target.class, false, true);
		query.add(AuditEntity.property("manageKey").eq(target.getManageKey()));
		queryCause(query,pageInfo);
		query.addProjection(AuditEntity.property("manageKey").count());
		return (Long) query.getSingleResult();
	}
    @SuppressWarnings("unchecked")
    @Override
    public List<Target> findListPage(Target target, Page pageInfo){
    	Criteria criteria = getSession().createCriteria(Target.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
        queryCause(criteria,target);
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
	public List<HistoryRecord<Target>> findHistoryListPage(Target target, Page pageInfo) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forRevisionsOfEntity(Target.class, false, true);
		query.setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage());
		query.add(AuditEntity.property("manageKey").eq(target.getManageKey()));
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
		List<HistoryRecord<Target>> res = new ArrayList<HistoryRecord<Target>>();
		for(Object obj : list){
			Object[] array = (Object[])obj;
			HistoryRecord<Target> record = new HistoryRecord<Target>();
			record.setRecord((Target)array[0]);
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
      * @param target 查询对象
	  */
    public void queryCause(Criteria criteria,Target target){
       if(target.getName()!=null
 && ! target.getName().trim().equals("")){
		criteria.add(Restrictions.like("name",target.getName(),MatchMode.ANYWHERE));
}
       if(target.getProgress()!=null
){
		criteria.add(Restrictions.eq("progress",target.getProgress()));
}
if(target.getDeadLineStart()!=null){
criteria.add(Restrictions.ge("deadLine",target.getDeadLineStart()));
}
if(target.getDeadLineEnd()!=null){
criteria.add(Restrictions.le("deadLine",target.getDeadLineEnd()));
}
       if(target.getResource()!=null
 && ! target.getResource().trim().equals("")){
		criteria.add(Restrictions.like("resource",target.getResource(),MatchMode.ANYWHERE));
}
       if(target.getCheckItem()!=null
 && ! target.getCheckItem().trim().equals("")){
		criteria.add(Restrictions.like("checkItem",target.getCheckItem(),MatchMode.ANYWHERE));
}
       if(target.getOutput()!=null
 && ! target.getOutput().trim().equals("")){
		criteria.add(Restrictions.like("output",target.getOutput(),MatchMode.ANYWHERE));
}
				if(target.getParent()!=null && target.getParent().getId() != null ){
					criteria.add(Restrictions.eq("parent",target.getParent()));
				}
       if(target.getKey()!=null
 && ! target.getKey().trim().equals("")){
		criteria.add(Restrictions.like("key",target.getKey(),MatchMode.ANYWHERE));
}
       if(target.getEmergency()!=null
){
		criteria.add(Restrictions.eq("emergency",target.getEmergency()));
}
    }
	@Override
	public Target findByVersion(Integer version) {
		AuditReader reader = AuditReaderFactory.get(getSession());
		AuditQueryCreator queryCreator2 = reader.createQuery();
		AuditQuery query = queryCreator2.forEntitiesAtRevision(Target.class, version);
		query.add(AuditEntity.revisionNumber().eq(version));
		List list = query.getResultList();
		if(list!=null && list.size()>0){
			return (Target)list.get(0);
		}
		return null;
	}
	@Override
	public List<Target> findByKey(Page pageInfo,String queryKey) {
		Criteria criteria = getSession().createCriteria(Target.class).setFirstResult(pageInfo.getStartIndex()).setMaxResults(pageInfo.getNumPerPage()).add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return criteria.list();
	}
	@Override
	public Long findRowCount(String queryKey) {
		Criteria criteria = getSession().createCriteria(Target.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("name", queryKey,MatchMode.ANYWHERE));
		return (Long) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Target> findById(Integer[] ids) {
		Criteria criteria = getSession().createCriteria(Target.class)
		.add(Restrictions.in("id", ids));
		return criteria.list();
	}
}