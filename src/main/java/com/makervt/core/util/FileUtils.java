package com.makervt.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class FileUtils {
	public static final String DOC = "doc";
	public static final String DOCX = "docx";
	public static final String XLS = "xls";
	public static final String XLSX = "xlsx";
	public static final String PPT = "ppt";
	public static final String PPTX = "pptx";
	public static final String PDF = "pdf";
	public static final String TXT = "txt";
	public static final String PNG = "png";
	public static final String TIF = "tif";
	public static final String JPEG = "jpeg";
	public static final String JPG = "jpg";
	public static final String BMP = "bmp";
	public static final String WPS = "wps";
	public static final String WPT = "wpt";
	public static final String ET = "et";
	public static final String ETT = "ett";
	public static final String DPS = "dps";
	public static final String DPT = "dpt";
	private static HashMap<String, String> fileFormat = new HashMap<String, String>();
	private static HashMap<String, String> fileIndex = new HashMap<String, String>();

	static {
		fileFormat.put(DOC, DOC);
		fileFormat.put(DOCX, DOCX);
		fileFormat.put(XLS, XLS);
		fileFormat.put(XLSX, XLSX);
		fileFormat.put(PPT, PPT);
		fileFormat.put(PPTX, PPTX);
		fileFormat.put(PDF, PDF);
		fileFormat.put(TXT, TXT);
		fileFormat.put(PNG, PNG);
		fileFormat.put(TIF, TIF);
		fileFormat.put(JPEG, JPEG);
		fileFormat.put(JPG, JPG);
		fileFormat.put(BMP, BMP);
		fileFormat.put(WPS, WPS);
		fileFormat.put(WPT, WPT);
		fileFormat.put(ET, ET);
		fileFormat.put(ETT, ETT);
		fileFormat.put(DPS, DPS);
		fileFormat.put(DPT, DPT);

		fileIndex.put(DOC, DOC);
		fileIndex.put(DOCX, DOCX);
		fileIndex.put(XLS, XLS);
		fileIndex.put(XLSX, XLSX);
		fileIndex.put(PPT, PPT);
		fileIndex.put(PPTX, PPTX);
		fileIndex.put(PDF, PDF);
		fileIndex.put(TXT, TXT);
		fileIndex.put(WPS, WPS);
		fileIndex.put(WPT, WPT);
		fileIndex.put(ET, ET);
		fileIndex.put(ETT, ETT);
		fileIndex.put(DPS, DPS);
		fileIndex.put(DPT, DPT);
	}

	/**
	 * 根据文件名称去掉文件后缀名后返回
	 * 
	 * @param fileName
	 * @return
	 */
	public static String trimExtension(String fileName) {
		if (fileName != null && fileName.length() > 0) {
			int i = fileName.lastIndexOf('.');
			if (i > -1 && i < fileName.length()) {
				return fileName.substring(0, i);
			}
		}
		return fileName;
	}

	/**
	 * 获得文件名称
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName) {
		if (fileName != null && fileName.length() > 0) {
			int i = fileName.lastIndexOf('/');
			if (i == -1) {
				i = fileName.lastIndexOf('\\');
			}
			if (i > -1 && i < fileName.length()) {
				return fileName.substring(i + 1, fileName.length());
			}
		}

		return fileName;
	}

	/**
	 * 获得文件名称的后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtension(String fileName) {
		if (fileName != null && fileName.length() > 0) {
			int i = fileName.lastIndexOf('.');
			if (i > -1 && i < fileName.length()) {
				return fileName.substring(i + 1, fileName.length());
			}
		}
		return fileName;
	}

	/**
	 * 判断文件是否是系统支持的用于转换的合法文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isVaildFormatFile(String fileName) {
		if (StringUtils.isNotEmpty(fileFormat.get(StringUtils
				.lowerCase(getExtension(fileName)))))
			return true;
		else
			return false;
	}

	/**
	 * 判断文件是否是系统支持的用于创建索引的合法文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isVaildIndexFile(String fileName) {
		if (StringUtils.isNotEmpty(fileIndex.get(StringUtils
				.lowerCase(getExtension(fileName)))))
			return true;
		else
			return false;
	}


	public static File renameFileFromChinese(File file) {
		String fileName = file.getName();
		String extension = getExtension(fileName);
		String destFileName = fileName.substring(0,
				fileName.lastIndexOf(File.separator) + 1)
				+ System.currentTimeMillis() + extension;
		File destFile = new File(destFileName);
		file.renameTo(destFile);
		return destFile;
	}

	public static boolean isImag(String fileExtension) {
		if (StringUtils.equalsIgnoreCase(fileExtension, BMP)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, JPEG)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, JPG)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, PNG)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, TIF)) {
			return true;
		}

		return false;
	}

	public static boolean isJpg(String fileExtension) {
		if (StringUtils.equalsIgnoreCase(fileExtension, JPG)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, JPEG)) {
			return true;
		}
		return false;
	}

	public static boolean isWps(String fileExtension) {
		if (StringUtils.equalsIgnoreCase(fileExtension, WPS)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, WPT)) {
			return true;
		}
		return false;
	}

	public static boolean isEt(String fileExtension) {
		if (StringUtils.equalsIgnoreCase(fileExtension, ET)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, ETT)) {
			return true;
		}
		return false;
	}

	public static boolean isDps(String fileExtension) {
		if (StringUtils.equalsIgnoreCase(fileExtension, DPS)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, DPT)) {
			return true;
		}
		return false;
	}

	public static boolean isOffice(String fileExtension) {
		if (StringUtils.equalsIgnoreCase(fileExtension, DOC)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, DOCX)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, PPT)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, PPTX)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, XLS)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, XLSX)) {
			return true;
		} else if (StringUtils.equalsIgnoreCase(fileExtension, TXT)) {
			return true;
		}
		return false;
	}

	public static boolean isPdf(String fileExtension) {
		if (StringUtils.equalsIgnoreCase(fileExtension, PDF)) {
			return true;
		}
		return false;
	}

	
	public static File createFile(String absoluteFilePath) {
		File file = new File(absoluteFilePath);
		file.setReadable(true, false);
		file.setWritable(true, false);
		file.setExecutable(true, false);
		return file;
	}

	/**
	 * 检测txt文本文件编码格式 说明：检查txt文本文件编码，包括有bom头的utf各类编码，无bom头的utf8的编码，默认为gb2312编码
	 * 2014-6-26 18:31:12
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String detectTextFileCharset(File file) throws IOException {
		int bomSize = 4;
		byte[] bom = new byte[bomSize];
		bomSize = readFile(file, bomSize, bom);
		String encoding;
		if (bomSize >= 4) {
			if ((bom[0] == (byte) 0x00) && (bom[1] == (byte) 0x00)
					&& (bom[2] == (byte) 0xFE) && (bom[3] == (byte) 0xFF)) {
				encoding = "UTF-32BE";
			} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE)
					&& (bom[2] == (byte) 0x00) && (bom[3] == (byte) 0x00)) {
				encoding = "UTF-32LE";
			} else if ((bom[0] == (byte) 0xEF) && (bom[1] == (byte) 0xBB)
					&& (bom[2] == (byte) 0xBF)) {
				encoding = "UTF-8";
			} else if ((bom[0] == (byte) 0xFE) && (bom[1] == (byte) 0xFF)) {
				encoding = "UTF-16BE";
			} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE)) {
				encoding = "UTF-16LE";
			} else {
				encoding = detectFileNoBomCharset(file);
			}
		} else {
			// 作为无bom处理
			encoding = detectFileNoBomCharset(file);
		}
		return encoding;
	}

	/**
	 * 检查无bom头的文本文件编码 说明：目前只处理utf8编码，默认为gb2312
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String detectFileNoBomCharset(File file) throws IOException {
		if (isUTF8NoBom(file)) {
			return "UTF-8";
		} else {
			return "gb2312"; // 默认为gb2312
		}
	}

	/****
	 * 
	 * 只处理无bom的utf8判断 说明：要求文件时无bom头； 只处理了汉字在4内的即00000000-001FFFFF 内的汉字；
	 * 全部都是ansi返回utf8编码；
	 * 
	 * @param file
	 * @return 如果ture为utf8，否则为其他编码
	 * @throws IOException
	 */
	public static boolean isUTF8NoBom(File file) throws IOException {
		byte[] bytes = new byte[100]; // TODO 待处理，如果文件小全部处理，如果大文件待考虑
		int fileLength = readFile(file, 100, bytes);
		// System.err.println(Integer.toHexString(bytes[0]&0xff)+","+Integer.toHexString(bytes[1]&0xff)+","+Integer.toHexString(bytes[2]&0xff)+","+Integer.toHexString(bytes[3]&0xff));
		int i = 0;
		int step = 0;
		for (i = 0; i < fileLength; i++) {
			step = 0;
			if ((bytes[i] & 0x80) == 0x00) { // ansi不做判断，如果全纯粹的ansi，返回utf8
				step = 0;
			} else if ((bytes[i] & 0xe0) == 0xc0) { // 两个字节
				if (i + 1 >= fileLength)
					return false;
				if ((bytes[i + 1] & 0xc0) != 0x80)
					return false;
				step = 1;
			} else if ((bytes[i] & 0xf0) == 0xe0) { // 三个字节
				if (i + 2 >= fileLength)
					return false;
				if ((bytes[i + 1] & 0xc0) != 0x80)
					return false;
				if ((bytes[i + 2] & 0xc0) != 0x80)
					return false;
				step = 2;
			} else if ((bytes[i] & 0xf8) == 0xf0) { // 四个字节
				if (i + 3 >= fileLength)
					return false;
				if ((bytes[i + 1] & 0xc0) != 0x80)
					return false;
				if ((bytes[i + 2] & 0xc0) != 0x80)
					return false;
				if ((bytes[i + 3] & 0xc0) != 0x80)
					return false;
				step = 3;
			} else { // TODO 待五个字节、六个字节处理
				return false;
			}
			i += step;
		}
		if (i >= fileLength)
			return true;
		return false;
	}

	/**
	 * 检测txt文本文件编码格式 说明：检查txt文本文件编码，包括有bom头的utf各类编码，无bom头的utf8的编码，默认为gb2312编码
	 * 2014-6-26 18:31:12
	 * 
	 * @param in
	 *            需要支持mark和reset，可以使用BufferInputStream
	 * @return
	 * @throws IOException
	 */
	public static String detectTextFileCharset(InputStream in)
			throws IOException {
		int bomSize = 4;
		byte[] bom = new byte[bomSize];
		in.mark(bomSize);
		bomSize = in.read(bom, 0, bomSize);
		in.reset();
		String encoding;
		if (bomSize >= 4) {
			if ((bom[0] == (byte) 0x00) && (bom[1] == (byte) 0x00)
					&& (bom[2] == (byte) 0xFE) && (bom[3] == (byte) 0xFF)) {
				encoding = "UTF-32BE";
			} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE)
					&& (bom[2] == (byte) 0x00) && (bom[3] == (byte) 0x00)) {
				encoding = "UTF-32LE";
			} else if ((bom[0] == (byte) 0xEF) && (bom[1] == (byte) 0xBB)
					&& (bom[2] == (byte) 0xBF)) {
				encoding = "UTF-8";
			} else if ((bom[0] == (byte) 0xFE) && (bom[1] == (byte) 0xFF)) {
				encoding = "UTF-16BE";
			} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE)) {
				encoding = "UTF-16LE";
			} else {

				encoding = detectFileNoBomCharset(in);
			}
		} else {
			// 作为无bom处理
			encoding = detectFileNoBomCharset(in);
		}
		return encoding;
	}

	/**
	 * 检查无bom头的文本文件编码 说明：目前只处理utf8编码，默认为gb2312
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String detectFileNoBomCharset(InputStream in)
			throws IOException {
		if (isUTF8NoBom(in)) {
			return "UTF-8";
		} else {
			return "gb2312"; // 默认为gb2312
		}
	}

	/****
	 * 
	 * 只处理无bom的utf8判断 说明：要求文件时无bom头； 只处理了汉字在4内的即00000000-001FFFFF 内的汉字；
	 * 全部都是ansi返回utf8编码；
	 * 
	 * @param file
	 * @return 如果ture为utf8，否则为其他编码
	 * @throws IOException
	 */
	public static boolean isUTF8NoBom(InputStream in) throws IOException {
		byte[] bytes = new byte[100]; // TODO 待处理，如果文件小全部处理，如果大文件待考虑
		int fileLength = in.read(bytes, 0, 100);
		// System.err.println(Integer.toHexString(bytes[0]&0xff)+","+Integer.toHexString(bytes[1]&0xff)+","+Integer.toHexString(bytes[2]&0xff)+","+Integer.toHexString(bytes[3]&0xff));
		int i = 0;
		int step = 0;
		for (i = 0; i < fileLength; i++) {
			step = 0;
			if ((bytes[i] & 0x80) == 0x00) { // ansi不做判断，如果全纯粹的ansi，返回utf8
				step = 0;
			} else if ((bytes[i] & 0xe0) == 0xc0) { // 两个字节
				if (i + 1 >= fileLength)
					return false;
				if ((bytes[i + 1] & 0xc0) != 0x80)
					return false;
				step = 1;
			} else if ((bytes[i] & 0xf0) == 0xe0) { // 三个字节
				if (i + 2 >= fileLength)
					return false;
				if ((bytes[i + 1] & 0xc0) != 0x80)
					return false;
				if ((bytes[i + 2] & 0xc0) != 0x80)
					return false;
				step = 2;
			} else if ((bytes[i] & 0xf8) == 0xf0) { // 四个字节
				if (i + 3 >= fileLength)
					return false;
				if ((bytes[i + 1] & 0xc0) != 0x80)
					return false;
				if ((bytes[i + 2] & 0xc0) != 0x80)
					return false;
				if ((bytes[i + 3] & 0xc0) != 0x80)
					return false;
				step = 3;
			} else { // TODO 待五个字节、六个字节处理
				return false;
			}
			i += step;
		}
		if (i >= fileLength)
			return true;
		return false;
	}

	public static int readFile(File f, int fetchLength, byte[] bytes)
			throws IOException {
		InputStream fileStream = new FileInputStream(f);
		fetchLength = fileStream.read(bytes, 0, bytes.length);
		fileStream.close();
		return fetchLength;
	}

	

	public static void mkDir(File dir) throws Exception {
		if (dir == null) {
			throw new Exception("文件夹对象为null");
		}
		if (dir.isFile()) {
			throw new Exception("该文件夹已经存在");
		}
		if (!(dir.exists())) {
			boolean result = doMkDirs(dir);
			if (!(result)) {
				String msg = "Directory " + dir.getAbsolutePath()
						+ " 未知原因造成文件夹创建失败";
				throw new RuntimeException(msg);
			}
		}
	}

	private static boolean doMkDirs(File f) {
		if (!(f.mkdirs())) {
			try {
				Thread.sleep(10L);
				return f.mkdirs();
			} catch (InterruptedException ex) {
				return f.mkdirs();
			}
		}
		return true;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getContent(String path, String charset)
			throws Exception {
		File file = new File(path);
		StringBuffer buffer = new StringBuffer();
		if (file != null && file.exists()) {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), charset));
			String line = null;
			while ((line = in.readLine()) != null) {
				buffer.append(line.trim());
			}
			if (in != null) {
				in.close();
			}
		}
		return buffer.toString();
	}

	public static Charset detectFileBomCharset(File fileName)
			throws IOException {
		URI uri = fileName.toURI();
		BufferedInputStream is = new BufferedInputStream(uri.toURL()
				.openStream());
		// InputStream is = new FileInputStream(fileName);
		byte[] bom = new byte[4];
		is.read(bom, 0, 4);
		is.close();
		System.out.println("文件头:" + bom[0] + "," + bom[1] + "," + bom[2] + ","
				+ bom[3]);
		if ((bom[0] == 0) && (bom[1] == 0) && (bom[2] == -2) && (bom[2] == -1)) {
			return Charset.forName("UTF-32BE");
		} else if ((bom[0] == -1) && (bom[1] == -2) && (bom[2] == 0)
				&& (bom[2] == 0)) {
			return Charset.forName("UTF-32LE");
		} else if ((bom[0] == -17) && (bom[1] == -69) && (bom[2] == -65)) {
			return Charset.forName("UTF-8");
		} else if ((bom[0] == -1) && (bom[1] == -2)) {
			return Charset.forName("UTF-16LE");
		} else if ((bom[0] == -2) && (bom[1] == -1)) {
			return Charset.forName("UTF-16BE");
		} else if ((bom[0] == 0) && (bom[1] == 0) && (bom[2] == -2)
				&& (bom[3] == -1)) {
			return Charset.forName("UCS-4");
		} else {
			return Charset.forName("gb2312");
		}
	}
}
