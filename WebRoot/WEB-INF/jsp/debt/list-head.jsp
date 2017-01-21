<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.name"/>
		</th>
			<th align="center" data-sortfield="payPerMonth" class="${nfn:sortClass(pageBean,'payPerMonth')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.payPerMonth"/>
		</th>
			<th align="center" data-sortfield="payOnce" class="${nfn:sortClass(pageBean,'payOnce')}">
			<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.payOnce"/>
		</th>