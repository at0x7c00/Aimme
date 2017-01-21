<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.name}
				</td>
				<td>
									${tempBean.progress}
				</td>
				<td>
								<fmt:formatDate value="${tempBean.deadLine}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
									${tempBean.resource}
				</td>
				<td>
									${tempBean.checkItem}
				</td>
				<td>
									${tempBean.output}
				</td>
				<td>
									${tempBean.parent.name}
				</td>
				<td>
									${tempBean.key}
				</td>
				<td>
									${emergencyMap[tempBean.emergency]}
				</td>