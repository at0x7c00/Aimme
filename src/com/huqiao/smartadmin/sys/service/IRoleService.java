package com.huqiao.smartadmin.sys.service;

import java.util.List;

import com.huqiao.smartadmin.common.service.IBaseService;
import com.huqiao.smartadmin.sys.entity.Role;
import com.huqiao.smartadmin.util.web.Page;

/**
 * 角色Service接口
 * @author NOVOTS
 * @version Version 1.0
 */
public interface IRoleService extends IBaseService<Role> {

	/**
	 * 得到分页信息
	 * @param  role 角色查询对象
	 * @param  pageInfo 分页查询对象
	 * @return Page<Role> 分页查询结果
	 */
    public Page<Role> getPage(Role role,Page pageInfo);
    
    /**
     * 设置角色权限
     * @param  role 角色对象
     * @param  functionPoints 权限ID数组
     */
    public void setPrivilege(Role role,Integer[] functionPoints);
    
	
    /**
     * 按照角色Id查询
     * @param  roleIds 角色ID数组
     * @return List<Role> 角色列表
     */
	public List<Role> findRoleByIds(Integer[] roleIds);

}