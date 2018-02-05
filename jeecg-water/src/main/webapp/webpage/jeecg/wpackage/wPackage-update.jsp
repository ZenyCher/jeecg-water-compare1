<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>套餐管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wPackageController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wPackagePage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wPackagePage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wPackagePage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wPackagePage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wPackagePage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wPackagePage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wPackagePage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wPackagePage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wPackagePage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wPackagePage.bpmStatus }"/>
			<input id="packageFather" name="packageFather" type="hidden" value="${wPackagePage.packageFather }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">套餐名称:</label>
		     	 <input id="packageMode" name="packageMode" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wPackagePage.packageMode}'/>
		      <span class="Validform_checktip"></span>
		    </div>
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">套餐类型:</label> -->
<%-- 					<t:dictSelect field="packageType" type="list"  --%>
<%-- 						typeGroupCode="packageT" defaultVal="${wPackagePage.packageType}" hasLabel="false"  title="套餐类型"></t:dictSelect>      --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">优惠规则描述:</label> -->
<!-- 		     	 <input id="packageDescribe" name="packageDescribe" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	  datatype="*"  value='${wPackagePage.packageDescribe}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
			<div class="form">
		      <label class="Validform_label">套餐类型:</label>
		      <select id="packageType" name="packageType" onchange="selectType();">
		      	<option value="0" <c:if test="${wPackagePage.packageType eq 0}">selected="selected"</c:if>>充钱送水</option>
		      	<option value="1" <c:if test="${wPackagePage.packageType eq 1}">selected="selected"</c:if>>首冲优惠</option>
		      	<option value="2" <c:if test="${wPackagePage.packageType eq 2}">selected="selected"</c:if>>充钱送积分</option>
		      </select>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">优惠规则描述:</label>
		      <input type="text" id="packageDescribe" name="packageDescribe" style="width:150px" disabled="disabled"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">赠送部分（L/个）:</label>
		     	 <input id="packageValue" name="packageValue" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="n"  value='${wPackagePage.packageValue}'/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">充值金额（元）:</label>
		     	 <input id="packageMax" name="packageMax" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="n" value='${wPackagePage.packageMax}'/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">水单价（元）:</label>
		     	 <input id="packageConver" name="packageConver" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="*" value='${wPackagePage.packageConver}'/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">充值类型:</label>
				<select id="packageClass" name="packageClass" ignore="checked" datatype="*">
					<option <c:if test="${wPackagePage.packageClass eq 0 }">selected</c:if> value="0">充积分</option>
					<option <c:if test="${wPackagePage.packageClass eq 1 }">selected</c:if> value="1">充水量</option>
				</select>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
					<t:dictSelect field="packageState" type="list" 
						typeGroupCode="package" defaultVal="${wPackagePage.packageState}" hasLabel="false"  title="状态" datatype="*"></t:dictSelect>     
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
<script type="text/javascript">
	$(function(){
		selectType();
	});
	
	function selectType(){
		var sel=document.getElementsByName("packageType")[0];
		var selvalue= sel.options[sel.options.selectedIndex].value//你要的值
		if(selvalue == 0){
			$("#packageDescribe").val('每满100元，送水多少升');
		}else if(selvalue == 1){
			$("#packageDescribe").val('首次充值送水多少升');
		}else if(selvalue == 2){
			$("#packageDescribe").val('所获积分=充值金额X折算比率');
		}
	}
	
</script>	
  <script src = "webpage/jeecg/wpackage/wPackage.js"></script>		
