/**
 * 
 */
package com.yuexiu.audit.demo.api;

import java.io.Serializable;

/**
 * @author cai.zhiyin
 *
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 701358002861249561L;

	public Student() {
	}

	public Student(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	private String id;

	private String name;

	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
