<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>会员充值统计</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wRechargeStatisticsController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${wRechargeStatisticsPage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${wRechargeStatisticsPage.createName }"/>
		<input id="createBy" name="createBy" type="hidden" value="${wRechargeStatisticsPage.createBy }"/>
		<input id="createDate" name="createDate" type="hidden" value="${wRechargeStatisticsPage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${wRechargeStatisticsPage.updateName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${wRechargeStatisticsPage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${wRechargeStatisticsPage.updateDate }"/>
		<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wRechargeStatisticsPage.sysOrgCode }"/>
		<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wRechargeStatisticsPage.sysCompanyCode }"/>
		<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wRechargeStatisticsPage.bpmStatus }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							会员姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员姓名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							充值金额合计:
						</label>
					</td>
					<td class="value">
					     	 <input id="rechargeStatistics" name="rechargeStatistics" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">充值金额合计</label>
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
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员联系方式</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wrechargeStatistics/wRechargeStatistics.js"></script>		
