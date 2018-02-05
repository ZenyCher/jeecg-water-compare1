package org.jeecgframework.web.cgform.service.impl.upload;

import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.FileUtils;
import org.jeecgframework.core.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.jeecgframework.web.cgform.dao.upload.CgFormUploadDao;
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.upload.CgUploadServiceI;
@Service("cgUploadService")
@Transactional
public class CgUploadServiceImpl extends CommonServiceImpl implements CgUploadServiceI {
	@Autowired
	private CgFormUploadDao cgFormUploadDao;
	
	public void deleteFile(CgUploadEntity file) {
		//step.1 删除附件
		String sql = "select * from t_s_attachment where id = ?";
		Map<String, Object> attachmentMap = commonDao.findOneForJdbc(sql, file.getId());
		//附件相对路径
		String realpath = (String) attachmentMap.get("realpath");
		String fileName = FileUtils.getFilePrefix2(realpath);
		
		//获取部署项目绝对地址
//		String realPath = ContextHolderUtils.getSession().getServletContext().getRealPath("/");
		PropertiesUtil util = new PropertiesUtil("sysConfig.properties");
		String dbtype = util.readProperty("uploadFiles");
		FileUtils.delete(dbtype+realpath);
		FileUtils.delete(dbtype+fileName+".pdf");
		FileUtils.delete(dbtype+fileName+".swf");
		//step.2 删除数据
		commonDao.delete(file);
	}

	
	public void writeBack(String cgFormId,String cgFormName,String cgFormField,String fileId,String fileUrl) {
		try{
			cgFormUploadDao.updateBackFileInfo(cgFormId, cgFormName, cgFormField, fileId, fileUrl);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("文件上传失败："+e.getMessage());
		}
	}
	
	public String selectEntryById(String id,String tableName,String cgField) throws Exception{
		return cgFormUploadDao.selectEntryById(id, tableName, cgField);
	}
	
	public Boolean updateAndAddById(String id,String tableName,String cgField,String cgFieldValue) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("update " + tableName + " set " + cgField + "= " + cgFieldValue + " where id = '" + id + "'");
		int fals = commonDao.updateBySqlString(sb.toString());
		if( fals > 0 ){
			return true;
		}else {
			return false;
		}
	}

}
