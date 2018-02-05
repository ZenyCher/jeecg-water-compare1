<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>充值报表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wViewRechargeController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wViewRechargePage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wViewRechargePage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wViewRechargePage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wViewRechargePage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wViewRechargePage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wViewRechargePage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wViewRechargePage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wViewRechargePage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wViewRechargePage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wViewRechargePage.bpmStatus }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
		     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.memberName}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.memberPhone}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系地址:</label>
		     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.memberAddress}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">充值时间:</label>
		     	 <input id="rechargeDate" name="rechargeDate" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.rechargeDate}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">充值金额:</label>
		     	 <input id="rechargeSum" name="rechargeSum" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.rechargeSum}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">充值水量:</label>
		     	 <input id="rechargeWater" name="rechargeWater" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.rechargeWater}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">获赠水量:</label>
		     	 <input id="rechargeReceiveWater" name="rechargeReceiveWater" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.rechargeReceiveWater}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">充值水量合计:</label>
		     	 <input id="rechargeCountWater" name="rechargeCountWater" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.rechargeCountWater}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">充值积分:</label>
		     	 <input id="rechargeCountIntegral" name="rechargeCountIntegral" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewRechargePage.rechargeCountIntegral}'/>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/WViewRecharge/wViewRecharge.js"></script>		
