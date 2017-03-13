package com.makervt.core.component.push;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.collect.Maps;
import com.makervt.core.component.push.android.AndroidBroadcast;
import com.makervt.core.component.push.android.AndroidCustomizedcast;
import com.makervt.core.component.push.android.AndroidFilecast;
import com.makervt.core.component.push.android.AndroidGroupcast;
import com.makervt.core.component.push.android.AndroidUnicast;
import com.makervt.core.component.push.ios.IOSBroadcast;
import com.makervt.core.component.push.ios.IOSCustomizedcast;
import com.makervt.core.component.push.ios.IOSFilecast;
import com.makervt.core.component.push.ios.IOSGroupcast;
import com.makervt.core.component.push.ios.IOSUnicast;

public class UmengComponent {
	private final String  APPKEY_ANDROID = "568e24b4e0f55a81d800259d";
	private final String  APPKEY_IOS = "568e24f0e0f55af0fd0002c0";
	private String appMasterSecret_IOS = "ksswt2vg2qwota39wlewert5p6jbdz0x";
	private String appMasterSecret_ANDROID = "hp3o526yr0xjx3twzflri5axyp4vgpug";
	private String timestamp = null;
	private PushClient client = new PushClient();
	
	
	public void sendAndroidBroadcast(String ticker, String title,String text,Map<String,String> fields) throws Exception {
		AndroidBroadcast broadcast = new AndroidBroadcast(APPKEY_ANDROID,appMasterSecret_ANDROID);
		broadcast.setTicker(ticker);
		broadcast.setTitle(title);
		broadcast.setText(text);
		broadcast.goCustomAfterOpen("");;
		broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		broadcast.setProductionMode(true);
		//broadcast.setTestMode();
		if (null != fields) {
			for (String key : fields.keySet()) {
				broadcast.setExtraField(key, fields.get(key));
			}
		}
		client.send(broadcast);
	}
	
	public void sendAndroidUnicast(String deviceToken,String ticker, String title,String text,Map<String,String> fields) throws Exception {
		AndroidUnicast unicast = new AndroidUnicast(APPKEY_ANDROID,appMasterSecret_ANDROID);
		// TODO Set your device token
		unicast.setDeviceToken( deviceToken);
		unicast.setTicker( ticker);
		unicast.setTitle( title);
		unicast.setText( text);
		unicast.goCustomAfterOpen("");
		unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		unicast.setProductionMode(true);
		//unicast.setTestMode();
		// Set customized fields
		if (null != fields) {
			for (String key : fields.keySet()) {
				unicast.setExtraField(key, fields.get(key));
			}
		}
		client.send(unicast);
	}
	
	public void sendAndroidGroupcast(String ticker, String title,String text) throws Exception {
		AndroidGroupcast groupcast = new AndroidGroupcast(APPKEY_ANDROID,appMasterSecret_ANDROID);
		/*  TODO
		 *  Construct the filter condition:
		 *  "where": 
		 *	{
    	 *		"and": 
    	 *		[
      	 *			{"tag":"test"},
      	 *			{"tag":"Test"}
    	 *		]
		 *	}
		 */
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		JSONObject testTag = new JSONObject();
		JSONObject TestTag = new JSONObject();
		testTag.put("tag", "test");
		TestTag.put("tag", "Test");
		tagArray.put(testTag);
		tagArray.put(TestTag);
		whereJson.put("and", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());
		
		groupcast.setFilter(filterJson);
		groupcast.setTicker( ticker);
		groupcast.setTitle( title);
		groupcast.setText(text);
		groupcast.goCustomAfterOpen("");
		groupcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		groupcast.setProductionMode(true);
		client.send(groupcast);
	}
	
	public void sendAndroidCustomizedcast(String alias,String aliasType, String ticker, String title,String text) throws Exception {
		AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(APPKEY_ANDROID,appMasterSecret_ANDROID);
		// TODO Set your alias here, and use comma to split them if there are multiple alias.
		// And if you have many alias, you can also upload a file containing these alias, then 
		// use file_id to send customized notification.
		customizedcast.setAlias(alias, aliasType);
		customizedcast.setTicker( ticker);
		customizedcast.setTitle( title);
		customizedcast.setText(text);
		customizedcast.goCustomAfterOpen("");
		customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		customizedcast.setProductionMode(true);
		//customizedcast.setTestMode();
		client.send(customizedcast);
	}
	
	public void sendAndroidCustomizedcastFile(String aliasType, String ticker, String title,String text,String uploadContents) throws Exception {
		AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(APPKEY_ANDROID,appMasterSecret_ANDROID);
		// TODO Set your alias here, and use comma to split them if there are multiple alias.
		// And if you have many alias, you can also upload a file containing these alias, then 
		// use file_id to send customized notification.
		String fileId = client.uploadContents(APPKEY_ANDROID,appMasterSecret_ANDROID,"aa"+"\n"+"bb"+"\n"+"alias");
		customizedcast.setFileId(fileId, aliasType);
		customizedcast.setTicker( ticker);
		customizedcast.setTitle( title);
		customizedcast.setText(  text);
		customizedcast.goCustomAfterOpen("");
		customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		customizedcast.setProductionMode(true);
		//customizedcast.setTestMode();
		client.send(customizedcast);
	}
	
