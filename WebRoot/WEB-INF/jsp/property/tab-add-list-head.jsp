<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.name"/>
		</th>
		<th align="center" data-sortfield="incomePerMonth" class="${nfn:sortClass(pageBean,'incomePerMonth')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.incomePerMonth"/>
		</th>
		<th align="center" data-sortfield="predictiveValue" class="${nfn:sortClass(pageBean,'predictiveValue')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.predictiveValue"/>
		</th>