<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>净水器商城</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
		<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
		<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wmallController.do?doAdd" callback="jeecgFormFileCallBack@Override">
			<input id="id" name="id" type="hidden" value="${wmallPage.id }">
			<input id="createName" name="createName" type="hidden" value="${wmallPage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wmallPage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wmallPage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wmallPage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wmallPage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wmallPage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wmallPage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wmallPage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wmallPage.bpmStatus }">
			<input id="mallDeviceTypeId" name="mallDeviceTypeId" type="hidden" value="${wmallPage.mallDeviceTypeId }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">产品标题:</label>
		     	 <input id="mallName" name="mallName" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									  datatype="*"/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">净水器类型:</label>
		     	 <input id="mallDeviceType" name="mallDeviceType" type="text" style="width: 150px" class="inputxt" 
					ignore="checked" datatype="*" 
					onclick="popupClick(this,'device_type,device_name,device_filter_num','mallDeviceType,mallDeviceName,mallFilterNum','device_type');"
					/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">净水器名称:</label>
		     	 <input id="mallDeviceName" name="mallDeviceName" type="text" style="width: 150px" class="inputxt" 
					readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">滤芯数量:</label>
		     	 <input id="mallFilterNum" name="mallFilterNum" type="text" style="width: 150px" class="inputxt" 
					readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">所需押金元:</label>
		     	 <input id="mallDeposit" name="mallDeposit" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									  datatype="*"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品图片:</label>
					<table></table>
					<t:webUploader auto="true" name="mallImage" fileNumLimit="1" type="image"></t:webUploader>
						<span class="Validform_checktip Validform_right" style="display: none;">图片已上传</span>
					</td>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品说明:</label>
		     	 <input id="mallExplain" name="mallExplain" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
									  datatype="*"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">操作手册:</label>
					<table></table>
					<t:webUploader auto="true" name="mallOperation" fileNumLimit="1"></t:webUploader>
						<span class="Validform_checktip Validform_right" style="display: none;">文件已上传</span>
					</td>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wmall/wmall.js"></script>	
  	<script type="text/javascript">
  		function jeecgFormFileCallBack(data){
  			if (data.success == true) {
				uploadFile(data);
			} else {
				if (data.responseText == '' || data.responseText == undefined) {
					$.messager.alert('错误', data.msg);
					$.Hidemsg();
				} else {
					try {
						var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
						$.messager.alert('错误', emsg);
						$.Hidemsg();
					} catch(ex) {
						$.messager.alert('错误', data.responseText + '');
					}
				}
				return false;
			}
			if (!neibuClickFlag) {
				var win = frameElement.api.opener;
				win.reloadTable();
			}
  		}
  		function upload() {
  			$('#mallImage').uploadify('upload', '*');	
			$('#mallOperation').uploadify('upload', '*');	
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
			$('#mallImage').uploadify('cancel', '*');
			$('#mallOperation').uploadify('cancel', '*');
		}
		function uploadFile(data){
			if(!$("input[name='id']").val()){
				if(data.obj!=null && data.obj!='undefined'){
					$("input[name='id']").val(data.obj.id);
				}
			}
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				if (neibuClickFlag){
					alert(data.msg);
					neibuClickFlag = false;
				}else {
					var win = frameElement.api.opener;
					win.reloadTable();
					win.tip(data.msg);
					frameElement.api.close();
				}
			}
		}
  	</script>
  	