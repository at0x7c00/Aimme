<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="name"
											id="debt.name"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Debt.name')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="payPerMonth"
									id="debt.payPerMonth" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Debt.payPerMonth')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="payOnce"
									id="debt.payOnce" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Debt.payOnce')}"/>
				</label>
				</section>