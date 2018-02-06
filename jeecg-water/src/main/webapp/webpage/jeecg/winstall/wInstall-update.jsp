<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安装管理表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wInstallController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wInstallPage.id }">
					<input id="createName" name="createName" type="hidden" value="${wInstallPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${wInstallPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${wInstallPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${wInstallPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${wInstallPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${wInstallPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${wInstallPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${wInstallPage.sysCompanyCode }">
					<input id="bpmStatus" name="bpmStatus" type="hidden" value="${wInstallPage.bpmStatus }">
					<input id="deviceFilterNum" name="deviceFilterNum" type="hidden" value="${wDeviceTypePage.deviceFilterNum }">
					<input id="memberId" name="memberId" type="hidden" value="${wInstallPage.memberId }">
					<input id="filterNumOne" name="filterNumOne" type="hidden" value="${wDeviceTypePage.filterNumOne }">
					<input id="filterNumTwo" name="filterNumTwo" type="hidden" value="${wDeviceTypePage.filterNumTwo }">
					<input id="filterNumThree" name="filterNumThree" type="hidden" value="${wDeviceTypePage.filterNumThree }">
					<input id="filterNumFour" name="filterNumFour" type="hidden" value="${wDeviceTypePage.filterNumFour }">
					<input id="filterNumFive" name="filterNumFive" type="hidden" value="${wDeviceTypePage.filterNumFive }">
					<input id="filterNumSix" name="filterNumSix" type="hidden" value="${wDeviceTypePage.filterNumSix }">
					<input id="installMessage" name="installMessage" type="hidden" value="${wInstallPage.installMessage }">
					
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
<!-- 					<tr> -->
<!-- 						<td align="right"> -->
<!-- 							<label class="Validform_label"> -->
<!-- 								设备id: -->
<!-- 							</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<!-- 						<input id="deviceId" name="deviceId" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*"  -->
<!-- 						ignore="checked" -->
<%-- 						 onclick="inputClick(this,'device_id','usm_device')" value='${wInstallPage.deviceId}'> --%>
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">设备id</label> -->
<!-- 						</td> -->
<!-- 					</tr> -->
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								设备id:
							</label>
						</td>
						<td class="value">
								<input id="deviceId" name="deviceId" class="inputxt" value='${wInstallPage.deviceId}'/>
								<input name="deviceName" id="deviceName" type="hidden" value="" readonly="readonly" />
								<t:choose hiddenName="deviceId" hiddenid="deviceId" url="wInstallController.do?assignDevice" name="deviceList" icon="icon-search" title="选择设备" textname="deviceName" isclear="true" isInit="true"></t:choose>
							</select>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								安装进度:
							</label>
						</td>
						<td class="value">
<!-- 						     	 <input id="installProgress" name="installProgress" type="text" style="width: 150px" class="inputxt"  datatype="*"  -->
<%-- 						     	 ignore="checked" value='${wInstallPage.installProgress}'> --%>
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">安装进度</label> -->
				<select id="installProgress" name="installProgress">
				 	<option value="0" <c:if test="${wInstallPage.installProgress eq 0 }">selected</c:if>  value="0">待安装</option>
				 	<option value="1" <c:if test="${wInstallPage.installProgress eq 1 }">selected</c:if>  value="1">已安装</option>
				 </select>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="installMembername" name="installMembername" type="text" style="width: 150px" class="inputxt" readOnly="true"
						     	 value='${wInstallPage.installMembername}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员姓名</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员联系方式:
							</label>
						</td>
						<td class="value">
						     	 <input id="instalPhont" name="instalPhont" type="text" style="width: 150px" class="inputxt" readOnly="true"
						     	 value='${wInstallPage.instalPhont}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">会员联系方式</label>
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
						     	 ignore="checked" readOnly="true"
						     	 value='${wInstallPage.installAddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装地址</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">净水器型号:</label>
						</td>
						<td class="value">
						     	 <input id="device_type" name="device_type" type="text" style="width: 150px" class="inputxt"
						     	 ignore="checked" readOnly="true" value='${wDeviceTypePage.deviceType}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">净水器型号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">押金:</label>
						</td>
						<td class="value">
						     	 <input id="mallDeposit" name="mallDeposit" type="text" style="width: 150px" class="inputxt"
						     	 ignore="checked" readOnly="true" value='${wUserMemberPage.memberDeposit}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">押金</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">初装套餐:</label>
						</td>
						<td class="value">
						     	 <input id="packageDescribe" name="packageDescribe" type="text" style="width: 150px" class="inputxt"
						     	 ignore="checked" readOnly="true" value='${wUserMemberPage.memberPackageMsg}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初装套餐</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">平常套餐:</label>
						</td>
						<td class="value">
						     	 <input id="packageDescribe" name="packageDescribe" type="text" style="width: 150px" class="inputxt"
						     	 ignore="checked" readOnly="true" value='${wUserMemberPage.memberNormalPackageMsg}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">平常套餐</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">安装公司:</label>
						</td>
						<td class="value">
						     	 <input id="installWorker" name="installWorker" type="text" style="width: 150px" class="inputxt"
						     	 ignore="checked" readOnly="true" value='${wInstallPage.installWorker}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装公司</label>
						</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td align="right"> -->
