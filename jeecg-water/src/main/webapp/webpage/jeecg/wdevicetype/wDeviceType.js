

//通用弹出式文件上传
function commonUpload(callback){
    $.dialog({
           content: "url:systemController.do?commonUpload",
           lock : true,
           title:"文件上传",
           zIndex:2100,
           width:700,
           height: 200,
           parent:windowapi,
           cache:false,
       ok: function(){
               var iframe = this.iframe.contentWindow;
               iframe.uploadCallback(callback);
                   return true;
       },
       cancelVal: '关闭',
       cancel: function(){
       } 
   });
}
function browseImages(inputId, Img) {// 图片管理器，可多个上传共用
}
function browseFiles(inputId, file) {// 文件管理器，可多个上传共用
}
function decode(value, id) {//value传入值,id接受值
	var last = value.lastIndexOf("/");
	var filename = value.substring(last + 1, value.length);
	$("#" + id).text(decodeURIComponent(filename));
}
function typedisabled(){
	var typeNum = $("#deviceFilterNum").val();
	if( typeNum == 3 ){
		$("#filter_Four").css("display","none");
		$("#filterNumFour").removeAttr("datatype");
		$("#filter_Five").css("display","none");
		$("#filterNumFive").removeAttr("datatype");
		$("#filter_Six").css("display","none");
		$("#filterNumSix").removeAttr("datatype");
	}else if( typeNum == 4 ){
		$("#filter_Four").css("display","");
		$("#filterNumFour").attr("datatype","n");
		$("#filter_Five").css("display","none");
		$("#filterNumFive").removeAttr("datatype");
		$("#filter_Six").css("display","none");
		$("#filterNumSix").removeAttr("datatype");
	}else if( typeNum == 5 ){
		$("#filter_Four").css("display","");
		$("#filterNumFour").attr("datatype","n");
		$("#filter_Five").css("display","");
		$("#filterNumFive").attr("datatype","n");
		$("#filter_Six").css("display","none");
		$("#filterNumSix").removeAttr("datatype");
	}else if( typeNum == 6 ){
		$("#filter_Four").css("display","");
		$("#filterNumFour").attr("datatype","n");
		$("#filter_Five").css("display","");
		$("#filterNumFive").attr("datatype","n");
		$("#filter_Six").css("display","");
		$("#filterNumSix").attr("datatype","n");
	}
}