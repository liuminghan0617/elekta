package com.makervt.elekta.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.makervt.core.cache.AppCache;
import com.makervt.core.service.BaseService;
import com.makervt.core.util.EncrypCoder;
import com.makervt.elekta.api.LoginApi;
import com.makervt.elekta.dao.UserDao;
import com.makervt.elekta.entity.User;

@Service("userService")
public class UserService extends BaseService<User> {
	private static Logger logger = LoggerFactory.getLogger(LoginApi.class);
	@Autowired
	private UserDao userDao;

	public Integer create(User user) {
		return userDao.insert(user);
	}

	public Integer modify(User user) {
		return userDao.updateByPK(user);
	}

	public Integer remove(User user) {
		return userDao.delete(user);
	}

	public Integer removeBatch(String[] array) {
		return userDao.deleteBatch(array);
	}

	@Override
	public Integer count(User entity) {
		return userDao.count(entity);
	}

	@Override
	public List<User> selectPage(User entity) {
		return userDao.selectPage(entity);
	}
	
	public List<User> select(User entity) {
		return userDao.select(entity);
	}

	public User selectByPK(String userId) {
		return userDao.selectByPK(userId);
	}

	/**
	 * 生成用户token
	 * 
	 * @param user
	 * @return
	 */
	public String generateToken(User user) {
		Map<String, Object> mapToken = new HashMap<String, Object>();
		mapToken.put("userMobile", user.getUserMobile());
		mapToken.put("userMrNo", user.getUserMrNo());
		mapToken.put("userId", user.getUserId());
		mapToken.put("var", user.getUserLoginCount());
		String tokenStr = JSON.toJSONString(mapToken);
		String tokenCiphertext = null;
		try {
			tokenCiphertext = EncrypCoder.enCodeToken(tokenStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("tokenCiphertext:"+tokenCiphertext);
		return tokenCiphertext;
	}
	

	public static User explainToken(String token) throws Exception {
		String tokenStr = EncrypCoder.deCodeToken(token);
		User user = JSON.parseObject(tokenStr, User.class);
		return user;
	}
	
	/**
	 * 验证码3分钟失效
	 * @param user
	 */
	public void invalidVerifyCode(User user)
	{
		final User userCheck=new User();
		userCheck.setUserId(user.getUserId());
		userCheck.setUserMobileSmsCode(user.getUserMobileSmsCode());
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						public void run() {
							List<User> userList=userDao.select(userCheck);
							
							if(userList!=null&&userList.size()==1)
							{
								User updateUser=new User();
								updateUser.setUserId(userList.get(0).getUserId());
								updateUser.setUserMobileSmsCode("");
								userDao.updateByPK(updateUser);
							}
							System.gc();
						}
					},1000*360);
				} catch (Exception e) {
					// e.printStackTrace();
					logger.error("验证失效更新失败！" +userCheck.getUserId(), e);
				}
			}
		});
		t.start();
	}
	
	public static void main(String [] arge)
	{
		UserService userService=new UserService();
		User user=new User();
		user.setUserMrNo("0987");
		user.setUserMobile("15330094554");
		user.setUserId("test153300945540987");
		user.setUserLoginCount("4");
		System.out.println(userService.generateToken(user));
		/*String token="pjdaS5Jm7a7IJxsrtYY57Njc21xpb83+Uo9bnTmOcuudFKiI4svuVhOg/pT/jIF1Q04CBr1du8Ri/HvGlEJORLUMsSBx/ruGXA2h/f1RCko0PcVxJCe4SKmFuLlU";
		try {
			User user=UserService.explainToken(token);
			System.out.println(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
}