	public void sendAndroidFilecast(String ticker, String title,String text,String uploadContents) throws Exception {
		AndroidFilecast filecast = new AndroidFilecast(APPKEY_ANDROID,appMasterSecret_ANDROID);
		// TODO upload your device tokens, and use '\n' to split them if there are multiple tokens 
		String fileId = client.uploadContents(APPKEY_ANDROID,appMasterSecret_ANDROID,"aa"+"\n"+"bb");
		filecast.setFileId( fileId);
		filecast.setTicker(ticker);
		filecast.setTitle( title);
		filecast.setText( text);
		filecast.goCustomAfterOpen("");
		filecast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		filecast.setProductionMode(true);
		client.send(filecast);
	}
	
	public void sendIOSBroadcast(String text,Map<String,String> fields) throws Exception {
		IOSBroadcast broadcast = new IOSBroadcast(APPKEY_IOS,appMasterSecret_IOS);

		broadcast.setAlert(text);
		broadcast.setBadge(1);
		broadcast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		//broadcast.setTestMode();
		broadcast.setProductionMode(true);
		// Set customized fields
		if (null != fields) {
			for (String key : fields.keySet()) {
				broadcast.setCustomizedField(key, fields.get(key));
			}
		}
		client.send(broadcast);
	}
	
	public void sendIOSUnicast(String deviceToken,String text,Map<String,String> fields) throws Exception {
		IOSUnicast unicast = new IOSUnicast(APPKEY_IOS,appMasterSecret_IOS);
		// TODO Set your device token
		unicast.setDeviceToken( deviceToken);
		unicast.setAlert(text);
		unicast.setBadge(1);
		unicast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		unicast.setProductionMode(true);
		//unicast.setTestMode();
		// Set customized fields
		if (null != fields) {
			for (String key : fields.keySet()) {
				unicast.setCustomizedField(key, fields.get(key));
			}
		}
		client.send(unicast);
	}
	
	public void sendIOSGroupcast(String text) throws Exception {
		IOSGroupcast groupcast = new IOSGroupcast(APPKEY_IOS,appMasterSecret_IOS);
		/*  TODO
		 *  Construct the filter condition:
		 *  "where": 
		 *	{
    	 *		"and": 
    	 *		[
      	 *			{"tag":"iostest"}
    	 *		]
		 *	}
		 */
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		JSONObject testTag = new JSONObject();
		testTag.put("tag", "iostest");
		tagArray.put(testTag);
		whereJson.put("and", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());
		
		// Set filter condition into rootJson
		groupcast.setFilter(filterJson);
		groupcast.setAlert(text);
		groupcast.setBadge(1);
		groupcast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		groupcast.setProductionMode(true);
		//groupcast.setTestMode();
		client.send(groupcast);
	}
	
	public void sendIOSCustomizedcast(String alias,String aliasType, String text) throws Exception {
		IOSCustomizedcast customizedcast = new IOSCustomizedcast(APPKEY_IOS,appMasterSecret_IOS);
		// TODO Set your alias and alias_type here, and use comma to split them if there are multiple alias.
		// And if you have many alias, you can also upload a file containing these alias, then 
		// use file_id to send customized notification.
		customizedcast.setAlias(alias, aliasType);
		customizedcast.setAlert(text);
		customizedcast.setBadge(1);
		customizedcast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		customizedcast.setProductionMode(true);
		//customizedcast.setTestMode();
		client.send(customizedcast);
	}
	
	public void sendIOSFilecast(String text,String uploadContents) throws Exception {
		IOSFilecast filecast = new IOSFilecast(APPKEY_IOS,appMasterSecret_IOS);
		// TODO upload your device tokens, and use '\n' to split them if there are multiple tokens 
		String fileId = client.uploadContents(APPKEY_IOS,appMasterSecret_IOS,"aa"+"\n"+"bb");
		filecast.setFileId( fileId);
		filecast.setAlert(text);
		filecast.setBadge(1);
		filecast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		filecast.setProductionMode(true);
		//filecast.setTestMode();
		client.send(filecast);
	}
	
	public static void main(String[] args) {
		// TODO set your appkey and master secret here
		UmengComponent demo = new UmengComponent();
		HashMap map=Maps.newHashMap();
		map.put("type", "4");
		try {
			//demo.sendAndroidBroadcast("Android广播ticker-后台测试","Android广播title-后台测试","Android广播text-后台测试",map);
			//demo.sendIOSBroadcast("IOS广播text-后台测试", map);
			demo.sendIOSUnicast("62116b36e29ce2702cf893e2b35f4244c53d6e7759e695fd74db69a4e41902c1", "IOS单播播text-后台测试", map);
			// 210e564023f5583b44dfb95e0894bce68bc105e90db923d8afaee53b13fd7954
			//demo.sendAndroidUnicast("AgED-8y9n_cnPjVyiuQjz8Pz0rofOtlkqAOq0eSK3-UE", "收到了说一声", "收到了说一声", "收到了说一声", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//demo.sendAndroidUnicast();
			/* TODO these methods are all available, just fill in some fields and do the test
			 * demo.sendAndroidCustomizedcastFile();
			 * demo.sendAndroidBroadcast();
			 * demo.sendAndroidGroupcast();
			 * demo.sendAndroidCustomizedcast();
			 * demo.sendAndroidFilecast();
			 * 
			 * demo.sendIOSBroadcast();
			 * demo.sendIOSUnicast();
			 * demo.sendIOSGroupcast();
			 * demo.sendIOSCustomizedcast();
			 * demo.sendIOSFilecast();
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
