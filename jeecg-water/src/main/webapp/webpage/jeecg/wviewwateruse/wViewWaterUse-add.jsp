<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用水明细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wViewWaterUseController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wViewWaterUsePage.id }">
			<input id="createName" name="createName" type="hidden" value="${wViewWaterUsePage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wViewWaterUsePage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wViewWaterUsePage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wViewWaterUsePage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wViewWaterUsePage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wViewWaterUsePage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wViewWaterUsePage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wViewWaterUsePage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wViewWaterUsePage.bpmStatus }">
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
		      <label class="Validform_label">安装时间:</label>
		     	 <input id="installEndtime" name="installEndtime" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">水表id:</label>
		     	 <input id="deviceId" name="deviceId" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">水表初始值:</label>
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
		      <label class="Validform_label">充值金额合计:</label>
		     	 <input id="rechargeSum" name="rechargeSum" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">充值合计水量:</label>
		     	 <input id="rechargeWaterCount" name="rechargeWaterCount" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">已用水量:</label>
		     	 <input id="waterUsed" name="waterUsed" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">剩余水量:</label>
		     	 <input id="waterSurplus" name="waterSurplus" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/WViewWaterUse/wViewWaterUse.js"></script>	
	