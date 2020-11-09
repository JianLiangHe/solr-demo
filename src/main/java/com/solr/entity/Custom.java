package com.solr.entity;

import java.io.Serializable;

public class Custom implements Serializable {
	
	private int id;
	
	private String custom_name;
	
	private String cutom_code;

	public Custom() {
		super();
	}

	public Custom(int id, String custom_name, String cutom_code) {
		super();
		this.id = id;
		this.custom_name = custom_name;
		this.cutom_code = cutom_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustom_name() {
		return custom_name;
	}

	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}

	public String getCutom_code() {
		return cutom_code;
	}

	public void setCutom_code(String cutom_code) {
		this.cutom_code = cutom_code;
	}
	
}
