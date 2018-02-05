<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>会员表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
		<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
		<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wuserMemberController.do?doAdd" callback="jeecgFormFileCallBack@Override">
			<input id="id" name="id" type="hidden" value="${wUserMemberPage.id }"/>
			<input id="createName" name="createName" type="hidden" value="${wUserMemberPage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wUserMemberPage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wUserMemberPage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wUserMemberPage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wUserMemberPage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wUserMemberPage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wUserMemberPage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wUserMemberPage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wUserMemberPage.bpmStatus }"/>
			<input id="memberId" name="memberId" type="hidden" value="${wUserMemberPage.memberId }"/>
			<input id="waterSurplus" name="waterSurplus" type="hidden" value="${wUserMemberPage.waterSurplus }"/>
			<input id="memberUser" name="memberUser" type="hidden" value="${wUserMemberPage.memberUser }"/>
			<input id="memberState" name="memberState" type="hidden" value="${wUserMemberPage.memberState }"/>
			<input id="memberPackageType" name="memberPackageType" type="hidden" value="${wUserMemberPage.memberPackageType }"/>
			<input id="memberPhone" name="memberPhone" type="hidden" value="${wUserMemberPage.memberPhone }"/>
			<input id="memberAssignInstall" name="memberAssignInstall" type="hidden" value="${wUserMemberPage.memberAssignInstall }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">会员姓名:</label>
		     	 <input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wUserMemberPage.memberName}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系方式:</label>
		     	 <input id="memberType" name="memberType" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="m"  value='${wUserMemberPage.memberType}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">居住地址:</label>
		     	 <input id="memberAddress" name="memberAddress" type="text" style="width: 150px" class="inputxt" 
									ignore="checked"
		     	  datatype="*"  value='${wUserMemberPage.memberAddress}'/>
		      <span class="Validform_checktip"></span>
		    </div>
<!-- 			<div class="form"> -->
<!-- 		      <label class="Validform_label">会员联系方式:</label> -->
<!-- 				<select id="memberType" name="memberType"> -->
<!-- 				 	<option value="0">线下签约</option> -->
<!-- 					<option value="1">商城下单</option> -->
<!-- 				</select>      -->
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
		    <div class="form">
		      <label class="Validform_label">初始水量L:</label>
		     	 <input id="memberInitialWater" name="memberInitialWater" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore" datatype="n"  value='${wUserMemberPage.memberInitialWater}'/>
		      <span class="Validform_checktip"></span>
		    </div>    
		    <div class="form">
		      <label class="Validform_label">附件合同:</label>
					<table></table>
					<t:webUploader auto="true" name="menberContract" fileNumLimit="1"></t:webUploader>
						<span class="Validform_checktip Validform_right" style="display: none;">合同已上传</span>
					</td>
		      <span class="Validform_checktip"></span>
		    </div>	     
			<div class="form">
		      <label class="Validform_label">附件证件:</label>
					<table></table>
					<t:webUploader auto="true" name="menberCertificates" fileNumLimit="1"></t:webUploader>
					<span class="Validform_checktip Validform_right" style="display: none;">证件已上传</span>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">净水器型号:</label>
		     	<input id="memberDeviceType" name="memberDeviceType" type="text" style="width: 150px" class="inputxt"  datatype="*" ignore="checked" 
		     	value='${wUserMemberPage.memberDeviceType}' onclick="popupClick(this,'id,device_type','memberDeviceId,memberDeviceType','device_type');"/>
				<input id="memberDeviceId" name="memberDeviceId" type="hidden"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">押金:</label>
		     	 <input id="memberDeposit" name="memberDeposit" type="text" style="width: 150px" class="inputxt" 
									ignore="checked" datatype="*"
		     	   value='${wUserMemberPage.memberDeposit}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">备注:</label>
		     	 <input id="memberRemarks" name="memberRemarks" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
		     	   value='${wUserMemberPage.memberRemarks}'/>
		      <span class="Validform_checktip"></span>
		    </div>
