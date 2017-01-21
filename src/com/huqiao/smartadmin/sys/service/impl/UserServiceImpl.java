package com.huqiao.smartadmin.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.common.entity.enumtype.DayOfWeek;
import com.huqiao.smartadmin.common.service.impl.BaseServiceImpl;
import com.huqiao.smartadmin.sys.dao.IUserDao;
import com.huqiao.smartadmin.sys.entity.Role;
import com.huqiao.smartadmin.sys.entity.User;
import com.huqiao.smartadmin.sys.service.IConfigService;
import com.huqiao.smartadmin.sys.service.IRoleService;
import com.huqiao.smartadmin.sys.service.IUserService;
import com.huqiao.smartadmin.util.web.Page;

/**
 * 
 * 用户Service实现
 * @author NOVOTS 
 * @version Version 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

	@Resource
	private IUserDao userDao;
	@Resource
	private IRoleService roleService;
	@Resource
	private IConfigService configService;
	
	@Override
	public Page<User> getPage(User user, Page pageInfo) {
		int countRecord = userDao.findRowCount(user).intValue();
		Page<User> page = new Page<User>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<User> userList = userDao.findPage(user, page.getStartIndex(), page.getNumPerPage(), pageInfo.getOrderField(), pageInfo.getOrderDirection());
		page.setList(userList);
		page.setOrderDirection(pageInfo.getOrderDirection() == null ? "asc" : pageInfo.getOrderDirection());
		page.setOrderField(pageInfo.getOrderField() == null ? "username" : pageInfo.getOrderField());
		return page;
	}

	@Override
	public void setRoles(User user, Integer[] roleIds) {
		Set<Role> oldRoles = user.getRoles();
		if (oldRoles == null) {
			oldRoles = new HashSet<Role>();
		}
		List<Role> newRoles = roleService.findRoleByIds(roleIds);
		List<Role> forRemove = new ArrayList<Role>();
		for (Role p : oldRoles) {
			if (!newRoles.contains(p)) {
				forRemove.add(p);
			}
		}
		oldRoles.removeAll(forRemove);
		oldRoles.addAll(newRoles);
		user.setRoles(oldRoles);
		update(user);
	}
	
	@Override
	public List<User> eagerListAll() {
		List<User> list = userDao.findAll(User.class);
		for (User user : list) {
			// user.getEmp().getDepartment();
		}
		return list;
	}

	@Override
	public List<User> findAllActive(User user) {
		return userDao.findAllActive(user);
	}


	private Map<Integer, DayOfWeek> prepareDayOfWeekMap() {
		Map<Integer, DayOfWeek> dayOfWeekMap = new HashMap<Integer, DayOfWeek>();
		dayOfWeekMap.put(1, DayOfWeek.Sunday);
		dayOfWeekMap.put(2, DayOfWeek.Monday);
		dayOfWeekMap.put(3, DayOfWeek.Tuesday);
		dayOfWeekMap.put(4, DayOfWeek.Wednesday);
		dayOfWeekMap.put(5, DayOfWeek.Thursday);
		dayOfWeekMap.put(6, DayOfWeek.Friday);
		dayOfWeekMap.put(7, DayOfWeek.Saturday);
		return dayOfWeekMap;
	}


	@Override
	public Page<User> queryByKey(String queryKey, Page<User> pageInfo) {
		int countRecord = userDao.findRowCount(queryKey).intValue();
		Page<User> page = new Page<User>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<User> userList = userDao.findByQueryKey(queryKey);
		page.setList(userList);
		return page;
	}

	@Override
	public List<User> queryById(String[] userNames) {
		return userDao.findListByUserName(userNames);
	}
	
}
