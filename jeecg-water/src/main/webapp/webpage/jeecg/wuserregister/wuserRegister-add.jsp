<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户注册表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuserRegisterController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${wuserRegisterPage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${wuserRegisterPage.createName }"/>
		<input id="createBy" name="createBy" type="hidden" value="${wuserRegisterPage.createBy }"/>
		<input id="createDate" name="createDate" type="hidden" value="${wuserRegisterPage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${wuserRegisterPage.updateName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${wuserRegisterPage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${wuserRegisterPage.updateDate }"/>
		<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wuserRegisterPage.sysOrgCode }"/>
		<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wuserRegisterPage.sysCompanyCode }"/>
		<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wuserRegisterPage.bpmStatus }"/>
		<input id="memberPhone" name="memberPhone" type="hidden" value="${wuserRegisterPage.memberPhone }"/>
		<input id="passWord" name="passWord" type="hidden" value="${wuserRegisterPage.passWord }"/>
		<input id="registerHead" name="registerHead" type="hidden" value="${wuserRegisterPage.registerHead }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名:
						</label>
					</td>
					<td class="value">
					     	 <input id="registerName" name="registerName" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							手机号码:
						</label>
					</td>
					<td class="value">
					     	 <input id="registerPhone" name="registerPhone" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机号码</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							关联会员:
						</label>
					</td>
					<td class="value">
					     	 <input id="registerRelation" name="registerRelation" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">关联会员</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="registerType" name="registerType" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							账号状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="registerState" name="registerState" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账号状态</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/jeecg/wuserregister/wuserRegister.js"></script>		
