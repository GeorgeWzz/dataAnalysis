/**
 * 
 */
package com.yuexiu.audit.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuexiu.audit.demo.api.MyTable;
import com.yuexiu.audit.demo.api.Student;
import com.yuexiu.audit.demo.service.StoredProcedureService;

/**
 * @author cai.zhiyin
 *
 */
@RestController
@RequestMapping(value = "/procedure")
public class ProcedureController {

	@Autowired
	private StoredProcedureService storedProcedureService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello1(@RequestParam("abc") String abcd) {
		return abcd;
	}

	@RequestMapping(value = "/luckyList", method = RequestMethod.GET)
	public List<Student> luckyList(@RequestParam("abc") String abcd) {
		List<Student> stuList = new ArrayList<Student>();
		Student a = new Student("1", "吴子卓", "吴子卓养喵");
		Student b = new Student("2", "蔡芷茵", "蔡芷茵是喵");
		Student c = new Student("3", "蔡芷茵", "蔡芷茵是喵");
		stuList.add(a);
		stuList.add(b);
		stuList.add(c);
		return stuList;
	}

	@RequestMapping(value = "/procedure", method = RequestMethod.GET)
	public MyTable procedure(@RequestParam("procedureName") String procedureName) {
		MyTable table = new MyTable();
		// 租赁业务台账_IRR低于公司标准
		List<Map<String, Object>> tableData = storedProcedureService.getProcedureData(procedureName, null);
		table.setTableData(tableData);
		table.setColumns(storedProcedureService.getColumns(tableData));

		return table;
	}

}
