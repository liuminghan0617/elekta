package com.makervt.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.makervt.core.domain.ResponseMessage;

import eu.medsea.mimeutil.MimeUtil;

/**
 * 
 * @author geloin
 * @date 2012-5-5 下午12:05:57
 */
public class FileOperateUtil {
	private static final String UPLOADDIR = "/WEB-INF/uploadDir/";
	private static final String DEFAULT_ERROR_FILE = "/images/error.jpg";
	private static Logger logger = LoggerFactory
			.getLogger(FileOperateUtil.class);

	/**
	 * 将上传的文件进行重命名
	 * 
	 * @author geloin
	 * @date 2012-3-29 下午3:39:53
	 * @param name
	 * @return
	 */
	public static String rename(String name) {

		Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date()));
		Long random = (long) (Math.random() * now);
		String fileName = now + "" + random+"elekta";

		if (name.indexOf(".") != -1) {
			fileName += name.substring(name.lastIndexOf("."));
		}

		return fileName;
	}

	public static String zipName(String name) {
		String prefix = "";
		if (name.indexOf(".") != -1) {
			prefix = name.substring(0, name.lastIndexOf("."));
		} else {
			prefix = name;
		}
		return prefix + ".zip";
	}

	public static ResponseMessage handleUpload(HttpServletRequest request,
			String uploadDir, boolean isZip, String[] params,
			Map<String, Object[]> values) throws Exception {
		ResponseMessage responseMessage = ResponseMessage
				.createSuccessResponse("0000");
	

		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mRequest.getFileMap();
		if (fileMap == null || fileMap.keySet().size() == 0) {
			return responseMessage;
		}
		if (StringUtils.isEmpty(uploadDir))
			uploadDir = request.getSession().getServletContext()
					.getRealPath("/")
					+ FileOperateUtil.UPLOADDIR;

		File file = new File(uploadDir);

		if (!file.exists()) {
			file.mkdir();
		}

		String fileName = null;
		int i = 0;
		for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()
				.iterator(); it.hasNext(); i++) {

			Map.Entry<String, MultipartFile> entry = it.next();
			MultipartFile mFile = entry.getValue();
			fileName = mFile.getName();
			if (!fileName.equals("")) {
				String storeName = rename(fileName);

				String noZipName = uploadDir + storeName;
				Map<String, Object> map = new HashMap<String, Object>();
				if (isZip) {
					String zipName = zipName(noZipName);
					// 上传成为压缩文件
					ZipOutputStream outputStream = new ZipOutputStream(
							new BufferedOutputStream(new FileOutputStream(
									zipName)));
					outputStream.putNextEntry(new ZipEntry(fileName));
					// outputStream.setEncoding("GBK");

					FileCopyUtils.copy(mFile.getInputStream(), outputStream);
					map.put("压缩后文件名称", zipName(storeName));
					map.put("压缩后大小", new File(zipName).length());
					map.put("压缩后格式", "zip");
				} else {
					mFile.transferTo(new File(noZipName));
				}

				// 固定参数值对
				map.put("type", "SUCCESS");
				map.put("path", uploadDir);
				map.put("old", fileName);
				map.put("name", storeName);
				map.put("size", mFile.getSize());
				// 自定义参数值对
				if(null!=params)
				{
					for (String param : params) {
						map.put(param, values.get(param)[i]);
					}
				}

				responseMessage.setData("file"+i, map);
			}
		}
		return responseMessage;
	}

	public static void download(HttpServletRequest request,
			HttpServletResponse response, String path, String storeName,
			String contentType, String realName) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		String ctxPath = path;
		if (StringUtils.isEmpty(path))
			ctxPath = request.getSession().getServletContext().getRealPath("/")
					+ FileOperateUtil.UPLOADDIR;
		String downLoadPath = ctxPath + storeName;

		long fileLength = new File(downLoadPath).length();

		response.setContentType(contentType);
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(realName.getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));

		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}

	public static void view(HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		String defaultFilePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ FileOperateUtil.DEFAULT_ERROR_FILE;
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		long fileLength = new File(path).length();
		if (fileLength == 0) {
			path = defaultFilePath;
			fileLength = new File(path).length();
		}
		response.setContentType("image/jpeg");
		response.setHeader("Content-Disposition", "inline");
		response.setHeader("Content-Length", String.valueOf(fileLength));

		try {
			bis = new BufferedInputStream(new FileInputStream(path));

			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			bis.close();
			bos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public static void voice(HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		String defaultFilePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ FileOperateUtil.DEFAULT_ERROR_FILE;
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		long fileLength = new File(path).length();
		if (fileLength == 0) {
			path = defaultFilePath;
			fileLength = new File(path).length();
		}
		response.setContentType("audio/*");
		 response.setHeader("Content-Disposition", "attachment; filename="+FileUtils.getFileName(path));
		response.setHeader("Content-Length", String.valueOf(fileLength));

		try {
			bis = new BufferedInputStream(new FileInputStream(path));

			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			bis.close();
			bos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public static boolean isImage(String fileName)
	{
		MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.ExtensionMimeDetector");
		Collection<?> mimeTypes=MimeUtil.getMimeTypes(fileName);
		if(StringUtils.contains(mimeTypes.toString(),"image"))
			return true;
		
		return false;
	}
	
	public static boolean isVoice(String fileName)
	{
		MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.ExtensionMimeDetector");
		Collection<?> mimeTypes=MimeUtil.getMimeTypes(fileName);
		if(StringUtils.contains(mimeTypes.toString(),"audio"))
			return true;
		
		return false;
	}
	
	
	public static void  main(String [] arges)
	{
		MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.ExtensionMimeDetector");
		String fileName="儿童歌曲-咱们从小讲礼貌.wav";  
	        Collection<?> mimeTypes = MimeUtil.getMimeTypes(fileName);
	        
	        System.out.println(isVoice(fileName)); 
	}

}