<!-- 							<label class="Validform_label"> -->
<!-- 								水表ID: -->
<!-- 							</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<!-- 						     	 <input id="installNumber" name="installNumber" type="text" style="width: 150px" class="inputxt" -->
<%-- 						     	 value='${wInstallPage.installNumber}'> --%>
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">水表编号</label> -->
<!-- 						</td> -->
<!-- 					</tr> -->
					<tr>
						<td align="right">
							<label class="Validform_label">
								当前水量:
							</label>
						</td>
						<td class="value">
						     	 <input id="installWater" name="installWater" type="text" style="width: 150px" class="inputxt"  value='${wInstallPage.installWater}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当前水量</label>
						</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td align="right"> -->
<!-- 							<label class="Validform_label"> -->
<!-- 								滤芯: -->
<!-- 							</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<%-- 						     	 <input id="installFilterId" name="installFilterId" type="text" style="width: 150px" class="inputxt"  value='${wInstallPage.installFilterId}'> --%>
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">滤芯</label> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td align="right"> -->
<!-- 							<label class="Validform_label"> -->
<!-- 								更换滤芯前水量: -->
<!-- 							</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<%-- 						     	 <input id="installFilterWater" name="installFilterWater" type="text" style="width: 150px" class="inputxt" value='${wInstallPage.installFilterWater}'> --%>
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">更换滤芯前水量</label> -->
<!-- 						</td> -->
<!-- 					</tr> -->
					<tr>
						<td align="right">
							<label class="Validform_label">
								会员类型:
							</label>
						</td>
						<td class="value">
<%-- 						     	 <input id="installSource" name="installSource" type="text" style="width: 150px" class="inputxt" value='${wInstallPage.installSource}'> --%>
<!-- 							<span class="Validform_checktip"></span> -->
							<select id="installSource" name="installSource">
							 	<option <c:if test="${wUserMemberPage.memberSource eq '0'}">selected</c:if> value="0">线下签约</option>
								<option <c:if test="${wUserMemberPage.memberSource eq '1'}">selected</c:if> value="1">商城下单</option>
<%-- 								<option <c:if test="${wGiftExchangePage.giftexchangeState eq '2'}">selected</c:if> value="2">申报</option> --%>
<%-- 								<option <c:if test="${wGiftExchangePage.giftexchangeState eq '3'}">selected</c:if> value="3">已撤</option> --%>
							</select> 
							<label class="Validform_label" style="display: none;">会员类型</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								安装工:
							</label>
						</td>
						<td class="value">
