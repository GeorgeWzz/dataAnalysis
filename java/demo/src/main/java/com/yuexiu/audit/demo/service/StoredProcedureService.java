/**
 * 
 */
package com.yuexiu.audit.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuexiu.audit.demo.mapper.StoredProcedureMapper;

/**
 * @author cai.zhiyin
 *
 */
@Service
public class StoredProcedureService {
	@Autowired
	private StoredProcedureMapper storedProcedureMapper;
	
	public List<Map<String,Object>> getProcedureData(String procedureName,Map<String,String> paramMap) {
		List<Map<String,Object>> result = 
		storedProcedureMapper.execStoredProcedure(procedureName,paramMap);
		return result;
	}
	
	public Set<String> getColumns(List<Map<String,Object>> dataList) {
		Set<String> columnSet = new HashSet<>();
		for (Map<String,Object> data : dataList) {
			columnSet.addAll(data.keySet());
		}
		
		return columnSet;
	}
}
