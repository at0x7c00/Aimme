<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="name"
											id="clazz.name"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Clazz.name')}"/>
				</label>
				</section>
					<section class="col col-2">
						<label class="input"> 
										<form:input path="key"
											id="clazz.key"
											cssClass="textInput"
											maxlength="255"  size="12" placeholder="${nfn:i18nMessage(reqCtx,'props.com.huqiao.smartadmin.aimme.entity.Clazz.key')}"/>
				</label>
				</section>