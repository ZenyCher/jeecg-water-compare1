<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>商城产品介绍</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
		<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
		<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wMallIntroduceController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
			<input id="createName" name="createName" type="hidden" value="${wMallIntroducePage.createName }"/>
			<input id="createBy" name="createBy" type="hidden" value="${wMallIntroducePage.createBy }"/>
			<input id="createDate" name="createDate" type="hidden" value="${wMallIntroducePage.createDate }"/>
			<input id="updateName" name="updateName" type="hidden" value="${wMallIntroducePage.updateName }"/>
			<input id="updateBy" name="updateBy" type="hidden" value="${wMallIntroducePage.updateBy }"/>
			<input id="updateDate" name="updateDate" type="hidden" value="${wMallIntroducePage.updateDate }"/>
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wMallIntroducePage.sysOrgCode }"/>
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wMallIntroducePage.sysCompanyCode }"/>
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wMallIntroducePage.bpmStatus }"/>
			<input id="mallId" name="mallId" type="hidden" value="${wMallIntroducePage.mallId }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">产品编号:</label>
		     	 <input id="id" name="id" type="text" style="width: 300px" class="inputxt" value="${wMallIntroducePage.id }"
									ignore="ignore" readOnly="true"/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品标题:</label>
		     	 <input id="title" name="title" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore" readOnly="true"
		     	   value='${wMallIntroducePage.title}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品介绍:</label>
			    <textarea id="introduce" style="width:600px;" class="inputxt" rows="6" 
				ignore="ignore" readOnly="true"
			    name="introduce">${wMallIntroducePage.introduce}</textarea>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">押金:</label>
		     	 <input id="deposit" name="deposit" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore" readOnly="true"
		     	   value='${wMallIntroducePage.deposit}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">颜色:</label>
		     	 <input id="colour" name="colour" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.colour}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">品牌:</label>
		     	 <input id="brand" name="brand" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.brand}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<%-- <div class="form">
		      <label class="Validform_label">型号:</label>
		     	 <input id="model" name="model" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.model}'/>
		      <span class="Validform_checktip"></span>
		    </div> --%>
			<div class="form">
		      <label class="Validform_label">安装方式:</label>
		     	 <input id="mode" name="mode" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.mode}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">过滤原理:</label>
		     	 <input id="principle" name="principle" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.principle}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">额定净水量:</label>
		     	 <input id="netWater" name="netWater" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.netWater}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品尺寸:</label>
		     	 <input id="size" name="size" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.size}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品净重:</label>
		     	 <input id="netWeight" name="netWeight" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.netWeight}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">净流水量:</label>
		     	 <input id="water" name="water" type="text" style="width: 300px" class="inputxt" 
									ignore="ignore"
		     	   value='${wMallIntroducePage.water}'/>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">商品描述:</label>
			    <textarea id="commodityDescribe" style="width:600px;" class="inputxt" rows="6" 
				ignore="ignore"
			    name="commodityDescribe">${wMallIntroducePage.commodityDescribe}</textarea>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">详情图片:</label>
					<table id="fileTable"></table>
						<table></table>
					<t:webUploader auto="true" name="detailsPicture" fileNumLimit="5" type="image" pathValues="${wMallIntroducePage.detailsPicture }"></t:webUploader>
						<span class="Validform_checktip Validform_right" style="display: none;">图片已上传</span>
					</td>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/jeecg/wmallintroduce/wMallIntroduce.js"></script>		
  	<script type="text/javascript">
	  	//加载 已存在的 文件
	  	$(function(){
	  		var table = $("#fileTable");
	  		var cgFormId=$("input[name='id']").val();
	  		$.ajax({
	  		   type: "post",
	  		   url: "wMallIntroduceController.do?getFiles&id=" +  cgFormId,
	  		   success: function(data){
	  			 var arrayFileObj = jQuery.parseJSON(data).obj;
	  			 
	  			$.each(arrayFileObj,function(n,file){
	  				console.log(file);
	  				var tr = $("<tr style=\"height:34px;\"></tr>");
	  				var td_title = $("<td>" + file.title + "</td>")
	  		  		var td_download = $("<td><a href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
	  		  		var td_view = $("<td><a href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
// 	  		  		var td_del = $("<td><a href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"confuploadify('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
	  		  		var td_del = $("<td><a href=\"cgUploadController.do?delFile&id=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"删除\">删除</a></td>");
	  		  		
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
			$('#detailsPicture').uploadify('upload', '*');		
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
			$('#detailsPicture').uploadify('cancel', '*');
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
