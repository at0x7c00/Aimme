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

import com.huqiao.smartadmin.aimme.entity.Clazz;
import com.huqiao.smartadmin.aimme.entity.Value;
import com.huqiao.smartadmin.aimme.entity.propertyeditor.ClazzEditor;
import com.huqiao.smartadmin.aimme.service.IClazzService;
import com.huqiao.smartadmin.aimme.service.IValueService;
import com.huqiao.smartadmin.common.controller.BaseController;
import com.huqiao.smartadmin.common.entity.Select2;
import com.huqiao.smartadmin.util.Md5Util;
import com.huqiao.smartadmin.util.web.JsonResult;
import com.huqiao.smartadmin.util.web.Page;
/**
 * Value控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("value")
public class ValueController  extends BaseController {
   /**Value服务*/
    @Resource
    private IValueService valueService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(Clazz.class,new ClazzEditor(clazzService));
	}
    //复杂关联关系的Service
@Resource private IClazzService clazzService;
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return Value Value对象
		  */
		@ModelAttribute(value="value")
		public Value initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Value value = null;
		if (manageKey == null ||manageKey.equals("")) {
			value = new Value();
		} else {
			value =  valueService.getEntityByProperty(Value.class,"manageKey", manageKey);
			if (value==null) {
				value=new Value();
			}
		}
		return value;
	}
    /**
     * Value分页查询
     * @param request HttpServletRequest对象
     * @param value Value查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Value value,Page pageInfo) {
        Page<Value> valuePage = valueService.getListPage(value,pageInfo);
        request.setAttribute("pageBean", valuePage);
		listFormParam(request,value,pageInfo);
    }
 	/**
     * 为Value分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param value Value查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Value value,Page pageInfo){
		//复杂关联关系数据准备
					List<Clazz> clazzList = clazzService.getByProperties(Clazz.class,null,null,null,null);
	request.setAttribute("clazzList",clazzList);
	}
    /**
     * 添加Value页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<Clazz> clazzList = clazzService.getByProperties(Clazz.class,null,null,null,null);
	request.setAttribute("clazzList",clazzList);
		//clearTempDataList(request.getSession(),"value");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加Value
     * @param request HttpServletRequest对象
     * @param value 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("value") Value value,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	value.setManageKey(Md5Util.getManageKey());
    	valueService.add(value);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改Value页面
     * @param value 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="value") Value value,HttpServletRequest request) {
	request.setAttribute("tempBean", value);
    	//复杂关联关系数据准备
					List<Clazz> clazzList = clazzService.getByProperties(Clazz.class,null,null,null,null);
	request.setAttribute("clazzList",clazzList);
	//clearTempDataList(request.getSession(),"value");
    }
    /**
     *  修改Value 
     * @param value 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="value") Value value,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        valueService.update(value);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看Value页面
     * @param value 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="value") Value value,HttpServletRequest request) {
	request.setAttribute("tempBean", value);
    	//复杂关联关系数据准备
        listFormParam(request,value,null);
    }
	/**
     * 删除单个Value对象
     * @param request HttpServletRequest对象
     * @param value 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Value value) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	valueService.delete(value);
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
    	Value value = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			value = valueService.getEntityByProperty(Value.class,"manageKey",manageKey);
    			valueService.delete(value);
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
		List<Value> values = new ArrayList<Value>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Value temp_value = valueService.getEntityByProperty(Value.class, "manageKey", manageKey);
				if(temp_value!=null && !values.contains(temp_value)){
					values.add(temp_value);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("values",values);
		return "value/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param value 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Value value,Page pageInfo){
		Page<HistoryRecord<Value>> valuePage = valueService.getHistoryListPage(value, pageInfo);
		request.setAttribute("pageBean", valuePage);
		request.setAttribute("manageKey", value.getManageKey());
	    return "value/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Value value = valueService.findByVersion(version);
		Value preValue = (Value)valueService.findByPreVersion(Value.class,value.getManageKey(),version);
		if(preValue!=null && preValue.getManageKey().equals(value.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preValue, value);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", value);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "value/detail";
	}*/
	/**
	 * 根据关键字获取Valueselect2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Value> ValueSelect2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Value> select2Query(String queryKey,Page<Value> pageInfo, HttpServletResponse response) {
		Page<Value> page = valueService.queryByKey(queryKey, pageInfo);
		Select2<Value> select2 = new Select2<Value>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个Value
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Value> Value列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Value> queryById(Integer[] ids,HttpServletResponse response) {
		List<Value> valueList = valueService.queryById(ids);
		return valueList;
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
			@ModelAttribute(value="value") Value value,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",value);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "value/tab-add-form";
	}
/**
	 * tab页查看详情页面
	 * @param trTarget tr的target值
	 * @param trIndex tr的���号
     * @param propName 表单元素name前缀
	 * @return String jsp路径
	 */
	@RequestMapping(value = "/tabDetailForm")
	public String tabDetailForm(
			@ModelAttribute(value="value") Value value,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",value);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "value/tab-detail-form";
	}
}