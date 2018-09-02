/**
 * 
 */
package com.yuexiu.audit.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author cai.zhiyin
 *
 */
public interface StoredProcedureMapper {
	List<Map<String,Object>> execStoredProcedure(@Param("procedureName") String procedureName, Map<String, String> paramMap);
}
