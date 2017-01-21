<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.createTime"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTime" id="monthSummary.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.income"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="income"
									id="monthSummary.income" type="text"
									cssClass="textInput required number" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.balance"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="balance"
									id="monthSummary.balance" type="text"
									cssClass="textInput required number" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.MonthSummary.outcome"/>:
								<form:input path="outcome"
									id="monthSummary.outcome" type="text"
									cssClass="textInput  number" />
				</label>
				</section>