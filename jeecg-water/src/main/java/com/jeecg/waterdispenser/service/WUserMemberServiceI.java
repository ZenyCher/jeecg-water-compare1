package com.jeecg.waterdispenser.service;
import com.jeecg.waterdispenser.entity.WUserMemberEntity;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WUserMemberServiceI extends CommonService{
	
 	public void delete(WUserMemberEntity entity) throws Exception;
 	
 	public Serializable save(WUserMemberEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WUserMemberEntity entity) throws Exception;
 	
 	public int updateMemberState(String id) throws Exception;
 	
 	public int updateMemberStateIsInvalid(String id) throws Exception;
 	
 	public List<Map<String, Object>> getUserMenberByPhone(String memberPhone) throws Exception;
 	
}
