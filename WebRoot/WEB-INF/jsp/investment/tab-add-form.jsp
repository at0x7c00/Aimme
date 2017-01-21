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
								<input name="${propName}[${trIndex}].payPerMonth"
									id="${propName}[${trIndex}].payPerMonth" type="text"
									   value="<c:out value="${tempBean.payPerMonth}"/>"
									class="textInput required number" />
									</label>
				</td>
				<td>
								<label class="input">
								<input name="${propName}[${trIndex}].incomePerMonth"
									id="${propName}[${trIndex}].incomePerMonth" type="text"
									   value="<c:out value="${tempBean.incomePerMonth}"/>"
									class="textInput required number" />
									</label>
				</td>