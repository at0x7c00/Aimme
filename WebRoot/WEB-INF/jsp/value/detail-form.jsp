<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['value'].changed}">title= "${checkResult['value'].info}";</c:if>
						   >
			<span class="${checkResult['value'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.value"/>:
									<c:out value="${tempBean.value}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['createTime'].changed}">title= "${checkResult['createTime'].info}";</c:if>
						   >
			<span class="${checkResult['createTime'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.createTime"/>:
									<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['clazz'].changed}">title= "${checkResult['clazz'].info}";</c:if>
						   >
			<span class="${checkResult['clazz'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.clazz"/>:
									${tempBean.clazz.name}
			</span>
		</label>
	</section>