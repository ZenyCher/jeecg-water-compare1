<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>维护保养管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
  	th, td {
  		padding: 0.3em 1em;
	} 
  </style>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wrepairController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wRepairPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wRepairPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wRepairPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wRepairPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wRepairPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wRepairPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wRepairPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wRepairPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wRepairPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wRepairPage.bpmStatus }"/>
			<input id="registerId" name="registerId" type="hidden" value="${wRepairPage.registerId }"/>
			<input id="maintainSign" name="maintainSign" type="hidden" value="${wRepairPage.maintainSign }"/>
			<input id="maintainSubphoto" name="maintainSubphoto" type="hidden" value="${wRepairPage.maintainSubphoto }"/>
			<input id="filterNember" name="filterNember" type="hidden" value="${wDevicePage.filterNember }" />
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">设备id:</label>
				<input id="deviceId" name="deviceId" class="inputxt" value='${wRepairPage.deviceId}'/>
				<input name="deviceName" id="deviceName" type="hidden" value="" readonly="readonly" />
				<t:choose hiddenName="deviceId" hiddenid="deviceId" url="wrepairController.do?assignDevice" name="deviceList" icon="icon-search" title="选择设备" textname="deviceName" isclear="true" isInit="true"></t:choose> 
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护状态:</label>
					<t:dictSelect field="maintainState" type="list" 
						typeGroupCode="maintainS" defaultVal="${wRepairPage.maintainState}" hasLabel="false"  title="维护状态"></t:dictSelect>     
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护负责人:</label>
		     	 <input id="registerName" name="registerName" type="text" style="width: 150px" class="inputxt" ignore="ignore"
		     	   value='${wRepairPage.registerName}' readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护类型:</label>
		     	 <input id="maintainType" name="maintainType" type="text" style="width: 150px" class="inputxt" ignore="checked"
		     	   value='${wRepairPage.maintainType}' readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
			<input id="memberName" name="memberName" type="text" style="width: 150px" class="searchbox-inputtext" ignore="checked" readOnly="true"
			  value='${wRepairPage.memberName}' value='${wRepairPage.memberName}'/>			 
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		     	 <input id="memberPhone" name="memberPhone" type="text" style="width: 150px" class="inputxt" ignore="ignore"
		     	   value='${wRepairPage.memberPhone}' readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护地址:</label>
		     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" ignore="ignore"
		     	   value='${wRepairPage.memberAddress}' readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">需服务内容:</label>
		     	 <input id="maintainService" name="maintainService" type="text" style="width: 150px" class="inputxt" ignore="checked"
		     	   value='${wRepairPage.maintainService}' readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">计划维护时间:</label>
					  <input id="maintainTime" name="maintainTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" 
									ignore="checked" readOnly="true"
		      						  value='<fmt:formatDate value='${wRepairPage.maintainTime}' type="date" pattern="yyyy-MM-dd"/>'/>   
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护记录:</label>
		     	 <input id="maintainRecord" name="maintainRecord" type="text" style="width: 150px" class="inputxt" ignore="ignore"
		     	   value='${wRepairPage.maintainRecord}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">备注:</label>
		     	 <input id="maintainRemarks" name="maintainRemarks" type="text" style="width: 150px" class="inputxt" ignore="ignore"
		     	   value='${wRepairPage.maintainRemarks}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">维护完成时间:</label>
