package com.jeecg.api.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.batik.apps.svgbrowser.Application;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileDeleteStrategy;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.cgform.exception.BusinessException;
import org.jeecgframework.web.cgform.service.build.DataBaseService;
import org.jeecgframework.web.cgform.util.TableJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jeecg.api.util.FileUtil;


@Controller
@RequestMapping("/appUploadImage")
public class AppUploadImage {
	
	@Autowired
	private DataBaseService dataBaseService;
	
	/**
	 * APP移动端上传实体及图片
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "appUploadImage")
	@ResponseBody
	public TableJson AppUploadTableImage(HttpServletRequest request,HttpServletResponse response){
		TableJson j = new TableJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, Object> entityMap = new HashMap<String, Object>();
		String fileName = null;
		//获取保存实体所需参数
		String id = multipartRequest.getParameter("id");
		String tableName = multipartRequest.getParameter("tableName");
		String tableField = multipartRequest.getParameter("tableField");
		//图片上传
		String ctxPath=ResourceUtil.getConfigByName("uploadFiles");
 		File file = new File(ctxPath+File.separator);
 		if (!file.exists()) {
			file.mkdir();
		}
        MultipartFile mf=multipartRequest.getFile("file");// 获取上传文件对象
		fileName = mf.getOriginalFilename();// 获取文件名
		String savePath = file.getPath() + File.separator + fileName;
		File savefile = new File(savePath);
		try {
			FileCopyUtils.copy(mf.getBytes(), savefile);
		} catch (Exception e) {
			j.setMsg("上传文件失败，请稍后再试");
			j.setSuccess(false);
		}
		StringBuffer tableFieldValue = new StringBuffer();
//		tableFieldValue.append(ctxPath.substring(4, ctxPath.length())).append("/" + fileName);
		tableFieldValue.append(fileName);
		String str = multipartRequest.getParameter("body");
		Map<String,Object> map = new HashMap<String, Object>();
		if( oConvertUtils.isNotEmpty(str) ){
			map = JSONHelper.json2Map(str);
		}
		
		//根据表名和id查询该条记录是否为空,为空则新建，不为空则更新
		entityMap.put("id", id);
		List<Map<String, Object>> list = dataBaseService.findTableKeyAndValue(tableName, entityMap);
		try {
			if( list.isEmpty() && list.size() == 0 ) {
				map.put("id", id);
				map.put(tableField, tableFieldValue.toString());
				dataBaseService.insertTable(tableName, map);
				j.setMsg("表新建成功");
			}else {
				StringBuffer valueSb = new StringBuffer();
				//判断图片字段是否已有数值，有则加逗号继续添加
				for (Map<String, Object> map2 : list) {
					String value = (String) map2.get(tableField);
					if( oConvertUtils.isNotEmpty(value) ){
//						valueSb.append(value).append(",").append(tableFieldValue.toString());
						//删除文件
						String ctxPath1=ResourceUtil.getConfigByName("uploadFiles");
						File file2 = new File(ctxPath1+value);
						file2.delete();
					}
				}
				map.put(tableField, tableFieldValue.toString());
				dataBaseService.updateTable(tableName, id, map);
				j.setMsg("表更新成功");
			}
			List<Map<String, Object>> list2 = dataBaseService.findTableKeyAndValue(tableName, entityMap);
			j.setTableData(list2);
		} catch (Exception e) {
			j.setMsg("表数据更新失败，请稍后再试");
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * APP移动端上传实体及图片
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "appUploadImageOne")
	@ResponseBody
	public TableJson AppUploadTableImageOne(HttpServletRequest request,HttpServletResponse response){
		TableJson j = new TableJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, Object> entityMap = new HashMap<String, Object>();
		String fileName = null;
		//获取保存实体所需参数
		String id = multipartRequest.getParameter("id");
		String tableName = multipartRequest.getParameter("tableName");
		String tableField = multipartRequest.getParameter("tableField");
		//图片上传
		String ctxPath=ResourceUtil.getConfigByName("uploadFiles");
 		File file = new File(ctxPath+File.separator);
 		if (!file.exists()) {
			file.mkdir();
		}
 		List<MultipartFile> listFiles = multipartRequest.getFiles("file");
 		for (int i = 0; i < listFiles.size(); i++) {
			String str = listFiles.get(i).getOriginalFilename();
			if( oConvertUtils.isNotEmpty(str) ){
				fileName += listFiles.get(0).getOriginalFilename();
				String savePa = file.getPath() + File.separator + fileName;
				File savefile = new File(savePa);
				try {
					FileCopyUtils.copy(listFiles.get(i).getBytes(), savefile);
				} catch (Exception e) {
					j.setMsg("上传文件失败，请稍后再试");
					j.setSuccess(false);
				}
			}
		}
		StringBuffer tableFieldValue = new StringBuffer();
		tableFieldValue.append(fileName);
		String str = multipartRequest.getParameter("body");
		Map<String,Object> map = new HashMap<String, Object>();
		if( oConvertUtils.isNotEmpty(str) ){
			map = JSONHelper.json2Map(str);
		}
		
		//根据表名和id查询该条记录是否为空,为空则新建，不为空则更新
		entityMap.put("id", id);
		List<Map<String, Object>> list = dataBaseService.findTableKeyAndValue(tableName, entityMap);
		try {
			if( list.isEmpty() && list.size() == 0 ) {
				map.put("id", id);
				map.put(tableField, tableFieldValue.toString());
				dataBaseService.insertTable(tableName, map);
				j.setMsg("表新建成功");
			}else {
				StringBuffer valueSb = new StringBuffer();
				//判断图片字段是否已有数值，有则加逗号继续添加
				for (Map<String, Object> map2 : list) {
					String value = (String) map2.get(tableField);
					if( oConvertUtils.isNotEmpty(value) ){
//						valueSb.append(value).append(",").append(tableFieldValue.toString());
						//删除文件
						String ctxPath1=ResourceUtil.getConfigByName("uploadFiles");
						File file2 = new File(ctxPath1+value);
						file2.delete();
					}
				}
				map.put(tableField, tableFieldValue.toString());
				dataBaseService.updateTable(tableName, id, map);
				j.setMsg("表更新成功");
			}
			List<Map<String, Object>> list2 = dataBaseService.findTableKeyAndValue(tableName, entityMap);
			j.setTableData(list2);
		} catch (Exception e) {
			j.setMsg("表数据更新失败，请稍后再试");
			j.setSuccess(false);
		}
		return j;
	}
	
}

