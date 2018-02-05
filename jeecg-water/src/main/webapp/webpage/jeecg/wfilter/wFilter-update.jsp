<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>滤芯设备</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wFilterController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wFilterPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wFilterPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wFilterPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wFilterPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wFilterPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wFilterPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wFilterPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wFilterPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wFilterPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wFilterPage.bpmStatus }"/>
			<input id="filterState" name="filterState" type="hidden" value="${wFilterPage.filterState }"/>
			<input id="filterInstalledwater" name="filterInstalledwater" type="hidden" value="${wFilterPage.filterInstalledwater }">
			<input id="filterTotalwater" name="filterTotalwater" type="hidden" value="${wFilterPage.filterTotalwater }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">滤芯id:</label>
		     	 <input id="filterId" name="filterId" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wFilterPage.filterId}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">滤芯名称:</label>
		     	 <input id="filterName" name="filterName" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wFilterPage.filterName}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">滤芯型号:</label>
		     	 <input id="filterModel" name="filterModel" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wFilterPage.filterModel}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">生产日期:</label>
					  <input id="filterTime" name="filterTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"
									ignore="checked"
		      						  value='<fmt:formatDate value='${wFilterPage.filterTime}' type="date" pattern="yyyy-MM-dd"/>'/>   
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">导入时间:</label>
					  <input id="filterImporttime" name="filterImporttime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"
									ignore="checked"
		      						  value='<fmt:formatDate value='${wFilterPage.filterImporttime}' type="date" pattern="yyyy-MM-dd"/>'/>   
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">防伪码:</label>
		     	 <input id="filterCode" name="filterCode" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wFilterPage.filterCode}'/>
		      <span class="Validform_checktip"></span>
		    </div>
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">安装时水量:</label> -->
<!-- 		     	 <input id="filterInstalledwater" name="filterInstalledwater" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="ignore" -->
<%-- 		     	   value='${wFilterPage.filterInstalledwater}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">滤芯总水量:</label> -->
<!-- 		     	 <input id="filterTotalwater" name="filterTotalwater" type="text" style="width: 150px" class="inputxt"  -->
<!-- 									ignore="ignore" -->
<%-- 		     	   value='${wFilterPage.filterTotalwater}'/> --%>
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wfilter/wFilter.js"></script>		
