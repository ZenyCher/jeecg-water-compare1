

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

//根据会员联系方式查找设备
function saveUserDevice() {
	$("#deviceId").empty();
	var memberPhone = $("#memberPhone").val();
	if( memberPhone == null || memberPhone == "" ) {
		tip("请先选择会员，会员不能为空!")
		return false;
	}
	var s = $("#deviceId");
	var url = "wmaintainController.do?saveUserDevice&memberPhone="+memberPhone;
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		success:function(data){
			if( data.success == true ){
				var device = data.obj;
				var s_li = "";
				for(var i=0;i<device.length;i++){
					s_li += "<option value='"+device[i].device_id+"'>"+device[i].device_name+"</option>";
				}
				s.append(s_li);
//				$( device ).each(function(key,value){
//					s_li += "<option value='"+value.device_id+"'>"+value.device_name+"</option>";
//					s.append(s_li);
//				});
			}else{
				tip(data.msg);
			}
		}
	})
}