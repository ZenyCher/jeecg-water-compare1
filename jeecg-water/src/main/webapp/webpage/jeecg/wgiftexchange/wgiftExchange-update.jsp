<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>礼品兑换表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wGiftExchangeController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wGiftExchangePage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wGiftExchangePage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wGiftExchangePage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wGiftExchangePage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wGiftExchangePage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wGiftExchangePage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wGiftExchangePage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wGiftExchangePage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wGiftExchangePage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wGiftExchangePage.bpmStatus }"/>
			<input id="giftId" name="giftId" type="hidden" value="${wGiftExchangePage.giftId }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">单号:</label>
		     	 <input id="giftexchangeOrder" name="giftexchangeOrder" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeOrder}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">处理状态:</label>
<!-- 		     	 <input id="giftexchangeState" name="giftexchangeState" type="text" style="width: 150px" class="inputxt"  -->
<!-- 					ignore="checked" datatype="*"   -->
<%-- 					value='${wGiftExchangePage.giftexchangeState}'/> --%>
				<select id="giftexchangeState" name="giftexchangeState">
					<option <c:if test="${wGiftExchangePage.giftexchangeState eq '0'}">selected</c:if> value="0">待支付</option>
					<option <c:if test="${wGiftExchangePage.giftexchangeState eq '1'}">selected</c:if> value="1">待发货</option>
					<option <c:if test="${wGiftExchangePage.giftexchangeState eq '2'}">selected</c:if> value="2">待收货</option>
					<option <c:if test="${wGiftExchangePage.giftexchangeState eq '3'}">selected</c:if> value="3">已完成</option>
				</select>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">处理人:</label>
		     	 <input id="giftexchangeHandle" name="giftexchangeHandle" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeHandle}'/>
		      <span class="Validform_checktip"></span>
		    </div>
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">礼品名称:</label> -->
<!-- 		     	 <input id="giftName" name="giftName" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	  datatype="*"  value='${wGiftExchangePage.giftName}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">礼品数量:</label> -->
<!-- 		     	 <input id="giftexchangeNumber" name="giftexchangeNumber" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeNumber}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">兑换时间:</label> -->
<!-- 					  <input id="giftexchangeTime" name="giftexchangeTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*" -->
<!-- 									ignore="checked" -->
<%-- 		      						  value='<fmt:formatDate value='${wGiftExchangePage.giftexchangeTime}' type="date" pattern="yyyy-MM-dd"/>'/>    --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">收货人:</label> -->
<!-- 		     	 <input id="giftexchangeConsignee" name="giftexchangeConsignee" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeConsignee}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">联系方式:</label> -->
<!-- 		     	 <input id="giftexchangePhone" name="giftexchangePhone" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	  datatype="*"  value='${wGiftExchangePage.giftexchangePhone}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">收货地址:</label> -->
<!-- 		     	 <input id="giftexchangeAddress" name="giftexchangeAddress" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeAddress}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
			<div class="form">
		      <label class="Validform_label">快递公司:</label>
		     	 <input id="giftexchangeExpress" name="giftexchangeExpress" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeExpress}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">快递单号:</label>
		     	 <input id="giftexchangeCouriernumber" name="giftexchangeCouriernumber" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeCouriernumber}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">经办人:</label>
		     	 <input id="giftexchangeOperator" name="giftexchangeOperator" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeOperator}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">快递费:</label>
		     	 <input id="giftexchangeCost" name="giftexchangeCost" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeCost}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">寄出时间:</label>
					  <input id="giftexchangeMailtime" name="giftexchangeMailtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"
									ignore="checked"
		      						  value='<fmt:formatDate value='${wGiftExchangePage.giftexchangeMailtime}' type="date" pattern="yyyy-MM-dd"/>'/>   
		      <span class="Validform_checktip"></span>
		    </div>
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">兑换积分:</label> -->
<!-- 		     	 <input id="giftexchangeIntegral" name="giftexchangeIntegral" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	  datatype="*"  value='${wGiftExchangePage.giftexchangeIntegral}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wgiftExchange/wGiftExchange.js"></script>		
