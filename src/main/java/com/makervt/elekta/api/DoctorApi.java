package com.makervt.elekta.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.entity.Doctor;
import com.makervt.elekta.entity.DoctorPraise;
import com.makervt.elekta.entity.Question;
import com.makervt.elekta.service.DoctorPraiseService;
import com.makervt.elekta.service.DoctorService;

@Controller
@RequestMapping(value = "doctor")
public class DoctorApi extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(DoctorApi.class);

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorPraiseService doctorPraiseService;
	
	@RequestMapping(value = "query.do")
	public @ResponseBody ResponseMessage query(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Doctor doctor = this.getJsonJavaByInterceptor(request, Doctor.class);
		
		if (StringUtils.isEmpty(doctor.getUserId()))
			return ResponseMessage.createErrorResponse("1101");
		
		if (!this.isVerfityUser(request, doctor.getUserId()))
			return ResponseMessage.createErrorResponse("1106");
		
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		doctor = doctorService.queryDoctor(doctor);
		
		if(null==doctor||StringUtils.isEmpty(doctor.getDoctorId()))
			return ResponseMessage.createErrorResponse("1125");
		
		msg.setData("doctor", doctor);
		return msg;
	}
	
	@RequestMapping(value = "praise.do")
	public @ResponseBody ResponseMessage praise(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DoctorPraise doctorPraise = this.getJsonJavaByInterceptor(request, DoctorPraise.class);
		
		if (StringUtils.isEmpty(doctorPraise.getUserId()))
			return ResponseMessage.createErrorResponse("1101");
		
		if (StringUtils.isEmpty(doctorPraise.getDoctorId()))
			return ResponseMessage.createErrorResponse("1108");
		
		if (!this.isVerfityUser(request, doctorPraise.getUserId()))
			return ResponseMessage.createErrorResponse("1106");
		ResponseMessage msg = doctorPraiseService.createPraise(doctorPraise);
			
		return msg;
	}
	
	@RequestMapping(value = "isPraise.do")
	public @ResponseBody ResponseMessage isPraise(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DoctorPraise doctorPraise = this.getJsonJavaByInterceptor(request, DoctorPraise.class);
		
		if (StringUtils.isEmpty(doctorPraise.getUserId()))
			return ResponseMessage.createErrorResponse("1101");
		
		if (StringUtils.isEmpty(doctorPraise.getDoctorId()))
			return ResponseMessage.createErrorResponse("1108");
		
		if (!this.isVerfityUser(request, doctorPraise.getUserId()))
			return ResponseMessage.createErrorResponse("1106");
		ResponseMessage msg = doctorPraiseService.isPraise(doctorPraise);
			
		return msg;
	}
	
	/**
	 * 显示图片
	 * 
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "image.do")
	public ModelAndView showImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = request.getParameter("filePath");
		// 返回图片显示
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("doctor.photo.dir") + filePath);

		return null;
	}
	
	/**
	 * 显示图片
	 * 
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "imageContent.do")
	public ModelAndView imageContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filePath = request.getParameter("filePath");
		// 返回图片显示
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("doctor.content.dir") + filePath);

		return null;
	}
}
