<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>指派安装公司</title>
  <t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
    <style type="text/css">
.subBtnmy{border:none;
	outline:none;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    color: #ffffff;
    display: block;
    cursor:pointer;
    margin: 0px auto;
    clear:both;
    padding: 5px 40px;
    text-shadow: 0 1px 1px #777;
    font-weight:bold;
    font-family:"Century Gothic", Helvetica, sans-serif;
    font-size:22px;
    -moz-box-shadow:0px 0px 3px #aaa;
    -webkit-box-shadow:0px 0px 3px #aaa;
    box-shadow:0px 0px 3px #aaa;
    background:#18a689;
}
.subBtnmy:hover {
    background:#d8d8d8;
    color:#666;
    text-shadow:1px 1px 1px #fff;
}
  </style>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuserMemberController.do?assign" >
		<input id="memberId" name="memberId" type="hidden" value="${wuserMemberPage.id }"/>
		<input id="ids" name="ids" type="hidden" value="${wuserMemberPage.memberPhone }"/>
		<table style="width:700px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								安装公司:
							</label>
						</td>
						<td class="value">
							<input id="erectorCompany" name="erectorCompany" type="text" style="width: 150px" class="inputxt" ignore="ignore" datatype="*" value="${wMaintainPage.registerName }"/>
					     	<input id="registerId" name="registerId" type="hidden" value="${wMaintainPage.registerId }"/>
					     	<t:choose hiddenName="registerId" hiddenid="id" url="wmaintainController.do?assign" name="erectirList" icon="icon-search" title="选择安装公司" textname="erectorCompany" isclear="true" isInit="true"></t:choose>
					      	<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								预约安装时间:
							</label>
						</td>
						<td class="value">
						  <input id="installTime" name="installTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
								ignore="checked"/>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								安装地址:
							</label>
						</td>
						<td class="value">
							<input id="installAddress" name="installAddress" type="text" style="width: 150px" class="inputxt" 
					     	  value="${wuserMemberPage.memberAddress }" datatype="*" ignore="checked"/>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								联系方式:
							</label>
						</td>
						<td class="value">
							<input id="memberType" name="memberType" type="text" style="width: 150px" class="inputxt" 
					     	  value="${wuserMemberPage.memberType }" datatype="*" ignore="checked"/>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员姓名:
							</label>
						</td>
						<td class="value">
							<input id="memberName" name="memberName" type="text" style="width: 150px" class="inputxt" 
					     	  value="${wuserMemberPage.memberName }" datatype="*" ignore="checked"/>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								证件:
							</label>
						</td>
						<td class="value">
							<t:webUploader auto="true" name="installCertificates" fileNumLimit="1" pathValues="${wInstallPage.installCertificates }"></t:webUploader>
								<span class="Validform_checktip Validform_right" style="display: none;">证件已上传</span>
							</td>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								合同:
							</label>
						</td>
						<td class="value">
							<t:webUploader auto="true" name="installContract" fileNumLimit="1" pathValues="${wInstallPage.installContract }"></t:webUploader>
								<span class="Validform_checktip Validform_right" style="display: none;">合同已上传</span>
							</td>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script type="text/javascript">
  //编写自定义JS代码
  $(function(){
  });
  </script>
