<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="investment.name"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.payPerMonth"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="payPerMonth"
									id="investment.payPerMonth" type="text"
									cssClass="textInput required number" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Investment.incomePerMonth"/>:
							<font style='color:red' class="required-mark">*</font>
								<form:input path="incomePerMonth"
									id="investment.incomePerMonth" type="text"
									cssClass="textInput required number" />
				</label>
				</section>