<!-- 		    <div class="form"> -->
<!-- 		      <label class="Validform_label">套餐类型:</label> -->
<!-- 		      <select id="memberPackageType" name="memberPackageType" onchange="selectType();"> -->
<!-- 		      	<option value="0">首冲套餐</option> -->
<!-- 		      	<option value="1">正常套餐</option> -->
<!-- 		      </select> -->
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
<!-- 		    <div class="form" id="packageType0"> -->
<!-- 		      <label class="Validform_label">套餐描述:</label> -->
<!-- 				<select id="memberPackageId" name="memberPackageId"></select> -->
<!-- 		      <span class="Validform_checktip"></span> -->
<!-- 		    </div> -->
			    <div class="form">
			    	<label class="Validform_label">初装套餐:</label>
				    	<input id="pakcageName" name="pakcageName" type="text" style="width: 150px" class="inputxt" ignore="checked" datatype="*"/>
						<input id="memberPackageId" name="memberPackageId" type="hidden"/>
						<t:choose hiddenName="memberPackageId" hiddenid="id" url="wuserMemberController.do?packageAssign" name="packageList" icon="icon-search" title="选择初装套餐" textname="pakcageName" isclear="true" isInit="true"></t:choose>
						<span class="Validform_checktip"></span>
			    </div>
				<div class="form">
					<label class="Validform_label">平常套餐:</label>
						<input id="packageMode" name="packageMode" type="text" style="width: 150px" class="inputxt" ignore="checked" datatype="*"/>
						<input id="memberNormalPackageId" name="memberNormalPackageId" type="hidden"/>
						<t:choose hiddenName="memberNormalPackageId" hiddenid="id" url="wuserMemberController.do?normalAssign" name="packageList" icon="icon-search" title="选择正常套餐" textname="packageMode" isclear="true" isInit="true"></t:choose>
						<span class="Validform_checktip"></span>
			    </div>
			   <div class="form">
					<label class="Validform_label">来源:</label>
					<select id="memberSource" name="memberSource">
						<option value="0">线下签约</option>
						<option value="1">商城下单</option>
					</select>
					<span class="Validform_checktip"></span>
			    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wusermember/wuserMember.js"></script>		
  	<script type="text/javascript">
	  	//加载 已存在的 文件
	  	$(function(){
	  		selectType();
	  		var table = $("#fileTable");
	  		var table1 = $("#fileTable1");
	  		var cgFormId=$("input[name='id']").val();
	  		$.ajax({
	  		   type: "post",
	  		   url: "wuserMemberController.do?getFiles&id=" +  cgFormId,
	  		   success: function(data){
	  			 var arrayFileObj = jQuery.parseJSON(data).obj;
	  			 
	  			$.each(arrayFileObj,function(n,file){
	  				if(file.title == "合同"){
		  				var tr = $("<tr style=\"height:34px;\"></tr>");
		  				var td_title = $("<td>" + file.title + "</td>")
		  		  		var td_download = $("<td><a href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		var td_del = $("<td><a href=\"javascript:void(0)\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
		  		  		tr.appendTo(table);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		td_del.appendTo(tr);
	  				}
	  				if(file.title == "证件"){
		  				var tr = $("<tr style=\"height:34px;\"></tr>");
		  				var td_title = $("<td>" + file.title + "</td>")
		  		  		var td_download = $("<td><a href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		var td_del = $("<td><a href=\"javascript:void(0)\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
		  		  		tr.appendTo(table1);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		td_del.appendTo(tr);
	  				}
	  			 });
	  		   }
	  		});
	  	})
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
			$('#menberCertificates').uploadify('upload', '*');
			$('#menberContract').uploadify('upload', '*');
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
			$('#menberCertificates').uploadify('cancel', '*');
			$('#menberContract').uploadify('cancel', '*');
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