<!-- 						     	 <input id="installWorker" name="installWorker" type="text" style="width: 150px" class="inputxt"  datatype="*" ignore="checked"  -->
<%-- 						     	 value='${wInstallPage.installWorker}'> --%>
						    <input id="registerName" name="registerName" type="text" style="width: 150px" class="inputxt" ignore="ignore" datatype="*" value=""/>
					     	<input id="registerId" name="registerId" type="hidden" value="${wMaintainPage.registerId }"/>
					     	<t:choose hiddenName="registerId" hiddenid="id" url="wInstallController.do?assign" name="erectirList" icon="icon-search" title="选择安装工人" textname="registerName" isclear="true" isInit="true"></t:choose>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装工</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								计划安装时间:
							</label>
						</td>
						<td class="value">
									  <input id="installTime" name="installTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"
									    value='<fmt:formatDate value='${wInstallPage.installTime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								安装完成时间:
							</label>
						</td>
						<td class="value">
									  <input id="installEndtime" name="installEndtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*" 
									  ignore="checked"
									    value='<fmt:formatDate value='${wInstallPage.installEndtime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">安装完成时间</label>
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
					<tr>
						<table id="maintainType_id">
				    		<tr style="text-align:center;" style="display:none">
				    			<th>更换否</th>
				    			<th>第几道滤芯</th>
				    			<th>滤芯ID</th>
				    			<th>滤芯更换读数</th>
				    		</tr>
				    		<tr class="filter_check" style="display:none">
				    			<td><input type="checkbox" onchange=""/></td>
				    			<td><font size="5">第一道滤芯</font></td>
				    			<td><input id="oneFilterId" name="oneFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value=''/></td>
				    			<td><input id="oneFilterName" name="oneFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wDeviceTypePage.filterNumOne}'></td>
				    		</tr>
				    		<tr class="filter_check" style="display:none">
				    			<td><input type="checkbox"/></td>
				    			<td><font size="5">第二道滤芯</font></td>
				    			<td><input id="twoFilterId" name="twoFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value=''/></td>
				    			<td><input id="twoFilterName" name="twoFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wDeviceTypePage.filterNumTwo}' /></td>
				    		</tr>
				    		<tr class="filter_check" style="display:none">
				    			<td><input type="checkbox"/></td>
				    			<td><font size="5">第三道滤芯</font></td>
				    			<td><input id="threeFilterId" name="threeFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value=''/></td>
				    			<td><input id="threeFilterName" name="threeFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wDeviceTypePage.filterNumThree}' /></td>
				    		</tr>
				    		<tr class="filter_check" style="display:none">
				    			<td><input type="checkbox"/></td>
				    			<td><font size="5">第四道滤芯</font></td>
				    			<td><input id="fourFilterId" name="fourFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value=''/></td>
				    			<td><input id="fourFilterName" name="fourFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wDeviceTypePage.filterNumFour}' /></td>
				    		</tr>
				    		<tr class="filter_check" style="display:none">
				    			<td><input type="checkbox"/></td>
				    			<td><font size="5">第五道滤芯</font></td>
				    			<td><input id="fiveFilterId" name="fiveFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value=''/></td>
				    			<td><input id="fiveFilterName" name="fiveFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wDeviceTypePage.filterNumFive}' /></td>
				    		</tr>
				    		<tr class="filter_check" style="display:none">
				    			<td><input type="checkbox"/></td>
				    			<td><font size="5">第六道滤芯</font></td>
				    			<td><input id="sixFilterId" name="sixFilterId" type="text" ignore="ignore" datatype="*" disabled="disabled" value=''/></td>
				    			<td><input id="sixFilterName" name="sixFilterName" type="text" ignore="ignore" datatype="*" disabled="disabled" value='${wDeviceTypePage.filterNumSix}' /></td>
				    		</tr>
				    	</table>
					</tr>
			</table>
		</t:formvalid>
 </body>
 <script type="text/javascript" >
$(function(){
	var deviceFilterNum = $("#deviceFilterNum").val();
	for(var i=0;i<=deviceFilterNum;i++){
		$("#maintainType_id").children().children().eq(i).css("display","");
	}
// 	$(".filter_check").on('change',function(){
// 		var next1 = $(this).children().eq(0).children();
// 		if( next1.prop("checked") ){
// 			$(this).children().eq(2).children().eq(0).attr("ignore","checked");
// 			$(this).children().eq(3).children().eq(0).attr("ignore","checked");//readOnly="true"
// 			$(this).children().eq(2).children().eq(0).removeAttr("disabled");
// 			$(this).children().eq(3).children().eq(0).removeAttr("disabled");
// 		}else{
// // 			$(this).children().eq(2).children().eq(0).attr("ignore","");
// // 			$(this).children().eq(3).children().eq(0).attr("ignore","");
// 			$(this).children().eq(2).children().eq(0).attr({"ignore":"","disabled":"disabled"});
// 			$(this).children().eq(3).children().eq(0).attr({"ignore":"","disabled":"disabled"});
// 		}
// 	});
})
</script>
  <script src = "webpage/jeecg/winstall/wInstall.js"></script>		
