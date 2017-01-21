package com.huqiao.smartadmin.sys.service;

import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.sys.entity.Config;

/**
 * 系统配置Service
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IConfigService extends IBaseService<Config> {
	
	/**
	 * 验证appKey的合法性
	 * @param appKey 配置ID
	 * @return boolean 是否合法
	 */
	public boolean validateAppKey(String appKey);


}
