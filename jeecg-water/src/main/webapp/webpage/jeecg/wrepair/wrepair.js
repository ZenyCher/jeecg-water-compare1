

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
//$(function(){
//	var filterNumber = $("#filterNember").val();
//	for(var i=0;i<=3;i++){
//		$("#maintainType_id").children().children().eq(i).css("display","");
//	}
//	$("#maintainType_id").css("display","none");
//	$("#maintainFilter_type").css("display","none");
//	$("#maintainWater_type").css("display","none");
//	var maintainType = $("#maintainType").val();
//	if( maintainType == 0 ){
//		$("#maintainType").val("故障");
//	}else if( maintainType == 1 ){
//		$("#maintainType").val("滤芯更换");
//		$("#maintainFilter_type").css("display","");
//		$("#maintainWater_type").css("display","");
//		$("#maintainType_id").css("display","");
//	}else if( maintainType == 2 ){
//		$("#maintainType").val("其他");
//	}
//	$(".filter_check").on('change',function(){
//		var next1 = $(this).children().eq(0).children();
//		if( next1.prop("checked") ){
//			$(this).children().eq(1).children().eq(0).attr("ignore","checked");
//			$(this).children().eq(2).children().eq(0).attr("ignore","checked");
//		}
//	});
//})
