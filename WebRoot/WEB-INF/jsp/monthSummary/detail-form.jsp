<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['createTime'].changed}">title= "${checkResult['createTime'].info}";</c:if>
						   >
			<span class="${checkResult['createTime'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.createTime"/>:
									<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['income'].changed}">title= "${checkResult['income'].info}";</c:if>
						   >
			<span class="${checkResult['income'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.income"/>:
									<c:out value="${tempBean.income}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['balance'].changed}">title= "${checkResult['balance'].info}";</c:if>
						   >
			<span class="${checkResult['balance'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.balance"/>:
									<c:out value="${tempBean.balance}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['outcome'].changed}">title= "${checkResult['outcome'].info}";</c:if>
						   >
			<span class="${checkResult['outcome'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.outcome"/>:
									<c:out value="${tempBean.outcome}"/>
			</span>
		</label>
	</section>