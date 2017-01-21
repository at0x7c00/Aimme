<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.value"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="value"
											id="value.value"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.createTime"/>:
							<font style='color:red' class="required-mark">*</font>
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="createTime" id="value.createTime" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.createTime}'/>" class="date_required required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Value.clazz"/>:
							<font style='color:red' class="required-mark">*</font>
										<label class="select">
										<form:select id="clazz" path="clazz" cssClass="required comboxed">
										<option value=""><spring:message code="base.common.selectone"/></option>
											<form:options  items="${clazzList}" itemValue="manageKey" itemLabel="name"/>
										</form:select><i></i>
										</label>
				</label>
				</section>