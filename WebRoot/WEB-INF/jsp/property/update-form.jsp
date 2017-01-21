<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="property.name"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.incomePerMonth"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="incomePerMonth"
									id="property.incomePerMonth" type="text"
									cssClass="textInput required number" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Property.predictiveValue"/>:
								<form:input path="predictiveValue"
									id="property.predictiveValue" type="text"
									cssClass="textInput  number" />
				</label>
				</section>