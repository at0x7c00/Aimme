<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="value" class="${nfn:sortClass(pageBean,'value')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.value"/>
		</th>
			<th align="center" data-sortfield="createTime" class="${nfn:sortClass(pageBean,'createTime')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.createTime"/>
		</th>
			<th align="center" data-sortfield="clazz" class="${nfn:sortClass(pageBean,'clazz')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.clazz"/>
		</th>