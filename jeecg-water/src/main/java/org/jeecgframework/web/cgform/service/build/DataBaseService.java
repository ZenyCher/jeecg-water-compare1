package org.jeecgframework.web.cgform.service.build;

import java.util.List;
import java.util.Map;

import org.jeecgframework.web.cgform.entity.enhance.CgformEnhanceJavaEntity;
import org.jeecgframework.web.cgform.exception.BusinessException;

import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;

/**
 * 
 * @author  张代浩
 *
 */
public interface DataBaseService {

	public void insertTable(String tableName, Map<String, Object> data) throws BusinessException ;

	public int updateTable(String tableName,Object id, Map<String, Object> data) throws BusinessException ;

	
	public Map<String, Object>  findOneForJdbc(String tableName, String id);
	public Map<String, Object>  findOneForPhone(String tableName,String phone);
	public List<Map<String, Object>>  findOneFor(String tableName);
	public List<Map<String, Object>> findTableKeyAndValue(String tableName,Map<String, Object> map);
	
	public Map<String, Object> insertTableMore(Map<String,List<Map<String,Object>>> mapMore,String mainTableName) throws BusinessException;
	
	public boolean updateTableMore(Map<String,List<Map<String,Object>>> mapMore,String mainTableName) throws BusinessException;
	
	/**
	 * sql业务增强
	 * 
	 */
	public void executeSqlExtend(String formId,String buttonCode,Map<String, Object> data);

	public Object getPkValue(String tableName);

	/**
	 * java业务增强
	 * @param formId
	 * @param buttonCode
	 * @param data
	 */
	public void executeJavaExtend(String formId, String buttonCode,Map<String, Object> data) throws BusinessException;

	public List<CgformEnhanceJavaEntity> getCgformEnhanceJavaEntityByFormId(String formId);

}
