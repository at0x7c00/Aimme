package com.huqiao.smartadmin.sys.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.sys.entity.Config;
import com.huqiao.smartadmin.sys.service.IConfigService;
/**
 * 权限Service实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements IConfigService {
	Logger logger = Logger.getLogger(ConfigServiceImpl.class);

	@Override
	public boolean validateAppKey(String appKey) {
		/*
		 * if(appKey==null || appKey.trim().equals("")){ return false; } Config
		 * config = getById(Config.class,
		 * Config.SYS_CONFIG_MAIL_SEND_HOST_ACCESS_APP_KEY); String appKeys =
		 * config.getDescripttion1(); if(appKeys==null ||
		 * appKeys.trim().equals("")){ return false; } for(String key :
		 * appKeys.split(";")){ if(appKey.equals(key)){ return false; } }
		 */
		return false;
	}

	

}
