package com.makervt.core.util;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;

public class HexUtils {
	private static final int CHARS_PER_LINE = 32;

	public static void debugHex(Logger logger, byte[] inputByte, String encoding) {
		debugHex(logger, null, inputByte, encoding);
	}

	public static void debugHex(Logger logger, String message, byte[] inputByte, String encoding) {
		if (logger.isDebugEnabled())
			try {
				logger.debug(toHex(message, inputByte, encoding));
			} catch (Exception e) {
				logger.warn("打印HEX失败", e);
			}
	}

	public static String toHex(String message, byte[] inputByte, String encoding) {
		StringBuffer printStr = new StringBuffer();
		StringBuffer tempStr = new StringBuffer();
		if (message != null)
			printStr.append(message);
		printStr.append("\n================================================ HEX Start =========== ");
		printStr.append(encoding).append(" ===========").append('\n');
		int chineseLength = getChineseLength(encoding);
		int chineseByteCount = 0;
		int badChineseByteCount = 0;
		for (int i = 0; i < inputByte.length; i++) {
			String temp = Integer.toHexString(inputByte[i] & 0xff) + " ";
			if (temp.length() == 2)
				temp = "0" + temp;
			printStr.append(temp);
			if ((inputByte[i] & 0xff) > 0x20 && (inputByte[i] & 0xff) < 0x80) {
				tempStr.append((char) inputByte[i]);
			} else if ((inputByte[i] & 0xff) <= 0x20) {
				tempStr.append(".");
			} else if (chineseLength < 2) {
				tempStr.append("?");
			} else {
				chineseByteCount++;
				if (chineseByteCount == chineseLength)
					chineseByteCount = 0;
				if (chineseByteCount == 1) {
					if (i % CHARS_PER_LINE < CHARS_PER_LINE - chineseLength) {
						byte[] chineseBytes = new byte[chineseLength];
						System.arraycopy(inputByte, i, chineseBytes, 0, chineseLength);
						try {
							tempStr.append(new String(chineseBytes, encoding));
						} catch (UnsupportedEncodingException e) {
							tempStr.append(new String(chineseBytes));
						}
						for (int j = 0; j < chineseLength - 2; j++) {
							tempStr.append(".");
						}
					} else {
						badChineseByteCount++;
						tempStr.append("?");
					}
				} else {
					if (badChineseByteCount > 0) {
						badChineseByteCount++;
						tempStr.append("?");
					}
					if (badChineseByteCount == chineseLength)
						badChineseByteCount = 0;
				}
			}
			if (i > 0 && i % CHARS_PER_LINE == CHARS_PER_LINE - 1) {
				printStr.append(" -->  ");
				printStr.append(tempStr + "\n");
				tempStr = new StringBuffer();
			} else if (i == inputByte.length - 1 && i % CHARS_PER_LINE != CHARS_PER_LINE - 1) {
				for (int j = 0; j < (CHARS_PER_LINE - i % CHARS_PER_LINE - 1) * 3; j++)
					printStr.append(" ");
				printStr.append(" -->  ");
				printStr.append(tempStr + "\n");
			}
		}
		printStr.append("================================================ HEX End   =========== ");
		printStr.append(encoding).append(" ===========");

		return printStr.toString();
	}

	private static int getChineseLength(String encoding) {
		try {
			return "汉".getBytes(encoding).length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return 1;
		}
	}

}
