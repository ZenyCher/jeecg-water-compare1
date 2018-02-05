<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>设备购买报表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wViewDevicePurchaseController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wViewDevicePurchasePage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wViewDevicePurchasePage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wViewDevicePurchasePage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wViewDevicePurchasePage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wViewDevicePurchasePage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wViewDevicePurchasePage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wViewDevicePurchasePage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wViewDevicePurchasePage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wViewDevicePurchasePage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wViewDevicePurchasePage.bpmStatus }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
		     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.memberName}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.memberPhone}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系地址:</label>
		     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.memberAddress}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">下单时间:</label>
		     	 <input id="orderDate" name="orderDate" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.orderDate}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">押金:</label>
		     	 <input id="memberDeposit" name="memberDeposit" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.memberDeposit}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">型号:</label>
		     	 <input id="memberDeviceType" name="memberDeviceType" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.memberDeviceType}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装状态:</label>
		     	 <input id="installProgress" name="installProgress" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.installProgress}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装完成时间:</label>
		     	 <input id="installEndtime" name="installEndtime" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.installEndtime}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装公司:</label>
		     	 <input id="installWorker" name="installWorker" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.installWorker}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">水表id:</label>
		     	 <input id="deviceId" name="deviceId" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewDevicePurchasePage.deviceId}'/>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/WViewDevicePurchase/wViewDevicePurchase.js"></script>		
