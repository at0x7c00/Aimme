<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="debt.name"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.payPerMonth"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="payPerMonth"
									id="debt.payPerMonth" type="text"
									cssClass="textInput required number" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Debt.payOnce"/>:
								<form:input path="payOnce"
									id="debt.payOnce" type="text"
									cssClass="textInput  number" />
				</label>
				</section>