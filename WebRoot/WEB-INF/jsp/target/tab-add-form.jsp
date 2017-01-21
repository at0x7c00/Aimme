<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
	<td>
		<label class="checkbox">
			<input type="checkbox" name="${trTarget}Chk" value="${trIndex}"/>
			<i></i></label>
		<input type="hidden" name="rowGuard${trIndex}" value="1"/>
	</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].name"
											id="${propName}[${trIndex}].name"
											class="textInput required"
											 value="<c:out value="${tempBean.name}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].progress"
									id="${propName}[${trIndex}].progress" type="text"
									   value="<c:out value="${tempBean.progress}"/>"
									class="textInput required number" />
									</label>
				</td>
				<td>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="${propName}[${trIndex}].deadLine" id="${propName}[${trIndex}].deadLine" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.deadLine}'/>" class="date_not_required textInput valid"/>
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].resource"
											id="${propName}[${trIndex}].resource"
											class="textInput "
											 value="<c:out value="${tempBean.resource}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].checkItem"
											id="${propName}[${trIndex}].checkItem"
											class="textInput "
											 value="<c:out value="${tempBean.checkItem}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].output"
											id="${propName}[${trIndex}].output"
											class="textInput "
											 value="<c:out value="${tempBean.output}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
										<label class="select">
										<select id="${propName}[${trIndex}].parent.id" name="${propName}[${trIndex}].parent.id" class=" comboxed">
											<option value=""><spring:message code="base.common.selectone"/></option>
											<c:forEach items="${targetList}" var="target" >
												<option value="${target.id}" ${tempBean.parent.id eq target.id ? 'selected' : ''}><c:out value="${target.name}"/></option>
											</c:forEach>
										</select><i></i>
										</label>
				</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].key"
											id="${propName}[${trIndex}].key"
											class="textInput "
											 value="<c:out value="${tempBean.key}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="select">
								<select id="${propName}[${trIndex}].emergency" name="${propName}[${trIndex}].emergency" cssClass=" comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<c:forEach items="${emergencyMap}" var="entry" >
										<option value="${entry.key}" ${tempBean.emergency eq entry.key ? 'selected' : ''}><c:out value="${entry.value}"/></option>
									</c:forEach>
								</select><i></i>
								</label>
				</td>