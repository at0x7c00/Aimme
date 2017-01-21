<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>
		<label class="checkbox">
			<input type="checkbox" name="${trTarget}Chk" value="${trIndex}"/>
			<i></i></label>
		<input type="hidden" name="rowGuard${trIndex}" value="1"/>
	</td>
				<td>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="${propName}[${trIndex}].createTime" id="${propName}[${trIndex}].createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tmpTmpBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].income"
									id="${propName}[${trIndex}].income" type="text"
									   value="<c:out value="${tmpTmpBean.income}"/>"
									class="textInput required number" />
								</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].balance"
									id="${propName}[${trIndex}].balance" type="text"
									   value="<c:out value="${tmpTmpBean.balance}"/>"
									class="textInput required number" />
								</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].outcome"
									id="${propName}[${trIndex}].outcome" type="text"
									   value="<c:out value="${tmpTmpBean.outcome}"/>"
									class="textInput  number" />
								</label>
				</td>