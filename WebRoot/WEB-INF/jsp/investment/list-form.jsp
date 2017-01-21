<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="name"
											id="investment.name"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Investment.name')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="payPerMonth"
									id="investment.payPerMonth" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Investment.payPerMonth')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
								<form:input path="incomePerMonth"
									id="investment.incomePerMonth" type="text"
									cssClass="textInputnumber" size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Investment.incomePerMonth')}"/>
				</label>
				</section>