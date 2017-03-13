package com.makervt.elekta.handle;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.makervt.core.component.ip.IpAddressComponent;
import com.makervt.core.component.ip.model.IpInfo;
import com.makervt.core.util.SpringContextHolder;
import com.makervt.elekta.entity.User;
import com.makervt.elekta.service.AppService;
import com.makervt.elekta.service.UserService;


public class IpAddrHandler  implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(IpAddrHandler.class);
	private static UserService usersService=(UserService) SpringContextHolder.getBean(UserService.class);
	@Override
	public void run() {
		boolean isHandle = true;
		try {
			while (isHandle) {
				Thread.sleep(100);			
				final User  user = AppService.ipAreaQueues.take();
				Thread ipThread=new Thread(){
					@Override
					public void run()
					{
						if (null!=user&&StringUtils.isNotEmpty(user.getUserIp()))
						{
							IpInfo ipInfo=IpAddressComponent.GetAddressByIp(user.getUserIp());
							User userUpdate=new User();
							userUpdate.setUserId(user.getUserId());
							userUpdate.setUserArea(ipInfo.getCity());
							usersService.modify(userUpdate);
						}
					}};
					ipThread.setName("IpThread:"+ipThread.getId());
					ipThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.run();
			logger.error("ip地址更新失败", e);
		}
	}
	
	public static void updateArea(User user)
	{
		AppService.ipAreaQueues.offer(user);
	}
}
