<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['incomePerMonth'].changed}">title= "${checkResult['incomePerMonth'].info}";</c:if>
						   >
			<span class="${checkResult['incomePerMonth'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.incomePerMonth"/>:
									<c:out value="${tempBean.incomePerMonth}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['predictiveValue'].changed}">title= "${checkResult['predictiveValue'].info}";</c:if>
						   >
			<span class="${checkResult['predictiveValue'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.predictiveValue"/>:
									<c:out value="${tempBean.predictiveValue}"/>
			</span>
		</label>
	</section>