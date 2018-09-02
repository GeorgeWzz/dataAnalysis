/**
 * 
 */
package com.yuexiu.audit.demo.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author cai.zhiyin
 *
 */
public class MyTable {
	Set<String> columns;
	List<Map<String, Object>> tableData;

	public Set<String> getColumns() {
		return columns;
	}

	public void setColumns(Set<String> columns) {
		this.columns = columns;
	}

	public List<Map<String, Object>> getTableData() {
		return tableData;
	}

	public void setTableData(List<Map<String, Object>> tableData) {
		this.tableData = tableData;
	}

}
