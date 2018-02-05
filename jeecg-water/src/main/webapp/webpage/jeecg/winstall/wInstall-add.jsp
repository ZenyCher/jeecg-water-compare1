<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安装管理表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wInstallController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${wInstallPage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${wInstallPage.createName }"/>
		<input id="createBy" name="createBy" type="hidden" value="${wInstallPage.createBy }"/>
		<input id="createDate" name="createDate" type="hidden" value="${wInstallPage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${wInstallPage.updateName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${wInstallPage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${wInstallPage.updateDate }"/>
		<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wInstallPage.sysOrgCode }"/>
		<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wInstallPage.sysCompanyCode }"/>
		<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wInstallPage.bpmStatus }"/>
		<input id="installWater" name="installWater" type="hidden" value="${wInstallPage.installWater }"/>
		<input id="installFilterId" name="installFilterId" type="hidden" value="${wInstallPage.installFilterId }"/>
		<input id="installFilterWater" name="installFilterWater" type="hidden" value="${wInstallPage.installFilterWater }"/>
		<input id="installEndtime" name="installEndtime" type="hidden" value="${wInstallPage.installEndtime }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备id:
						</label>
					</td>
					<td class="value">
						<input id="deviceId" name="deviceId" type="text" style="width: 150px" class="searchbox-inputtext" 
							datatype="*"
						ignore="checked"
						 onclick="inputClick(this,'device_id','usm_device')" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备id</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安装进度:
						</label>
					</td>
					<td class="value">
					     	 <input id="installProgress" name="installProgress" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装进度</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							会员姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="installMembername" name="installMembername" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员姓名</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							会员联系方式:
						</label>
					</td>
					<td class="value">
					     	 <input id="instalPhont" name="instalPhont" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员联系方式</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安装地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="installAddress" name="installAddress" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装地址</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							水表ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="installNumber" name="installNumber" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">水表编号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安装来源:
						</label>
					</td>
					<td class="value">
					     	 <input id="installSource" name="installSource" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装来源</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安装工:
						</label>
					</td>
					<td class="value">
					     	 <input id="installWorker" name="installWorker" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装工</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安装时间:
						</label>
					</td>
					<td class="value">
							   <input id="installTime" name="installTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" 
					      						 datatype="*"  
					      						ignore="checked"
					      						/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安装等级信息:
						</label>
					</td>
					<td class="value">
					     	 <input id="installMessage" name="installMessage" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装等级信息</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/jeecg/winstall/wInstall.js"></script>		
