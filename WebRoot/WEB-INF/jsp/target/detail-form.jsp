<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['progress'].changed}">title= "${checkResult['progress'].info}";</c:if>
						   >
			<span class="${checkResult['progress'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.progress"/>:
									<c:out value="${tempBean.progress}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['deadLine'].changed}">title= "${checkResult['deadLine'].info}";</c:if>
						   >
			<span class="${checkResult['deadLine'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.deadLine"/>:
									<fmt:formatDate value="${tempBean.deadLine}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['resource'].changed}">title= "${checkResult['resource'].info}";</c:if>
						   >
			<span class="${checkResult['resource'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.resource"/>:
									<c:out value="${tempBean.resource}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['checkItem'].changed}">title= "${checkResult['checkItem'].info}";</c:if>
						   >
			<span class="${checkResult['checkItem'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.checkItem"/>:
									<c:out value="${tempBean.checkItem}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['output'].changed}">title= "${checkResult['output'].info}";</c:if>
						   >
			<span class="${checkResult['output'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.output"/>:
									<c:out value="${tempBean.output}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['parent'].changed}">title= "${checkResult['parent'].info}";</c:if>
						   >
			<span class="${checkResult['parent'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.parent"/>:
									${tempBean.parent.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['key'].changed}">title= "${checkResult['key'].info}";</c:if>
						   >
			<span class="${checkResult['key'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.key"/>:
									<c:out value="${tempBean.key}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['emergency'].changed}">title= "${checkResult['emergency'].info}";</c:if>
						   >
			<span class="${checkResult['emergency'].changed ? 'change-markup':''}">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.emergency"/>:
								${emergencyMap[tempBean.emergency]}
			</span>
		</label>
	</section>