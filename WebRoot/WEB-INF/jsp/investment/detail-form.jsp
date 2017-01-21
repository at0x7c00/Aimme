<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['payPerMonth'].changed}">title= "${checkResult['payPerMonth'].info}";</c:if>
						   >
			<span class="${checkResult['payPerMonth'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.payPerMonth"/>:
									<c:out value="${tempBean.payPerMonth}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['incomePerMonth'].changed}">title= "${checkResult['incomePerMonth'].info}";</c:if>
						   >
			<span class="${checkResult['incomePerMonth'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.incomePerMonth"/>:
									<c:out value="${tempBean.incomePerMonth}"/>
			</span>
		</label>
	</section>