<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<section id="widget-grid" class="">
	<div class="row">
		<article class="col-sm-12 col-md-12 col-lg-12">
			<form:form method="post" action="monthSummary/update.do"
					   class="smart-form required-validate" commandName="monthSummary"
				onsubmit="return validateCallback(this, ${targetPanel eq 'dialog' ? 'dialog' :'navTab' }AjaxDone);">
				<input type="hidden" name="targetPanel" value="${targetPanel}"/>
				<input type="hidden" name="manageKey" value="monthSummary.manageKey"/>
				<ul id="myTab1" class="nav nav-tabs bordered">
					<li class="active"><a href="#baseProperties" data-toggle="tab"><spring:message code="base.common.form.props"/></a></li>
					<%@include file="/WEB-INF/jsp/monthSummary/form-tab-title.jsp" %>
				</ul>
				<div id="myTabContent1" class="tab-content">
					<div class="tab-pane fade in active" id="baseProperties">	
						<fieldset>
							<div class="row">
								<%@include file="/WEB-INF/jsp/monthSummary/detail-form.jsp" %>
							</div>
						</fieldset>
					</div>
					<%@include file="/WEB-INF/jsp/monthSummary/detail-x2many-form.jsp" %>
				</div>
				<c:if test="${not (showOk  eq 'no' )}">
				<footer>
					<button type="button" class="btn btn-default btn-cancel" data-targetpanel = "${targetPanel}">
						<spring:message code="base.common.ok"></spring:message>
					</button>
				</footer>
				</c:if>
			</form:form>
		</article>
	</div>
</section>
<%@include  file="/WEB-INF/jsp/common/pageSetJS.jsp"%>