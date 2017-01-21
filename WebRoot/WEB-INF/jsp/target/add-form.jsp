<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="target.name"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.progress"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="progress"
									id="target.progress" type="text"
									cssClass="textInput required number" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.deadLine"/>:
								<label class="input">
								<i class="icon-append fa fa-calendar"></i>
								<input name="deadLine" id="target.deadLine" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}' value='${tempBean.deadLine}'/>" class="date_not_required textInput valid"/>
								</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.resource"/>:
										<label class="textarea">
										<form:textarea path="resource"
											id="target.resource" cols="60"
											rows="5"
											cssClass=""
											 />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.checkItem"/>:
										<label class="textarea">
										<form:textarea path="checkItem"
											id="target.checkItem" cols="60"
											rows="5"
											cssClass=""
											maxlength="255" />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.output"/>:
										<label class="textarea">
										<form:textarea path="output"
											id="target.output" cols="60"
											rows="5"
											cssClass=""
											maxlength="255" />
										</label>
					</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.parent"/>:
										<label class="select">
										<form:select id="parent" path="parent" cssClass=" comboxed">
										<option value=""><spring:message code="base.common.selectone"/></option>
											<form:options  items="${targetList}" itemValue="manageKey" itemLabel="name"/>
										</form:select><i></i>
										</label>
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.key"/>:
										<form:input path="key"
											id="target.key"
											cssClass="textInput "
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.emergency"/>:
								<label class="select">
								<form:select id="emergency" path="emergency" cssClass=" comboxed">
								<option value=""><spring:message code="base.common.selectone"/></option>
									<form:options  items="${emergencyMap}"/>
								</form:select><i></i>
								</label>
				</label>
				</section>