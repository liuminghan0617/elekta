package com.makervt.elekta.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.makervt.core.cache.AppCache;
import com.makervt.core.domain.Page;
import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.util.FileOperateUtil;
import com.makervt.core.web.BaseController;
import com.makervt.elekta.entity.Info;
import com.makervt.elekta.service.InfoService;

@Controller
@RequestMapping(value = "info")
public class InfoApi extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(InfoApi.class);

	@Autowired
	private InfoService infoService;

	@RequestMapping(value = "list.do")
	public @ResponseBody ResponseMessage query(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Info info = this.getJsonJavaByInterceptor(request, Info.class);
		ResponseMessage msg = ResponseMessage.createSuccessResponse("0000");
		if(info!=null)
		{
			info.setInfoDisplay("1");
		}
		else
		{
			info=new Info();
			info.setInfoDisplay("1");
		}
//		logger.info("method:<query> param:<{}>", JSONObject.toJSON(info).toString());
		Page<List> infos= infoService.queryPage(info);
//		logger.info("method:<query> examList:<{}>", JSONObject.toJSON(infos).toString());
		msg.setData("info", infos);
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
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("info.photo.dir") + filePath);

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
		FileOperateUtil.view(request, response, AppCache.serviceConfig.get("info.content.dir") + filePath);

		return null;
	}
	
}
