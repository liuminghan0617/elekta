package com.makervt.elekta.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for Healing
 * meaning 康复过程
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class Healing extends Page<Healing>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	

	/**
	 * 康复进度
	 */
	public String healingProgress;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHealingProgress() {
		return healingProgress;
	}

	public void setHealingProgress(String healingProgress) {
		this.healingProgress = healingProgress;
	}

	


	
}
