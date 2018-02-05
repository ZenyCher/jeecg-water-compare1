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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="wMallIntroduceController.do?doAdd" callback="jeecgFormFileCallBack@Override">
			<input id="id" name="id" type="hidden" value="${wMallIntroducePage.id }">
			<input id="createName" name="createName" type="hidden" value="${wMallIntroducePage.createName }">
			<input id="createBy" name="createBy" type="hidden" value="${wMallIntroducePage.createBy }">
			<input id="createDate" name="createDate" type="hidden" value="${wMallIntroducePage.createDate }">
			<input id="updateName" name="updateName" type="hidden" value="${wMallIntroducePage.updateName }">
			<input id="updateBy" name="updateBy" type="hidden" value="${wMallIntroducePage.updateBy }">
			<input id="updateDate" name="updateDate" type="hidden" value="${wMallIntroducePage.updateDate }">
			<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wMallIntroducePage.sysOrgCode }">
			<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wMallIntroducePage.sysCompanyCode }">
			<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wMallIntroducePage.bpmStatus }">
			<input id="mallId" name="mallId" type="hidden" value="${wMallIntroducePage.mallId }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">产品标题:</label>
		     	 <input id="title" name="title" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品介绍:</label>
				 <textarea id="introduce" style="width:600px;" class="inputxt" rows="6" name="introduce" 
				ignore="ignore"
				 ></textarea>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">押金:</label>
		     	 <input id="deposit" name="deposit" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">颜色:</label>
		     	 <input id="colour" name="colour" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">品牌:</label>
		     	 <input id="brand" name="brand" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">型号:</label>
		     	 <input id="model" name="model" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">安装方式:</label>
		     	 <input id="mode" name="mode" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">过滤原理:</label>
		     	 <input id="principle" name="principle" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">额定净水量:</label>
		     	 <input id="netWater" name="netWater" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品尺寸:</label>
		     	 <input id="size" name="size" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">产品净重:</label>
		     	 <input id="netWeight" name="netWeight" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">净流水量:</label>
		     	 <input id="water" name="water" type="text" style="width: 150px" class="inputxt" 
									ignore="ignore"
									 />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">商品描述:</label>
				 <textarea id="commodityDescribe" style="width:600px;" class="inputxt" rows="6" name="commodityDescribe" 
				ignore="ignore"
				 ></textarea>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">详情图片:</label>
					<table></table>
					<div class="form jeecgDetail"> 
						<script type="text/javascript">
							var serverMsg="";
							$(function(){
								$('#detailsPicture').uploadify({
									buttonText:'添加文件',
									auto:false,
									progressData:'speed',
									multi:true,
									height:25,
									overrideEvents:['onDialogClose'],
									fileTypeDesc:'文件格式:',
									queueID:'filediv_file',
									fileSizeLimit:'15MB',
									swf:'plug-in/uploadify/uploadify.swf',	
									uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
									onUploadStart : function(file) { 
										var cgFormId=$("input[name='id']").val();
										$('#detailsPicture').uploadify("settings", "formData", {
											'cgFormId':cgFormId,
											'cgFormName':'w_mall_introduce',
											'cgFormField':'DETAILS_PICTURE'
										});
									} ,
									onQueueComplete : function(queueData) {
										 var win = frameElement.api.opener;
										 win.reloadTable();
										 win.tip(serverMsg);
										 frameElement.api.close();
									},
									onUploadSuccess : function(file, data, response) {
										var d=$.parseJSON(data);
										if(d.success){
											var win = frameElement.api.opener;
											serverMsg = d.msg;
										}
									},
									onFallback: function() {
					                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
					                },
					                onSelectError: function(file, errorCode, errorMsg) {
					                    switch (errorCode) {
					                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
					                        break;
					                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
					                        break;
					                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
					                        break;
					                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
					                        break;
					                    }
					                },
					                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
								});
							});
						</script>
						<span id="file_uploadspan"><input type="file" name="detailsPicture" id="detailsPicture" /></span> 
					</div> 
					<div class="form" id="filediv_file"></div>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wmallIntroduce/wMallIntroduce.js"></script>	
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
  	