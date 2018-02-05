<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.jeecgframework.core.util.SysThemesUtil,org.jeecgframework.core.enums.SysThemesEnum"%>
<%@include file="/context/mytags.jsp"%>
<%
  session.setAttribute("lang","zh-cn");
  SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
  String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta charset="utf-8" />
  <title><t:mutiLang langKey="jeect.platform"/></title>
   <link rel="shortcut icon" href="images/favicon.ico">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
  <!-- bootstrap & fontawesome -->
  <link rel="stylesheet" href="<%=basePath %>/plug-in/ace/css/bootstrap.css" />
  <link rel="stylesheet" href="<%=basePath %>/plug-in/ace/css/font-awesome.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/plug-in/accordion/css/accordion.css">
  <!-- text fonts -->
  <link rel="stylesheet" href="<%=basePath %>/plug-in/ace/css/ace-fonts.css" />

  <link rel="stylesheet" href="<%=basePath %>/plug-in/ace/css/jquery-ui.css" />
  <!-- ace styles -->
  <link rel="stylesheet" href="<%=basePath %>/plug-in/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

</head>
<body class="login-layout light-login" id="sojob" onload="checkTime();">
<div class="main-container">
  <div class="main-content">
    <div class="row">
      <div class="col-sm-10 col-sm-offset-1">
        <div class="login-container">
          <div class="center">
            <h1 id="id-text2" class="grey">
              <i class="ace-icon fa fa-leaf green"></i>
               
            </h1>
            <h4 class="blue" id="id-company-text">直饮饮水机管理系统</h4>
          </div>
          <div class="space-6"></div>
          <div class="position-relative">
            <div id="login-box" class="login-box visible widget-box no-border">
              <div class="widget-body">
                <form id="loinForm" class="form-horizontal" role="form"  method="post">
                <div class="widget-main">
                 <div class="alert alert-warning alert-dismissible" role="alert" id="errMsgContiner">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <div id="showErrMsg"></div>
				</div>
                  <h4 class="header blue lighter bigger">
                    <i class="ace-icon fa fa-coffee green"></i>
                	    用户密码修改
                  </h4>
                  <div class="space-6"></div>
                      <label class="block clearfix">
							<span class="block input-icon input-icon-right">
								<input type="text"  name="userName" class="form-control" placeholder="请输入手机号码"  id="userName"/>
							</span>
                      </label>
                      <label class="block clearfix">
                        <div class="input-group">
                          <input type="text" style="width:150px" name="randCode" class="form-control" placeholder="请输入验证码"  id="randCode"/>
                        </div>
                      </label>
                      <label class="block clearfix" >
							<span class="block input-icon input-icon-right">
								<input type="password"  name="old_password" class="form-control" placeholder="请输入新密码"  id="old_password" style="display: none;"/>
							</span>
                      </label>
                     <label class="block clearfix" >
							<span class="block input-icon input-icon-right">
								<input type="password"  name="new_password" class="form-control" placeholder="重新输入新密码"  id="new_password" style="display: none;"/>
							</span>
                      </label>
                     <div class="space-4"></div>
	                <div class="clearfix">
	                	<button type="button" id="but_password"  onclick="modelPassword()" class="width-45 pull-left btn btn-sm btn-primary">
	                		<span class="bigger-110" >点击获取验证码</span>
	                	</button>
<!-- 	                	<div class="space-4"></div> -->
	                	<button type="button" id="tijiao"  onclick="newPassword()" class="width-45 pull-right btn btn-sm btn-primary" style="display: none;">
	                		<span class="bigger-110" >确定</span>
	                	</button>
	                </div>
<!-- 	                <div class="space-4"></div> -->
<!-- 	                <div class="clearfix text-center"> -->
<!-- 	                	<button type="button" id="tijiao"  onclick="tijiao()" class="width-50 .center-block btn btn-sm btn-primary" style="display: none;"> -->
<!-- 	                		<span class="bigger-110" >确定</span> -->
<!-- 	                	</button> -->
<!-- 	                </div> -->
                </div>
                </form>
              </div>
            </div>