<!-- 		     	 <input id="maintainEndtime" name="maintainEndtime" type="text" style="width: 150px" class="inputxt" ignore="ignore" -->
<%-- 		     	   value='${wRepairPage.maintainEndtime}'/> --%>
		     	 <input id="maintainEndtime" name="maintainEndtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" 
					ignore="checked"
		      		value='<fmt:formatDate value='${wRepairPage.maintainEndtime}' type="date" pattern="yyyy-MM-dd"/>'/> 
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form" id="maintainFilter_type" style="display:none">
		    	<label class="Validform_label">维护滤芯:</label>
		     	<input id="maintainFilter" name="maintainFilter" type="text" style="width: 150" class="inputxt" ignore="checked"/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form" id="maintainWater_type" style="display:none">
		    	<label class="Validform_label">维护滤芯时水量:</label>
		     	<input id="maintainWater" name="maintainWater" type="text" style="width: 150" class="inputxt" ignore="checked"/>
		      	<span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		    	<table id="maintainType_id">
		    		<tr style="text-align:center;" style="display:none">
		    			<th>更换否</th>
		    			<th>第几道滤芯</th>
		    			<th>滤芯ID</th>
		    			<th>滤芯更换读数</th>
		    		</tr>
		    		<tr class="filter_check" style="display:none">
		    			<td><input type="checkbox" onchange=""/></td>
		    			<td><font size="5">第一道滤芯</font></td>
		    			<td><input id="oneFilterId" name="oneFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.oneFilterId}'/></td>
		    			<td><input id="oneFilterName" name="oneFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.oneFilterName}'></td>
		    		</tr>
		    		<tr class="filter_check" style="display:none">
		    			<td><input type="checkbox"/></td>
		    			<td><font size="5">第二道滤芯</font></td>
		    			<td><input id="twoFilterId" name="twoFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.twoFilterId}'/></td>
		    			<td><input id="twoFilterName" name="twoFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.twoFilterName}' /></td>
		    		</tr>
		    		<tr class="filter_check" style="display:none">
		    			<td><input type="checkbox"/></td>
		    			<td><font size="5">第三道滤芯</font></td>
		    			<td><input id="threeFilterId" name="threeFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.threeFilterId}'/></td>
		    			<td><input id="threeFilterName" name="threeFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.threeFilterName}' /></td>
		    		</tr>
		    		<tr class="filter_check" style="display:none">
		    			<td><input type="checkbox"/></td>
		    			<td><font size="5">第四道滤芯</font></td>
		    			<td><input id="fourFilterId" name="fourFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.fourFilterId}'/></td>
		    			<td><input id="fourFilterName" name="fourFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.fourFilterName}' /></td>
		    		</tr>
		    		<tr class="filter_check" style="display:none">
		    			<td><input type="checkbox"/></td>
		    			<td><font size="5">第五道滤芯</font></td>
		    			<td><input id="fiveFilterId" name="fiveFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.fiveFilterId}'/></td>
		    			<td><input id="fiveFilterName" name="fiveFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.fiveFilterName}' /></td>
		    		</tr>
		    		<tr class="filter_check" style="display:none">
		    			<td><input type="checkbox"/></td>
		    			<td><font size="5">第六道滤芯</font></td>
		    			<td><input id="sixFilterId" name="sixFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.sixFilterId}'/></td>
		    			<td><input id="sixFilterName" name="sixFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wRepairPage.sixFilterName}' /></td>
		    		</tr>
		    	</table>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
<script type="text/javascript" >
$(function(){
	$("#maintainType_id").css("display","none");
	$("#maintainFilter_type").css("display","none");
	$("#maintainWater_type").css("display","none");
	var maintainType = $("#maintainType").val();
	if( maintainType == 0 ){
		$("#maintainType").val("故障");
	}else if( maintainType == 1 ){
		$("#maintainType").val("滤芯更换");
		$("#maintainFilter_type").css("display","");
		$("#maintainWater_type").css("display","");
		$("#maintainType_id").css("display","");
	}else if( maintainType == 2 ){
		$("#maintainType").val("其他");
	}
	var filterNumber = $("#filterNember").val();
	for(var i=0;i<=filterNumber;i++){
		$("#maintainType_id").children().children().eq(i).css("display","");
	}
	$(".filter_check").on('change',function(){
		var next1 = $(this).children().eq(0).children();
		if( next1.prop("checked") ){
			$(this).children().eq(2).children().eq(0).attr("ignore","checked");
			$(this).children().eq(3).children().eq(0).attr("ignore","checked");//readOnly="true"
			$(this).children().eq(2).children().eq(0).removeAttr("disabled");
			$(this).children().eq(3).children().eq(0).removeAttr("disabled");
		}else{
// 			$(this).children().eq(2).children().eq(0).attr("ignore","");
// 			$(this).children().eq(3).children().eq(0).attr("ignore","");
			$(this).children().eq(2).children().eq(0).attr({"ignore":"","disabled":"disabled"});
			$(this).children().eq(3).children().eq(0).attr({"ignore":"","disabled":"disabled"});
		}
	});
})
</script>
<!--   <script src = "webpage/jeecg/wrepair/wrepair.js"></script>		 -->
