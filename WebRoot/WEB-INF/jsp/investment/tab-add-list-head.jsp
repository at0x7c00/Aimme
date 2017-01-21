<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.name"/>
		</th>
		<th align="center" data-sortfield="payPerMonth" class="${nfn:sortClass(pageBean,'payPerMonth')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.payPerMonth"/>
		</th>
		<th align="center" data-sortfield="incomePerMonth" class="${nfn:sortClass(pageBean,'incomePerMonth')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.incomePerMonth"/>
		</th>