<!--             <div class="center"><h4 class="blue" id="id-company-text">&copy; JEECG版权所有 v_3.7</h4></div> -->
            <div class="navbar-fixed-top align-right">
              <br />
              &nbsp;
              <a id="btn-login-dark" class="blue" href="#" onclick="darkStyle()">Dark</a>
              &nbsp;
              <span class="blue">/</span>
              &nbsp;
              <a id="btn-login-blur" class="blue" href="#" onclick="blurStyle()">Blur</a>
              &nbsp;
              <span class="blue">/</span>
              &nbsp;
              <a id="btn-login-light" class="blue" href="#" onclick="lightStyle()">Light</a>
              &nbsp; &nbsp; &nbsp;
            </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>



<script type="text/javascript" src="<%=basePath %>/plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=basePath %>/plug-in/mutiLang/en.js"></script>
<script type="text/javascript" src="<%=basePath %>/plug-in/mutiLang/zh-cn.js"></script>
<script type="text/javascript" src="<%=basePath %>/plug-in/login/js/jquery.tipsy.js"></script>
<script type="text/javascript" src="<%=basePath %>/plug-in/login/js/iphone.check.js"></script>
<script type="text/javascript" src="<%=basePath %>/plug-in/login/js/login.js"></script>
<script type="text/javascript">
	$(function(){
		optErrMsg();
	});
	$("#errMsgContiner").hide();
	function optErrMsg(){
		$("#showErrMsg").html('');
		$("#errMsgContiner").hide();
	}

   //输入验证码，回车登录
  $(document).keydown(function(e){
  	if(e.keyCode == 13) {
  		$("#but_login").click();
  	}
  });

  //验证用户信息
  function checkUser(){
    if(!validForm()){
      return false;
    }
    newLogin();
  }
  //表单验证
  function validForm(){
    if($.trim($("#userName").val()).length==0){
      showErrorMsg("请输入手机号码");
      return false;
    }
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
    if(!myreg.test($("#userName").val())){
    	showErrorMsg("请输入有效的手机号码");
        return false; 
    } 
    return true;
  }
  //新旧密码验证
  function validFormPassword(){
	  if($.trim($("#old_password").val()).length  == 0 ){
		  showErrorMsg("请输入旧密码");
		  return false;
	  }
	  if($.trim($("#new_password").val()).length == 0 ){
		  showErrorMsg("请输入新密码");
		  return false;
	  }
	  if($.trim($("#old_password").val()) != $.trim($("#new_password").val()) ){
		  showErrorMsg("两次密码不一致，请重新输入");
		  return false;
	  }
	  return true;
  }
  
  //登录提示消息显示
  function showErrorMsg(msg){	
    $("#errMsgContiner").show();
    $("#showErrMsg").html(msg);    
    window.setTimeout(optErrMsg,3000); 
  }
  /**
   * 刷新验证码
   */
$('#randCodeImage').click(function(){
    reloadRandCodeImage();
});
function reloadRandCodeImage() {
    var date = new Date();
    var img = document.getElementById("randCodeImage");
    img.src='<%=basePath %>/randCodeImage?a=' + date.getTime();
}

  function darkStyle(){
    $('body').attr('class', 'login-layout');
    $('#id-text2').attr('class', 'red');
    $('#id-company-text').attr('class', 'blue');
    e.preventDefault();
  }
  function lightStyle(){
    $('body').attr('class', 'login-layout light-login');
    $('#id-text2').attr('class', 'grey');
    $('#id-company-text').attr('class', 'blue');

    e.preventDefault();
  }
  function blurStyle(){
    $('body').attr('class', 'login-layout blur-login');
    $('#id-text2').attr('class', 'white');
    $('#id-company-text').attr('class', 'light-blue');

    e.preventDefault();
  }
