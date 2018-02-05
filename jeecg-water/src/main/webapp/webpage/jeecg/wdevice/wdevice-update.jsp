<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>净水器设备表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wdeviceController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wdevicePage.id }">
					<input id="createName" name="createName" type="hidden" value="${wdevicePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${wdevicePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${wdevicePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${wdevicePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${wdevicePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${wdevicePage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wdevicePage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wdevicePage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wdevicePage.bpmStatus }">
					<input id="filterId" name="filterId" type="hidden" value="${wdevicePage.filterId }"/>
					<input id="mallIntroduceId" name="mallIntroduceId" type="hidden" value="${wdevicePage.mallIntroduceId }"/>
					<input id="mallIntroduceName" name="mallIntroduceName" type="hidden" value="${wdevicePage.mallIntroduceName }"/>
					<input id="deviceTypeId" name="deviceTypeId" type="hidden" value="${wdevicePage.deviceTypeId }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								设备id:
							</label>
						</td>
						<td class="value">
						    <input id="deviceId" name="deviceId" type="text" style="width: 150px" class="inputxt"  datatype="/\w/i" 
						     	 ignore="checked" value='${wdevicePage.deviceId}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								设备型号:
							</label>
						</td>
						<td class="value">
						     <input id="deviceModel" name="deviceModel" type="text" style="width: 150px" class="inputxt"  datatype="*" 
						     	 ignore="checked" value='${wdevicePage.deviceModel}'
						     	 onclick="popupClick(this,'device_type,device_name,device_filter_num','deviceModel,deviceName,filterNember','device_type');"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备型号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								设备名称:
							</label>
						</td>
						<td class="value">
						    <input id="deviceName" name="deviceName" type="text" style="width: 150px" class="inputxt"
						     	  value='${wdevicePage.deviceName}' readOnly="true"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								滤芯数量:
							</label>
						</td>
						<td class="value">
						    <input id="filterNember" name="filterNember" type="text" style="width: 150px" class="inputxt"
						     	 ignore="checked" value='${wdevicePage.filterNember}' readOnly="true" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">滤芯数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生产日期:
							</label>
						</td>
						<td class="value">
									  <input id="deviceTime" name="deviceTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*" 
									  ignore="checked"
									    value='<fmt:formatDate value='${wdevicePage.deviceTime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生产日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								防伪码:
							</label>
						</td>
						<td class="value">
						     	 <input id="deviceCode" name="deviceCode" type="text" style="width: 150px" class="inputxt"  datatype="*" 
						     	 ignore="checked" 
						     	 value='${wdevicePage.deviceCode}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">防伪码</label>
						</td>
					</tr>
<!-- 				<tr> -->
<!-- 					<td align="right"> -->
<!-- 						<label class="Validform_label"> -->
<!-- 							商城产品: -->
<!-- 						</label> -->
<!-- 					</td> -->
<!-- 					<td class="value"> -->
<%-- 							<input id="title" name="title" type="text" style="width: 150px" class="inputxt" ignore="ignore" datatype="*" value="${wdevicePage.mallIntroduceName }"/> --%>
<%-- 					     	<input id="mallIntroduceId" name="mallIntroduceId" type="hidden" value="${wdevicePage.mallIntroduceId }"/> --%>
<%-- 					     	<t:choose hiddenName="mallIntroduceId" hiddenid="id" url="wdeviceController.do?mallIntroduceAssign" name="mallIntroduceList" icon="icon-search" title="选择产品" textname="title" isclear="true" isInit="true"></t:choose> --%>
<!-- 					     	<label class="Validform_label" style="display: none;">商城产品</label> -->
<!-- 						</td> -->
<!-- 				</tr> -->
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/jeecg/wdevice/wdevice.js"></script>		
