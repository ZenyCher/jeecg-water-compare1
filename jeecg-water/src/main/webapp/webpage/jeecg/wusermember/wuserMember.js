

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
function selectType(){
	$("#memberPackageId").empty();
	var packageId = $("#memberPackageId").val();
	var packageMsg = $("#memberPackageMsg").val();
	var type = $("#memberPackageType").val();//0为首冲套餐，1为正常套餐
	var url = "wuserMemberController.do?savePackage";
	var params = "";
	if( type != null && type != "" ){
		params += url + "&type=" + type;
		$.ajax({
			url:params,
			type:"post",
			success:function(data){
				var success = data.success;
				var c = $.parseJSON(data);
				var s_li = "";
				if( packageId != null && packageMsg != ""){
					s_li += "<option value='" + packageId + "'>" + packageMsg + "</option>";
				}
				$.each(c.obj, function(key, value) {
					s_li += "<option value='" + value.id + "'>" + value.packageDescribe + "</option>";
				});
				$("#memberPackageId").append(s_li);
			}
		})
	}
}