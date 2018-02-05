<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<%
String lang = org.jeecgframework.core.util.BrowserUtils.getBrowserLanguage(request);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--360浏览器优先以webkit内核解析-->
    <title>Jeecg 微云快速开发平台</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/style.css?v=4.1.0" rel="stylesheet">
    <style>
    	.mg15 {
    		margin : 0 15px;
    		text-align : center;
    	}
    	.mg15 img {
    		max-width : 100%;
    		width : 100%;
    	}
    	.add_water {
    		width:120px !important;
    		height:100px;
    	}
    </style>
</head>
<body class="gray-bg">
<!-- 		  	 <div class="wrapper wrapper-content" style="float: right;"> -->
		  	 <div class="wrapper wrapper-content" class="text-center" style="text-align:right;">
<!-- 				<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="searchReset()">刷新</a> -->
<!-- 				<input type="hidden" name="sysCompanyCode"> -->
				<button type="button" class="btn btn-primary" onclick="refresh()">刷新</button>
				<p><label class="Validform_label">最后更新时间:</label><span id="refresh_date"></span></p>
			 </div>
<div class="wrapper wrapper-content">
            <c:forEach items="${longMap}" varStatus="itemStatus" var="item">
           		<c:forEach items="${item}" var="em">
           			<input id="${em.key }" name="${em.key }" value="${em.value }" type="hidden">
           		</c:forEach>
           	</c:forEach>
    <div class="row">
        <div class="col-sm-2 mg15">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/installed.png" class="add_water"></p>
                    <p><span id="installed">0</span></p>
                    <p>提醒待装数量</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/repaired.png" class="add_water"></p>
                    <p><span id="repaired">0</span></p>
                    <p>待修数量</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15 rolaName">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/giftExchange.png" class="add_water"></p>
                    <p><span id="gift_sunNumber">0</span></p>
                    <p>兑换礼品总数</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15 rolaName">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/message.png" class="add_water"></p>
                    <p><span id="message">0</span></p>
                    <p>待回复信息数量</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15 rolaName">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/alarm.png" class="add_water"></p>
                    <p><span id="alarm">0</span></p>
                    <p>告警数量</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15 rolaName">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/water.png" class="add_water"></p>
                    <p><span id="water">0</span></p>
                    <p>今日用水总量(升)</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15 rolaName">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/add_member.png" class="add_water"></p>
                    <p><span id="add_member">0</span></p>
                    <p>新增会员数</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15 rolaName">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/add_register.png" class="add_water"></p>
                    <p><span id="add_register">0</span></p>
                    <p>新增注册数</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 mg15 rolaName">
            <div class="ibox float-e-margins">
                <div>
                    <p><img src="plug-in/login/images/add_money.png" class="add_water"></p>
                    <p><span id="add_money">0</span></p>
                    <p>充值金额(元)</p>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in-ui/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="plug-in-ui/hplus/js/content.js"></script>
<script type="text/javascript">
$(function(){
	var roleName = $("#roleName").val();
	if( roleName == 2 ){
		$(".rolaName").css('display','none');
	}
//	 将循环出来的值赋值给div标签
	$("#installed").html($("#orgNum").val());//提醒待装数量
	$("#repaired").html($("#wxNum").val());//待修数量
	$("#gift_sunNumber").html($("#giftNum").val());//兑换礼品总数
	$("#message").html($("#msgNum").val());//待回复信息数
	$("#alarm").html($("#warLong").val());//告警数量
	$("#water").html($("#warteNum").val());//今日用水总量
	$("#add_member").html($("#DateNum").val());//新增会员数
	$("#add_register").html($("#DateNum1").val());//新增注册数
	$("#add_money").html($("#moneyNum").val());//充值金额
	$("#refresh_date").html($("#refresh").val());
	
});

function refresh(){
// 	var myDate = new Date();
// 	var mytime=myDate.toLocaleString();
// 	$("#refresh_date").html(mytime);
	location.reload('loginController/hplushome');
}
</script>
</body>

</html>
