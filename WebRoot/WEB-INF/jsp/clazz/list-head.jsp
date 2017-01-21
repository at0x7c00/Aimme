<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Clazz.name"/>
		</th>
			<th align="center" data-sortfield="key" class="${nfn:sortClass(pageBean,'key')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Clazz.key"/>
		</th>