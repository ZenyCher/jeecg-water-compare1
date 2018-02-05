package com.jeecg.waterdispenser.service.impl;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.waterdispenser.service.WWaterHeartRecordServiceI;

@Service("wWaterHeartRecordService")
@Transactional
public class WWaterHeartRecordImpl extends CommonServiceImpl implements WWaterHeartRecordServiceI{

	
	public List<Map<String, Object>> getWWaterHeartByWaterId(String waterId) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from w_water_heartrecord where meterNo = '" + waterId + "' ORDER BY updateTime DESC LIMIT 1 ");
		return commonDao.findForJdbcList(sb.toString());
	}
}
