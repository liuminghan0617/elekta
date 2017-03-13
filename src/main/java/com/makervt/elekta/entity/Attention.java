package com.makervt.elekta.entity;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONType;
import com.makervt.core.domain.Page;

/**
 * mapping for attention
 * meaning 注意事项
 * @author CodeGenerator
 */
 @JSONType(ignores = {"pageNo", "pageSize", "pageTotal","totalCount","start"})
public class Attention extends Page<Attention>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * mapping for attention.Attention_id
	 * meaning 
	 */
	private String attentionId;

	/**
	 * mapping for attention.Attention_title
	 * meaning 注意事项标题
	 */
	private String attentionTitle;

	/**
	 * mapping for attention.Attention_content
	 * meaning 注意事项内容html
	 */
	private String attentionContent;

	/**
	 * mapping for attention.schedule_Treat_Type
	 * meaning 预约治疗类型(0：CT，1：体位固定，2：复位  3：放疗)
	 */
	private String scheduleTreatType;

	/**
	 * mapping for attention.schedule_Treat_Item
	 * meaning 预约治疗类型名称
	 */
	private String scheduleTreatItem;

	/**
	 * mapping for attention.schedule_Treat_Part
	 * meaning 预约治疗部位标识
	 */
	private String scheduleTreatPart;

	/**
	 * mapping for attention.schedule_Treat_Part_name
	 * meaning 预约治疗部位名称
	 */
	private String scheduleTreatPartName;

	/**
	 * mapping for attention.Attention_type
	 * meaning 事项类型(0 注意事项 1办理流程)
	 */
	private String attentionType;

	/**
	 * mapping for attention.Attention_hosp_id
	 * meaning 医院标识
	 */
	private String attentionHospId;

	/**
	 * mapping for attention.Attention_hosp_name
	 * meaning 医院名称
	 */
	private String attentionHospName;

	/**
	 * mapping for attention.Attention_create_user
	 * meaning 创建人
	 */
	private String attentionCreateUser;

	/**
	 * mapping for attention.Attention_create_date
	 * meaning 创建时间
	 */
	private String attentionCreateDate;

	/**
	 * mapping for attention.Attention_update_user
	 * meaning 更新人
	 */
	private String attentionUpdateUser;

	/**
	 * mapping for attention.Attention_update_date
	 * meaning 更新时间
	 */
	private String attentionUpdateDate;

	/**
	 * get attention.Attention_id
	 * @return 
	 */
	public String getAttentionId() {
		return this.attentionId;
	}

	/**
	 * set attention.Attention_id
	 * @param 
	 */
	public void setAttentionId(String attentionId) {
		this.attentionId = attentionId;
	}

	/**
	 * get attention.Attention_title
	 * @return 注意事项标题
	 */
	public String getAttentionTitle() {
		return this.attentionTitle;
	}

	/**
	 * set attention.Attention_title
	 * @param 注意事项标题
	 */
	public void setAttentionTitle(String attentionTitle) {
		this.attentionTitle = attentionTitle;
	}

	/**
	 * get attention.Attention_content
	 * @return 注意事项内容html
	 */
	public String getAttentionContent() {
		return this.attentionContent;
	}

	/**
	 * set attention.Attention_content
	 * @param 注意事项内容html
	 */
	public void setAttentionContent(String attentionContent) {
		this.attentionContent = attentionContent;
	}

	/**
	 * get attention.schedule_Treat_Type
	 * @return 预约治疗类型(0：CT，1：体位固定，2：复位  3：放疗)
	 */
	public String getScheduleTreatType() {
		return this.scheduleTreatType;
	}

	/**
	 * set attention.schedule_Treat_Type
	 * @param 预约治疗类型(0：CT，1：体位固定，2：复位  3：放疗)
	 */
	public void setScheduleTreatType(String scheduleTreatType) {
		this.scheduleTreatType = scheduleTreatType;
	}

	/**
	 * get attention.schedule_Treat_Item
	 * @return 预约治疗类型名称
	 */
	public String getScheduleTreatItem() {
		return this.scheduleTreatItem;
	}

	/**
	 * set attention.schedule_Treat_Item
	 * @param 预约治疗类型名称
	 */
	public void setScheduleTreatItem(String scheduleTreatItem) {
		this.scheduleTreatItem = scheduleTreatItem;
	}

	/**
	 * get attention.schedule_Treat_Part
	 * @return 预约治疗部位标识
	 */
	public String getScheduleTreatPart() {
		return this.scheduleTreatPart;
	}

	/**
	 * set attention.schedule_Treat_Part
	 * @param 预约治疗部位标识
	 */
	public void setScheduleTreatPart(String scheduleTreatPart) {
		this.scheduleTreatPart = scheduleTreatPart;
	}

	/**
	 * get attention.schedule_Treat_Part_name
	 * @return 预约治疗部位名称
	 */
	public String getScheduleTreatPartName() {
		return this.scheduleTreatPartName;
	}

	/**
	 * set attention.schedule_Treat_Part_name
	 * @param 预约治疗部位名称
	 */
	public void setScheduleTreatPartName(String scheduleTreatPartName) {
		this.scheduleTreatPartName = scheduleTreatPartName;
	}

	/**
	 * get attention.Attention_type
	 * @return 事项类型(0 注意事项 1办理流程)
	 */
	public String getAttentionType() {
		return this.attentionType;
	}

	/**
	 * set attention.Attention_type
	 * @param 事项类型(0 注意事项 1办理流程)
	 */
	public void setAttentionType(String attentionType) {
		this.attentionType = attentionType;
	}

	/**
	 * get attention.Attention_hosp_id
	 * @return 医院标识
	 */
	public String getAttentionHospId() {
		return this.attentionHospId;
	}

	/**
	 * set attention.Attention_hosp_id
	 * @param 医院标识
	 */
	public void setAttentionHospId(String attentionHospId) {
		this.attentionHospId = attentionHospId;
	}

	/**
	 * get attention.Attention_hosp_name
	 * @return 医院名称
	 */
	public String getAttentionHospName() {
		return this.attentionHospName;
	}

	/**
	 * set attention.Attention_hosp_name
	 * @param 医院名称
	 */
	public void setAttentionHospName(String attentionHospName) {
		this.attentionHospName = attentionHospName;
	}

	/**
	 * get attention.Attention_create_user
	 * @return 创建人
	 */
	public String getAttentionCreateUser() {
		return this.attentionCreateUser;
	}

	/**
	 * set attention.Attention_create_user
	 * @param 创建人
	 */
	public void setAttentionCreateUser(String attentionCreateUser) {
		this.attentionCreateUser = attentionCreateUser;
	}

	/**
	 * get attention.Attention_create_date
	 * @return 创建时间
	 */
	public String getAttentionCreateDate() {
		return this.attentionCreateDate;
	}

	/**
	 * set attention.Attention_create_date
	 * @param 创建时间
	 */
	public void setAttentionCreateDate(String attentionCreateDate) {
		this.attentionCreateDate = attentionCreateDate;
	}

	/**
	 * get attention.Attention_update_user
	 * @return 更新人
	 */
	public String getAttentionUpdateUser() {
		return this.attentionUpdateUser;
	}

	/**
	 * set attention.Attention_update_user
	 * @param 更新人
	 */
	public void setAttentionUpdateUser(String attentionUpdateUser) {
		this.attentionUpdateUser = attentionUpdateUser;
	}

	/**
	 * get attention.Attention_update_date
	 * @return 更新时间
	 */
	public String getAttentionUpdateDate() {
		return this.attentionUpdateDate;
	}

	/**
	 * set attention.Attention_update_date
	 * @param 更新时间
	 */
	public void setAttentionUpdateDate(String attentionUpdateDate) {
		this.attentionUpdateDate = attentionUpdateDate;
	}

	public  Map<String,Object> returnMap()
	{
		 Map<String,Object> returnMap =new HashMap<String,Object>();
		 	returnMap.put("attentionId",this.attentionId);
		 	returnMap.put("attentionTitle",this.attentionTitle);
		 	returnMap.put("attentionContent",this.attentionContent);
		 	returnMap.put("scheduleTreatType",this.scheduleTreatType);
		 	returnMap.put("scheduleTreatItem",this.scheduleTreatItem);
		 	returnMap.put("scheduleTreatPart",this.scheduleTreatPart);
		 	returnMap.put("scheduleTreatPartName",this.scheduleTreatPartName);
		 	returnMap.put("attentionType",this.attentionType);
		 	returnMap.put("attentionHospId",this.attentionHospId);
		 	returnMap.put("attentionHospName",this.attentionHospName);
		 	returnMap.put("attentionCreateUser",this.attentionCreateUser);
		 	returnMap.put("attentionCreateDate",this.attentionCreateDate);
		 	returnMap.put("attentionUpdateUser",this.attentionUpdateUser);
		 	returnMap.put("attentionUpdateDate",this.attentionUpdateDate);
		 return returnMap;
	}
}