//设置cookie
//   function setCookie()
//   {
//   	if ($('#on_off').val() == '1') {
//   		$("input[iscookie='true']").each(function() {
//   			$.cookie(this.name, $("#"+this.name).val(), "/",24);
//   			$.cookie("COOKIE_NAME","true", "/",24);
//   		});
//   	} else {
//   		$("input[iscookie='true']").each(function() {
//   			$.cookie(this.name,null);
//   			$.cookie("COOKIE_NAME",null);
//   		});
//   	}
//   }
  //读取cookie
//   function getCookie()
//   {
//   	var COOKIE_NAME=$.cookie("COOKIE_NAME");
//   	if (COOKIE_NAME !=null) {
//   		$("input[iscookie='true']").each(function() {
//   			$($("#"+this.name).val( $.cookie(this.name)));
//               if("admin" == $.cookie(this.name)) {
//                   $("#randCode").focus();
//               } else {
//                   $("#password").val("");
//                   $("#password").focus();
//               }
//           });
//   		$("#on_off").attr("checked", true);
//   		$("#on_off").val("1");
//   	} 
//   	else
//   	{
//   		$("#on_off").attr("checked", false);
//   		$("#on_off").val("0");
//         $("#randCode").focus();
//   	}
//   }
  
  //忘记密码
	function modelPassword(){
	  if(!validForm()){
		  return false;
	  }
	  var phone = document.getElementById("userName");
	  var value = phone.value.trim();
	  if(value && value.length == 11){
          $.ajax({
        		async : false,
        		cache : false,
        		type : 'POST',
        		url : '<%=basePath %>/loginController.do?modifyPassword',// 请求的action路径
        		data : {phone:value,tm:new Date().getTime()},
        		success : function(data) {
        			var jsonObj = JSON.parse( data );
        			if(jsonObj.success){
           				for (var i = 1; i <= 60; i++) {
           					window.setTimeout("updateTime(" + (60 - i) + ")", i * 1000);
           				}
           				var old =document.getElementById("old_password");
           				var newp =document.getElementById("new_password");
           				var tijiao = document.getElementById("tijiao");
           				old.style.display="";  
           				newp.style.display="";
           				tijiao.style.display="";
        			}else{
        				showErrorMsg(jsonObj.msg);
        			}     				
        		}
            });
	}
  }
function updateTime(i){
	var obj = document.getElementById("but_password");
	if(i > 0){
		obj.innerHTML  = "" + i + "秒";
		obj.disabled = true;
	}else{
		obj.innerHTML = "获取验证码";
		obj.disabled = false;
	}  
}
function checkTime(){  
    var sendCodeTime = <%=(Long)session.getAttribute("SEND_CODE_TIME")%>;  
    if(sendCodeTime){  
        var nowTime = new Date().getTime();  
        var flag = Math.floor((nowTime - sendCodeTime)/1000);  
        if(flag < 60){  
            var end = 2 - flag;  
         
            for (var i = 60; i <= end; i++) {  
                window.setTimeout("updateTime(" + (end - i) + ")", i * 1000);  
            }  
        }  
    }  
}
//提交新密码
function newPassword(){
	if(!validFormPassword()){
		return false;
	}
    $.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : '<%=basePath %>/loginController.do?newPassword',// 请求的action路径
		data : $("#loinForm").serialize(),
		success : function(data) {
			var jsonObj = JSON.parse( data );
			if(jsonObj.success){
				showErrorMsg("修改密码成功,正在跳转登陆页面....");
	 			window.setTimeout(function() {
					window.location.replace('<%=basePath %>/loginController.do?login');
	 			}, 2000);
				window.setTimeout("updateTime(" + 0 + ")");
			}else if(jsonObj.success == false){
				showErrorMsg(jsonObj.msg);
			}
		}
    });
}
</script>

</body>
</html>