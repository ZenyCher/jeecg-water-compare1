<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户用水告警统计</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wWaterWarningController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wWaterWarningPage.id }">
					<input id="createName" name="createName" type="hidden" value="${wWaterWarningPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${wWaterWarningPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${wWaterWarningPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${wWaterWarningPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${wWaterWarningPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${wWaterWarningPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wWaterWarningPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wWaterWarningPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wWaterWarningPage.bpmStatus }">
					<input id="waterState" name="waterState" type="hidden" value="${wWaterWarningPage.waterState }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="checked" 
						     	 value='${wWaterWarningPage.memberName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员联系方式:
							</label>
						</td>
						<td class="value">
						     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${wWaterWarningPage.memberPhone}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员联系方式</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								剩余水量:
							</label>
						</td>
						<td class="value">
						     	 <input id="waterNumber" name="waterNumber" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="checked" 
						     	 value='${wWaterWarningPage.waterNumber}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">剩余水量</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/jeecg/wwaterwarning/wWaterWarning.js"></script>		
