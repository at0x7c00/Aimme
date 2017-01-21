<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="name"
											id="property.name"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Property.name')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="incomePerMonth"
									id="property.incomePerMonth" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Property.incomePerMonth')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="predictiveValue"
									id="property.predictiveValue" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Property.predictiveValue')}"/>
				</label>
				</section>