package com.makervt.core.util;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class EncrypCoder {
	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";
	public static final String KEY_ALGORITHM_AES = "AES";
	public static final String CIPHER_ALGORITHM_AES = "AES/CFB/NOPADDING";//AES/ECB/PKCS5Padding
	public static final String KEY_ALGORITHM_DES = "DES";
	public static final String CIPHER_ALGORITHM_DES = "DES/ECB/PKCS5Padding";
	public static final String KEY_ALGORITHM_3DES = "DESede";
	public static final String CIPHER_ALGORITHM3_DES = "DESede/ECB/PKCS5Padding";
	public static final String CIPHER_KEY="MakerVT";
	public static final String CHARSET="utf-8";
	private static  Logger logger = LoggerFactory.getLogger(EncrypCoder.class);
	
	
	/**
	 * MAC算法可选以下多种算法
	 * 
	 * <pre>
	 * HmacMD5  
	 * HmacSHA1  
	 * HmacSHA256  
	 * HmacSHA384  
	 * HmacSHA512
	 * </pre>
	 */
	public static final String KEY_MAC = "HmacMD5";

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.decodeBase64(key.getBytes());
	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return new String(Base64.encodeBase64(key));
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		byte[] md5Bytes=md5.digest();
		return md5Bytes;

	}
	
	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String  encryptMD5Hex(String source) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(source.getBytes(CHARSET));
		byte[] md5Bytes=md5.digest();
		return Hex.encodeHexString(md5Bytes);

	}

	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {

		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);

		return sha.digest();

	}

	/**
	 * 初始化HMAC密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}

	public static byte[] decryptAES(byte[] data,String password) throws Exception {
        byte[] enCodePassword =  GeneralKey(password); 
        byte[] ivByte = GeneralIv(password);
        SecretKeySpec key = new SecretKeySpec(enCodePassword,KEY_ALGORITHM_AES);              
        IvParameterSpec iv = new IvParameterSpec(ivByte);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_AES);// 创建密码器  
       cipher.init(Cipher.DECRYPT_MODE, key,iv);// 初始化  
       byte[] result = cipher.doFinal(data);
       return result; 
	}
	
	public static byte[] encryptAES(byte[] data,String password) throws Exception
			  {
		 byte[] enCodePassword =  GeneralKey(password); 
	       byte[] ivByte = GeneralIv(password);
	       IvParameterSpec iv = new IvParameterSpec(ivByte);
         SecretKeySpec key = new SecretKeySpec(enCodePassword, KEY_ALGORITHM_AES);  
         Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_AES);// 创建密码器  
         cipher.init(Cipher.ENCRYPT_MODE, key,iv);// 初始化  
         byte[] result = cipher.doFinal(data);  
         return result; // 加密  
	}
	
	/**
	   * 构建密钥字节码
	   * 
	   * @param keyStr
	   * @return
	   * @throws Exception
	   */
	  private static byte[] GeneralKey(String keyStr) throws Exception {
	    byte[] bytes = keyStr.getBytes(CHARSET);
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(bytes);
	    return md.digest();
	  }
	
	/**
	   * 构建加解密向量字节码
	   * 
	   * @param keyStr
	   * @return
	   * @throws Exception
	   */
	  private static byte[] GeneralIv(String keyStr) throws Exception {
	    byte[] bytes = keyStr.getBytes(CHARSET);
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(bytes);
	    return md.digest();
	  }
	
	public static String enCodePassWord(String code) throws Exception {
		byte[] md5 = encryptMD5(code.getBytes(CHARSET));
		String ciphertext = encryptBASE64(md5);
		return ciphertext;
	}
	
	public static String enCodeToken(String code) throws Exception {
		byte[] aes=EncrypCoder.encryptAES(code.getBytes(CHARSET),CIPHER_KEY);
		String ciphertext = EncrypCoder.encryptBASE64(aes);
		return ciphertext;
	}
	
	public static String deCodeToken(String code) throws Exception {
		String decryptText=new String(EncrypCoder.decryptAES(EncrypCoder.decryptBASE64(code),CIPHER_KEY));
		return decryptText;
	}
	
	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	public static String sign(SortedMap<String, String> paramMap) {
		StringBuffer sb = new StringBuffer();
		if(null!=paramMap)
		{
			Set es = paramMap.entrySet();
			Iterator it = es.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String k = (String) entry.getKey();
				String v = (String) entry.getValue();
				if (StringUtils.isNotEmpty(v) && !StringUtils.equalsIgnoreCase("sign", k)) {
					sb.append(k + ":" + v + ",");
				}
			}
		}
		sb.append("key:" + CIPHER_KEY);
		String sign=null;
		try {
			sign = encryptMD5Hex(sb.toString())
					.toUpperCase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("需要签名的字符串:"+sb.toString());
		logger.debug("签名结果:"+sign);
		return sign;

	}
	
	/**验证签名
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	public static boolean verfitySign(SortedMap<String, String> paramMap, String verfitySign) {
		String sign = sign(paramMap);
		logger.info("接收到的签名:" + verfitySign + " 计算出来的签名:" + sign);
		return StringUtils.equalsIgnoreCase(verfitySign, sign);
	}
	
	public static void main(String[] arge) {
		Map<String, Object> mapToken = new HashMap<String, Object>();
		mapToken.put("userCode", "13810034000");
		mapToken.put("userId", "1");
		mapToken.put("var", "18");
		String password="jimmyjimmy";
		String str = JSON.toJSONString(mapToken);
		String keyStr=CIPHER_KEY;
		try {
			byte[] aes=EncrypCoder.encryptAES(str.getBytes(CHARSET),keyStr);
			String base64 = EncrypCoder.encryptBASE64(aes);
			String ciphertextAes=new String(aes);
			String decrypt=new String(EncrypCoder.decryptAES(EncrypCoder.decryptBASE64(base64),keyStr));
			String enCodeToken=enCodeToken(str) ;
			String deCodeToken=deCodeToken(enCodeToken) ;
			String enCodePassWord=enCodePassWord(password);
			System.out.println("明文:"+password+" 密文:"+enCodePassWord);
			//HexUtils.debugHex(logger,EncrypCoder.encryptMD5(password.getBytes()),"utf-8");
			System.out.println("enCodePassWord:"+enCodePassWord);
			System.out.println("enCodeToken:"+enCodeToken);
			System.out.println("deCodeToken:"+deCodeToken);
			System.out.println("md5Password:"+encryptMD5Hex(password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
