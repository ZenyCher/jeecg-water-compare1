<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安装工</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="werectorController.do?doAdd" >
			<input id="id" name="id" type="hidden" value="${wErectorPage.id }">
			<input id="createName" name="createName" type="hidden" value="${wErectorPage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wErectorPage.createBy }">
			<input id="updateName" name="updateName" type="hidden" value="${wErectorPage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wErectorPage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wErectorPage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wErectorPage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wErectorPage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wErectorPage.bpmStatus }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">安装公司:</label>
		     	 <input id="erectorCompany" name="erectorCompany" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									  datatype="*"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装负责人:</label>
		     	 <input id="erectorPerson" name="erectorPerson" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									  datatype="*"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		     	 <input id="erectorPhone" name="erectorPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									  datatype="m"/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">固定电话:</label>
		     	 <input id="erectorFixedline" name="erectorFixedline" type="text" style="width: 150px" class="inputxt" 
									datatype="n"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">服务区域:</label>
		     	 <input id="erectorRegion" name="erectorRegion" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									  datatype="*"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">对应后台账号:</label>
			<input id="erectorAdmin" name="erectorAdmin" type="text" style="width: 150px" class="searchbox-inputtext" datatype="*" 
			ignore="ignore"
			 onclick="inputClick(this,'erector_admin','user_msg')"/>		 
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建日期:</label>
					  <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
									ignore="checked"
					     datatype="*"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">备注:</label>
		     	 <input id="erectorRemarks" name="erectorRemarks" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">是否有效:</label>
					<t:dictSelect field="erectorState" type="list" 
						typeGroupCode="erectorS" defaultVal="${wErectorPage.erectorState}" hasLabel="false"  title="是否有效" datatype="*"></t:dictSelect>     
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/werector/werector.js"></script>	
	