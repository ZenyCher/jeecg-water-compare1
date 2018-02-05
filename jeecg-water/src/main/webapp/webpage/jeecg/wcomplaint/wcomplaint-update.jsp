<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>投诉与建议</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wComplaintController.do?doUpdate" >
			<input id="id" name="id" type="hidden" value="${wComplaintPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wComplaintPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wComplaintPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wComplaintPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wComplaintPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wComplaintPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wComplaintPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wComplaintPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wComplaintPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wComplaintPage.bpmStatus }"/>
			<input id="complaintImage" name="complaintImage" type="hidden" value="${wComplaintPage.complaintImage }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
		     	 <input id="complaintMembername" name="complaintMembername" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wComplaintPage.complaintMembername}' disabled="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		     	 <input id="complaintPhone" name="complaintPhone" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wComplaintPage.complaintPhone}' disabled="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">反馈内容:</label>
		     	 <input id="complaintContent" name="complaintContent" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wComplaintPage.complaintContent}' disabled="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">问题类型:</label>
		     	 <input id="complaintType" name="complaintType" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	  datatype="*"  value='${wComplaintPage.complaintType}' disabled="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">处理状态:</label>
<%-- 					<t:dictSelect field="complaintState" type="list"  --%>
<%-- 						typeGroupCode="c_state" defaultVal="${wComplaintPage.complaintState}" hasLabel="false"  title="处理状态" ></t:dictSelect>      --%>
						<input id="complaintState" name="complaintState" type="text" style="width: 150px" class="inputxt" 
							value='${wComplaintPage.complaintState}' disabled="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">提交时间:</label>
					  <input id="complaintTime" name="complaintTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*"
									ignore="ignore" disabled="true"
		      						  value='<fmt:formatDate value='${wComplaintPage.complaintTime}' type="date" pattern="yyyy-MM-dd"/>'/>   
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">处理完成时间:</label>
		     	 <input id="complaintEndtime" name="complaintEndtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" datatype="*"
									ignore="ignore"
		     	   value='<fmt:formatDate value='${wComplaintPage.complaintEndtime}' type="date" pattern="yyyy-MM-dd"/>'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">投诉与建议回复:</label>
			    <textarea id="complaintMsg" style="width:600px;height:100px;" class="inputxt" rows="6" 
				ignore="ignore"
			    name="complaintMsg">${wComplaintPage.complaintMsg}</textarea>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wcomplaint/wcomplaint.js"></script>		
