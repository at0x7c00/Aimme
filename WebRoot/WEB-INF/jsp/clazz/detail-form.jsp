<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Clazz.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['key'].changed}">title= "${checkResult['key'].info}";</c:if>
						   >
			<span class="${checkResult['key'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Clazz.key"/>:
									<c:out value="${tempBean.key}"/>
			</span>
		</label>
	</section>