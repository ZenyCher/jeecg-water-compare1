<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>会员用水量统计</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wWaterStatisticsController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${wWaterStatisticsPage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${wWaterStatisticsPage.createName }"/>
		<input id="createBy" name="createBy" type="hidden" value="${wWaterStatisticsPage.createBy }"/>
		<input id="createDate" name="createDate" type="hidden" value="${wWaterStatisticsPage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${wWaterStatisticsPage.updateName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${wWaterStatisticsPage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${wWaterStatisticsPage.updateDate }"/>
		<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wWaterStatisticsPage.sysOrgCode }"/>
		<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wWaterStatisticsPage.sysCompanyCode }"/>
		<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wWaterStatisticsPage.bpmStatus }"/>
		<input id="memberPhone" name="memberPhone" type="hidden" value="${wWaterStatisticsPage.memberPhone }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							会员姓名:
						</label>
					</td>
					<td class="value">
						<input id="memberName" name="memberName" type="text" style="width: 150px" class="searchbox-inputtext" 
							datatype="*"
						ignore="checked"
						 onclick="inputClick(this,'member_name','user_register')" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员姓名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用水统计:
						</label>
					</td>
					<td class="value">
					     	 <input id="waterStatistics" name="waterStatistics" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用水统计</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/jeecg/wWaterStatistics/wWaterStatistics.js"></script>		
