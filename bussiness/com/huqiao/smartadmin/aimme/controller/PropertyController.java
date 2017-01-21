package com.huqiao.smartadmin.aimme.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huqiao.smartadmin.aimme.entity.Property;
import com.huqiao.smartadmin.aimme.service.IPropertyService;
import com.huqiao.smartadmin.common.controller.BaseController;
import com.huqiao.smartadmin.common.entity.Select2;
import com.huqiao.smartadmin.util.Md5Util;
import com.huqiao.smartadmin.util.web.JsonResult;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 资产控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("property")
public class PropertyController  extends BaseController {
   /**资产服务*/
    @Resource
    private IPropertyService propertyService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
	}
    //复杂关联关系的Service
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return Property 资产对象
		  */
		@ModelAttribute(value="property")
		public Property initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Property property = null;
		if (manageKey == null ||manageKey.equals("")) {
			property = new Property();
		} else {
			property =  propertyService.getEntityByProperty(Property.class,"manageKey", manageKey);
			if (property==null) {
				property=new Property();
			}
		}
		return property;
	}
    /**
     * 资产分页查询
     * @param request HttpServletRequest对象
     * @param property 资产查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Property property,Page pageInfo) {
        Page<Property> propertyPage = propertyService.getListPage(property,pageInfo);
        request.setAttribute("pageBean", propertyPage);
		listFormParam(request,property,pageInfo);
    }
 	/**
     * 为资产分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param property 资产查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Property property,Page pageInfo){
		//复杂关联关系数据准备
	}
    /**
     * 添加资产页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"property");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加资产
     * @param request HttpServletRequest对象
     * @param property 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("property") Property property,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	property.setManageKey(Md5Util.getManageKey());
    	propertyService.add(property);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改资产页面
     * @param property 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="property") Property property,HttpServletRequest request) {
	request.setAttribute("tempBean", property);
    	//复杂关联关系数据准备
	//clearTempDataList(request.getSession(),"property");
    }
    /**
     *  修改资产 
     * @param property 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="property") Property property,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        propertyService.update(property);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看资产页面
     * @param property 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="property") Property property,HttpServletRequest request) {
	request.setAttribute("tempBean", property);
    	//复杂关联关系数据准备
        listFormParam(request,property,null);
    }
	/**
     * 删除单个资产对象
     * @param request HttpServletRequest对象
     * @param property 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Property property) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	propertyService.delete(property);
		} catch (RuntimeException re) {
			jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.inuse"));
			return jsonResult;
		}catch (Exception e) {
			jsonResult.setMessage(e.toString());
			return jsonResult;
		}
	//jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.success"));
        return jsonResult;
    }
    /**
     * 删除多个对象
     * @param manageKeys 唯一识别ID数组
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
	public JsonResult batchDelete(HttpServletRequest request,@RequestParam("manageKeys") String[] manageKeys) {
    	Property property = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			property = propertyService.getEntityByProperty(Property.class,"manageKey",manageKey);
    			propertyService.delete(property);
			}catch (RuntimeException re) {
				jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.inuse"));
				return jsonResult;
			}catch (Exception e) {
				jsonResult.setMessage(e.toString());
				return jsonResult;
			}
    	}
		jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.delete.success"));
    	return jsonResult;
    } 
	 /**
	  *选择对象返回html
      *@param request HttpServletRequest对象
	  *@param manageKeys manageKey 数组
	  *@return String 返回jsp页面路径
      */
	@RequestMapping(value = "/selectList",params = "htmlType")
	public String selectListWithHtml(HttpServletRequest request,
			@RequestParam(value = "manageKey",required = false)String[] manageKeys
			){
		List<Property> propertys = new ArrayList<Property>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Property temp_property = propertyService.getEntityByProperty(Property.class, "manageKey", manageKey);
				if(temp_property!=null && !propertys.contains(temp_property)){
					propertys.add(temp_property);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("propertys",propertys);
		return "property/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param property 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Property property,Page pageInfo){
		Page<HistoryRecord<Property>> propertyPage = propertyService.getHistoryListPage(property, pageInfo);
		request.setAttribute("pageBean", propertyPage);
		request.setAttribute("manageKey", property.getManageKey());
	    return "property/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version ��本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Property property = propertyService.findByVersion(version);
		Property preProperty = (Property)propertyService.findByPreVersion(Property.class,property.getManageKey(),version);
		if(preProperty!=null && preProperty.getManageKey().equals(property.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preProperty, property);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", property);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "property/detail";
	}*/
	/**
	 * 根据关键字获取资产select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Property> 资���Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Property> select2Query(String queryKey,Page<Property> pageInfo, HttpServletResponse response) {
		Page<Property> page = propertyService.queryByKey(queryKey, pageInfo);
		Select2<Property> select2 = new Select2<Property>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个资产
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Property> 资产列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Property> queryById(Integer[] ids,HttpServletResponse response) {
		List<Property> propertyList = propertyService.queryById(ids);
		return propertyList;
	}
	/**
	 * tab页添加表单
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabAddForm")
public String tabAddForm(
			@ModelAttribute(value="property") Property property,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",property);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "property/tab-add-form";
	}
/**
	 * tab页查看详情页面
	 * @param trTarget tr的target值
	 * @param trIndex tr的序号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabDetailForm")
	public String tabDetailForm(
			@ModelAttribute(value="property") Property property,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",property);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "property/tab-detail-form";
	}
}