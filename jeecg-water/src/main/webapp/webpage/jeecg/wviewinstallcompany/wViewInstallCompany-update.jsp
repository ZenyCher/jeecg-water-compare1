<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安装公司结算</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wViewInstallCompanyController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wViewInstallCompanyPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wViewInstallCompanyPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wViewInstallCompanyPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wViewInstallCompanyPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wViewInstallCompanyPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wViewInstallCompanyPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wViewInstallCompanyPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wViewInstallCompanyPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wViewInstallCompanyPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wViewInstallCompanyPage.bpmStatus }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">安装公司:</label>
		     	 <input id="installWorker" name="installWorker" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.installWorker}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
		     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.memberName}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.memberPhone}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员联系地址:</label>
		     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.memberAddress}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">下单时间:</label>
		     	 <input id="orderDate" name="orderDate" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.orderDate}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">水表di:</label>
		     	 <input id="deviceId" name="deviceId" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.deviceId}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">型号:</label>
		     	 <input id="memberDeviceType" name="memberDeviceType" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.memberDeviceType}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装状态:</label>
		     	 <input id="installProgress" name="installProgress" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.installProgress}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装完成时间:</label>
		     	 <input id="installEndtime" name="installEndtime" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wViewInstallCompanyPage.installEndtime}'/>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/WViewInstallCompany/wViewInstallCompany.js"></script>		
