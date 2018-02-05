<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>验真</title>
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
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wFilterController.do?saveTheTrue" >
		<table style="width:500px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								防伪码:
							</label>
						</td>
						<td class="value">
							<input id="filterCode" name="filterCode" type="text" style="width: 150px" class="inputxt" 
					     	  value="" datatype="*" ignore="checked"/>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
			</table>
<!-- 			<div style="position:absolute;bottom:5px;right:10px;width:100px;"> -->
<!-- 				<div style="margin:3px auto;display:inline-block;"><button type="submit" class="subBtnmy" style="width:72px;font-size:14px;padding:5px;">提交</button></div> -->
<!-- 			</div> -->
		</t:formvalid>
 </body>
