<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安装工人管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wPersonnel.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wUserRegisterPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wUserRegisterPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wUserRegisterPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wUserRegisterPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wUserRegisterPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wUserRegisterPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wUserRegisterPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wUserRegisterPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wUserRegisterPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wUserRegisterPage.bpmStatus }"/>
			<input id="memberPhone" name="memberPhone" type="hidden" value="${wUserRegisterPage.memberPhone }"/>
			<input id="passWord" name="passWord" type="hidden" value="${wUserRegisterPage.passWord }"/>
			<input id="registerHead" name="registerHead" type="hidden" value="${wUserRegisterPage.registerHead }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">用户名:</label>
		     	 <input id="registerName" name="registerName" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wUserRegisterPage.registerName}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">手机号码:</label>
		     	 <input id="registerPhone" name="registerPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wUserRegisterPage.registerPhone}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">账号状态:</label>
<%-- 				<t:dictSelect field="registerState" type="list" typeGroupCode="registerS" defaultVal="${wUserMemberPage.registerState }" --%>
<%-- 				 hasLabel="false" title="注册用户激活状态"></t:dictSelect> --%>
				<select id="registerState" name="registerState">
				 	<option <c:if test="${wUserMemberPage.registerState eq '0'}">selected</c:if> value="0">待激活</option>
					<option <c:if test="${wUserMemberPage.registerState eq '1'}">selected</c:if> value="1">激活</option>
					<option <c:if test="${wUserMemberPage.registerState eq '2'}">selected</c:if> value="2">禁用</option>
				</select>   
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wuserRegister/wUserRegister.js"></script>		
