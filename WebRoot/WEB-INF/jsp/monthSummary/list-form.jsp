<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeStart" id="monthSummary.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${monthSummary.createTimeStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.MonthSummary.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeEnd" id="monthSummary.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${monthSummary.createTimeEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.MonthSummary.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="income"
									id="monthSummary.income" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.MonthSummary.income')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="balance"
									id="monthSummary.balance" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.MonthSummary.balance')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="outcome"
									id="monthSummary.outcome" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.MonthSummary.outcome')}"/>
				</label>
				</section>