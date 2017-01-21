<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="value"
											id="value.value"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Value.value')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeStart" id="value.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${value.createTimeStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Value.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTimeEnd" id="value.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${value.createTimeEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Value.createTime')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="clazz" path="clazz" cssClass="required comboxed">
										<option value="">-<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.clazz"/>-</option>
											<form:options  items="${clazzList}" itemValue="manageKey" itemLabel="name"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>