<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>充值记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wrechargeController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${wrechargePage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${wrechargePage.createName }"/>
		<input id="createBy" name="createBy" type="hidden" value="${wrechargePage.createBy }"/>
		<input id="createDate" name="createDate" type="hidden" value="${wrechargePage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${wrechargePage.updateName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${wrechargePage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${wrechargePage.updateDate }"/>
		<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wrechargePage.sysOrgCode }"/>
		<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wrechargePage.sysCompanyCode }"/>
		<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wrechargePage.bpmStatus }"/>
		<input id="memberPhone" name="memberPhone" type="hidden" value="${wrechargePage.memberPhone }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							会员姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员姓名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备id:
						</label>
					</td>
					<td class="value">
					     	 <input id="deviceId" name="deviceId" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备id</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							居住地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">居住地址</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							充值金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="rechargeSum" name="rechargeSum" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="*" 
					     	  ignore="checked"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">充值金额</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							充值时间:
						</label>
					</td>
					<td class="value">
							   <input id="rechargeTime" name="rechargeTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" 
					      						 datatype="*"  
					      						ignore="checked"
					      						/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">充值时间</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/jeecg/wrecharge/wrecharge.js"></script>		
