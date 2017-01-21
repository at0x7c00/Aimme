<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['payPerMonth'].changed}">title= "${checkResult['payPerMonth'].info}";</c:if>
						   >
			<span class="${checkResult['payPerMonth'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.payPerMonth"/>:
									<c:out value="${tempBean.payPerMonth}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['payOnce'].changed}">title= "${checkResult['payOnce'].info}";</c:if>
						   >
			<span class="${checkResult['payOnce'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.payOnce"/>:
									<c:out value="${tempBean.payOnce}"/>
			</span>
		</label>
	</section>