package org.jeecgframework.web.cgform.dao.water;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

@Repository("waterImageDao")
public interface WaterImageDao {

	
 	@Arguments({"id", "tableName" ,"fileKey"})
 	@ResultType(String.class)
 	@Sql("select :fileKey from :tableName where id = :id ")
 	String selectEntryById(String id,String tableName,String fileKey);
}
