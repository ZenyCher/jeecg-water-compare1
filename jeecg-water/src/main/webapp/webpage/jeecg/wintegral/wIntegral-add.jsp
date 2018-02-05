<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>积分明细表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wIntegralController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wIntegralPage.id }">
			<input id="createName" name="createName" type="hidden" value="${wIntegralPage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wIntegralPage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wIntegralPage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wIntegralPage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wIntegralPage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wIntegralPage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wIntegralPage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wIntegralPage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wIntegralPage.bpmStatus }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">会员联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">积分来源:</label>
		     	 <input id="integralSource" name="integralSource" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">积分:</label>
		     	 <input id="integralNumber" name="integralNumber" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">积分类型0入账1出账:</label>
		     	 <input id="integralType" name="integralType" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wintegral/wIntegral.js"></script>	
	