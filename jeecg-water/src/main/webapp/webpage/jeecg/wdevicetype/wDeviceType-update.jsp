<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>净水器类型</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wDeviceTypeController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wDeviceTypePage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wDeviceTypePage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wDeviceTypePage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wDeviceTypePage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wDeviceTypePage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wDeviceTypePage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wDeviceTypePage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wDeviceTypePage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wDeviceTypePage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wDeviceTypePage.bpmStatus }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">型号:</label>
		     	 <input id="deviceType" name="deviceType" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="*" 
		     	   value='${wDeviceTypePage.deviceType}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">名称:</label>
		     	 <input id="deviceName" name="deviceName" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="*" 
		     	   value='${wDeviceTypePage.deviceName}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">滤芯数量:</label>
<!-- 		     	 <input id="deviceFilterNum" name="deviceFilterNum" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="checked" -->
<%-- 		     	   value='${wDeviceTypePage.deviceFilterNum}'/> --%>
		     	 <select id="deviceFilterNum" name="deviceFilterNum" onchange="typedisabled();">
				 	<option value="3" <c:if test="${wDeviceTypePage.deviceFilterNum eq 3 }">selected</c:if> >3</option>
				 	<option value="4" <c:if test="${wDeviceTypePage.deviceFilterNum eq 4 }">selected</c:if> >4</option>
				 	<option value="5" <c:if test="${wDeviceTypePage.deviceFilterNum eq 5 }">selected</c:if> >5</option>
				 	<option value="6" <c:if test="${wDeviceTypePage.deviceFilterNum eq 6 }">selected</c:if> >6</option>
				 </select>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">滤芯1更换水量:</label>
		     	 <input id="filterNumOne" name="filterNumOne" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="n" 
		     	   value='${wDeviceTypePage.filterNumOne}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">滤芯2更换水量:</label>
		     	 <input id="filterNumTwo" name="filterNumTwo" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="n" 
		     	   value='${wDeviceTypePage.filterNumTwo}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" id="filter_Three">
		      <label class="Validform_label">滤芯3更换水量:</label>
		     	 <input id="filterNumThree" name="filterNumThree" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="n" 
		     	   value='${wDeviceTypePage.filterNumThree}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" id="filter_Four">
		      <label class="Validform_label">滤芯4更换水量:</label>
		     	 <input id="filterNumFour" name="filterNumFour" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="n" 
		     	   value='${wDeviceTypePage.filterNumFour}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" id="filter_Five">
		      <label class="Validform_label">滤芯5更换水量:</label>
		     	 <input id="filterNumFive" name="filterNumFive" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="n" 
		     	   value='${wDeviceTypePage.filterNumFive}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" id="filter_Six">
		      <label class="Validform_label">滤芯6更换水量:</label>
		     	 <input id="filterNumSix" name="filterNumSix" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="n" 
		     	   value='${wDeviceTypePage.filterNumSix}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">备注:</label>
		     	 <input id="remarks" name="remarks" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wDeviceTypePage.remarks}'/>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wdevicetype/wDeviceType.js"></script>
    <script type="text/javascript">
	  $(function(){
		  typedisabled(); 
	  });
  </script>		
