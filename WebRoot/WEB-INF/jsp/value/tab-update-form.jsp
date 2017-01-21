<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>
		<label class="checkbox">
			<input type="checkbox" name="${trTarget}Chk" value="${trIndex}"/>
			<i></i></label>
		<input type="hidden" name="rowGuard${trIndex}" value="1"/>
	</td>
				<td>
								<label class="input">
										<input name="${propName}[${trIndex}].value"
											id="${propName}[${trIndex}].value"
											class="textInput required"
											 value="<c:out value="${tmpTmpBean.value}"/>"
											maxlength="255" />
								</label>
				</td>
				<td>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="${propName}[${trIndex}].createTime" id="${propName}[${trIndex}].createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tmpTmpBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</td>
				<td>
										<label class="select">
										<select id="${propName}[${trIndex}].clazz.id" name="${propName}[${trIndex}].clazz.id" class="required comboxed">
											<option value=""><spring:message code="base.common.selectone"/></option>
											<c:forEach items="${clazzList}" var="clazz" >
												<option value="${clazz.id}" ${tmpTmpBean.clazz.id eq clazz.id ? 'selected' : ''}><c:out value="${clazz.name}"/></option>
											</c:forEach>
										</select><i></i>
										</label>
				</td>