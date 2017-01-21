<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="name"
											id="target.name"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.name')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="progress"
									id="target.progress" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.progress')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="deadLineStart" id="target.deadLine" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${target.deadLineStart}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.deadLine')}(${nfn:i18nMessage(reqCtx,'base.common.form.start')})"
									   />
			</label>
				</section>
					<section class="col col-2">
					<label class="input"> 
								<i class="icon-append fa fa-calendar"></i>
								<input name="deadLineEnd" id="target.deadLine" onclick="WdatePicker({dateFmt:'${applicationScope.EN_YEAR_MONTH_DAY}'});"
								value="<fmt:formatDate pattern='${applicationScope.EN_YEAR_MONTH_DAY}' value='${target.deadLineEnd}'/>" class="date_not_required textInput valid"  size="12"
									   placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.deadLine')}(${nfn:i18nMessage(reqCtx,'base.common.form.end')})"
									   />
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="resource"
											id="target.resource" size="12"
											 placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.resource')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="checkItem"
											id="target.checkItem" size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.checkItem')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="output"
											id="target.output" size="12"
											maxlength="255" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.output')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<label class="select">
										<form:select id="parent" path="parent" cssClass=" comboxed">
										<option value="">-<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Target.parent"/>-</option>
											<form:options  items="${targetList}" itemValue="manageKey" itemLabel="name"/>
										</form:select>
										<i></i>
										</label>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="key"
											id="target.key"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.key')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<label class="select">
								<form:select id="emergency" path="emergency" cssClass="comboxed">
								<option value="">-${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Target.emergency')}-</option>
									<form:options  items="${emergencyMap}"/>
								</form:select>
								<i></i>
								</label>
				</label>
				</section>