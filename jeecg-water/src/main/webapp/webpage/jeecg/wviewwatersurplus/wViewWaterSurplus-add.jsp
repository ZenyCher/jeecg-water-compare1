<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>剩余水量报表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wViewWaterSurplusController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wViewWaterSurplusPage.id }">
			<input id="createName" name="createName" type="hidden" value="${wViewWaterSurplusPage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wViewWaterSurplusPage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wViewWaterSurplusPage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wViewWaterSurplusPage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wViewWaterSurplusPage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wViewWaterSurplusPage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wViewWaterSurplusPage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wViewWaterSurplusPage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wViewWaterSurplusPage.bpmStatus }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
		     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系地址:</label>
		     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">水表id:</label>
		     	 <input id="waterId" name="waterId" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">初始值:</label>
		     	 <input id="waterNum" name="waterNum" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">水表当前读数:</label>
		     	 <input id="waterCurrent" name="waterCurrent" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">充值合计水量:</label>
		     	 <input id="waterRecharge" name="waterRecharge" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">当前剩余水量:</label>
		     	 <input id="waterSurplus" name="waterSurplus" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/WViewWaterSurplus/wViewWaterSurplus.js"></script>	
	