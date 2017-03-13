package com.makervt.elekta.entity;

import java.sql.Timestamp;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

@JSONType(ignores = { "pageNo", "pageSize", "pageTotal", "totalCount", "start" })
public class AppVersion extends Page<AppVersion> {
	private static final long serialVersionUID = 101634403684362343L;

	private Integer id;
	private Integer app_type;
	private String app_url;
	private String version_code;
	private Integer force_update_flag;
	private Timestamp insert_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getApp_type() {
		return app_type;
	}

	public void setApp_type(Integer app_type) {
		this.app_type = app_type;
	}

	public String getApp_url() {
		return app_url;
	}

	public void setApp_url(String app_url) {
		this.app_url = app_url;
	}

	public String getVersion_code() {
		return version_code;
	}

	public void setVersion_code(String version_code) {
		this.version_code = version_code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Timestamp getInsert_time() {
		return insert_time;
	}

	public void setInsert_time(Timestamp insert_time) {
		this.insert_time = insert_time;
	}
	
	public Integer getForce_update_flag() {
		return force_update_flag;
	}

	public void setForce_update_flag(Integer force_update_flag) {
		this.force_update_flag = force_update_flag;
	}

	@Override
	public String toString() {
		return JSONObject.toJSON(this).toString();
	}
}
