<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Clazz.name"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="name"
											id="clazz.name"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>
				<section class="col col-3">
					<label class="input">
						<spring:message code="props.com.huqiao.smartadmin.aimme.entity.Clazz.key"/>:
							<font style='color:red' class="required-mark">*</font>
										<form:input path="key"
											id="clazz.key"
											cssClass="textInput required"
											maxlength="255" />
				</label>
				</section>