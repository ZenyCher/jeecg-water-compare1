<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>礼品管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
	<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wGiftController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${wGiftPage.id }">
					<input id="createName" name="createName" type="hidden" value="${wGiftPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${wGiftPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${wGiftPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${wGiftPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${wGiftPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${wGiftPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wGiftPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wGiftPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wGiftPage.bpmStatus }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="giftName" name="giftName" type="text" style="width: 150px" class="inputxt"  datatype="*" 
						     	 ignore="checked" 
						     	 value='${wGiftPage.giftName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">礼品名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品描述:
							</label>
						</td>
						<td class="value">
									<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
									<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
							    	<textarea name="giftDescribe" id="giftDescribe" style="width: 650px;height:300px">${wGiftPage.giftDescribe }</textarea>
								    <script type="text/javascript">
								        var editor = UE.getEditor('giftDescribe');
								    </script>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">礼品描述</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品兑换积分:
							</label>
						</td>
						<td class="value">
						     	 <input id="giftChange" name="giftChange" type="text" style="width: 150px" class="inputxt"  datatype="*" 
						     	 ignore="checked" 
						     	 value='${wGiftPage.giftChange}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">礼品兑换积分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品总数量:
							</label>
						</td>
						<td class="value">
						     	 <input id="giftSum" name="giftSum" type="text" style="width: 150px" class="inputxt"  datatype="*" 
						     	 ignore="checked" 
						     	 value='${wGiftPage.giftSum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">礼品总数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品剩余数量:
							</label>
						</td>
						<td class="value">
						     	 <input id="giftSurplus" name="giftSurplus" type="text" style="width: 150px" class="inputxt"  datatype="*" 
						     	 ignore="checked" 
						     	 value='${wGiftPage.giftSurplus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">礼品剩余数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品图片:
							</label>
						</td>
						<td class="value">
							<table id="fileTable"></table>
							<table></table>
							<t:webUploader auto="true" name="giftImage" fileNumLimit="3" type="image" pathValues="${wGiftPage.giftImage }"></t:webUploader>
								<span class="Validform_checktip Validform_right" style="display: none;">图片已上传</span>
							</td>
							<label class="Validform_label" style="display: none;">礼品图片</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品是否可兑换:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="giftYesonno" type="list"
										typeGroupCode="giftYesNo" defaultVal="${wGiftPage.giftYesonno}" hasLabel="false"  title="礼品是否可兑换"  datatype="*" 
										></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">礼品是否可兑换</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								礼品是否上下架:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="giftType" type="list"
										typeGroupCode="giftType" defaultVal="${wGiftPage.giftType}" hasLabel="false"  title="礼品是否上下架"  datatype="*" 
										></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">礼品是否上下架</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/jeecg/wgift/wgift.js"></script>		
	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
		  		var table = $("#fileTable");
		  		var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "wGiftController.do?getFiles&id=" +  cgFormId,
		  		   success: function(data){
		  			 var arrayFileObj = jQuery.parseJSON(data).obj;
		  			 
		  			$.each(arrayFileObj,function(n,file){
		  				var tr = $("<tr style=\"height:34px;\"></tr>");
		  				var td_title = $("<td>" + file.title + "</td>")
		  		  		var td_download = $("<td><a href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		var td_del = $("<td><a href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
		  		  		
		  		  		tr.appendTo(table);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		td_del.appendTo(tr);
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
				$('#giftImage').uploadify('upload', '*');		
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
				$('#giftImage').uploadify('cancel', '*');
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
