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

import com.huqiao.smartadmin.aimme.entity.Target;
import com.huqiao.smartadmin.aimme.entity.enumtype.Emergency;
import com.huqiao.smartadmin.aimme.entity.propertyeditor.TargetEditor;
import com.huqiao.smartadmin.aimme.service.ITargetService;
import com.huqiao.smartadmin.common.controller.BaseController;
import com.huqiao.smartadmin.common.entity.Select2;
import com.huqiao.smartadmin.util.Md5Util;
import com.huqiao.smartadmin.util.web.JsonResult;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 目标控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("target")
public class TargetController  extends BaseController {
   /**目标服务*/
    @Resource
    private ITargetService targetService;
 /**
  * 注册属性编辑器
  * @param binder 数据绑定器
  */
    @InitBinder
	public void initPropEditor(WebDataBinder binder){
         binder.registerCustomEditor(Target.class,new TargetEditor(targetService));
	}
    //复杂关联关系的Service
		/**
		  * 初始化ModelAttribute
		  * @param manageKey md5管理ID （非空时自动加载指定对象）
		  * @param model 页面model对象
		  * @return Target 目标对象
		  */
		@ModelAttribute(value="target")
		public Target initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Target target = null;
		if (manageKey == null ||manageKey.equals("")) {
			target = new Target();
		} else {
			target =  targetService.getEntityByProperty(Target.class,"manageKey", manageKey);
			if (target==null) {
				target=new Target();
			}
		}
		return target;
	}
    /**
     * 目标分页查询
     * @param request HttpServletRequest对象
     * @param target 目标查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Target target,Page pageInfo) {
        Page<Target> targetPage = targetService.getListPage(target,pageInfo);
        request.setAttribute("pageBean", targetPage);
		listFormParam(request,target,pageInfo);
    }
 	/**
     * 为目标分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param target 目标查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Target target,Page pageInfo){
		//复杂关联关系数据准备
					List<Target> targetList = targetService.getByProperties(Target.class,null,null,null,null);
	request.setAttribute("targetList",targetList);
request.setAttribute("emergencyMap",Emergency.emergencyMap);
	}
    /**
     * 添加目标页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
					List<Target> targetList = targetService.getByProperties(Target.class,null,null,null,null);
	request.setAttribute("targetList",targetList);
request.setAttribute("emergencyMap",Emergency.emergencyMap);
		//clearTempDataList(request.getSession(),"target");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加目标
     * @param request HttpServletRequest对象
     * @param target 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("target") Target target,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
		target.childrenListToSet(request);
	target.setManageKey(Md5Util.getManageKey());
    	targetService.add(target);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改目标页面
     * @param target 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="target") Target target,HttpServletRequest request) {
	request.setAttribute("tempBean", target);
    	//复杂关联关系数据准备
					List<Target> targetList = targetService.getByProperties(Target.class,null,null,null,null);
	request.setAttribute("targetList",targetList);
request.setAttribute("emergencyMap",Emergency.emergencyMap);
	//clearTempDataList(request.getSession(),"target");
    }
    /**
     *  修改目标 
     * @param target 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="target") Target target,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多��多关联关系
		//保持一对多关联关系
		target.childrenListToSet(request);
        targetService.update(target);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看目标页面
     * @param target 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="target") Target target,HttpServletRequest request) {
	request.setAttribute("tempBean", target);
    	//复杂关联关系数据准备
        listFormParam(request,target,null);
    }
	/**
     * 删除单个目标对象
     * @param request HttpServletRequest对象
     * @param target 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Target target) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	targetService.delete(target);
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
    	Target target = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			target = targetService.getEntityByProperty(Target.class,"manageKey",manageKey);
    			targetService.delete(target);
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
		List<Target> targets = new ArrayList<Target>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Target temp_target = targetService.getEntityByProperty(Target.class, "manageKey", manageKey);
				if(temp_target!=null && !targets.contains(temp_target)){
					targets.add(temp_target);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("targets",targets);
		return "target/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param target 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Target target,Page pageInfo){
		Page<HistoryRecord<Target>> targetPage = targetService.getHistoryListPage(target, pageInfo);
		request.setAttribute("pageBean", targetPage);
		request.setAttribute("manageKey", target.getManageKey());
	    return "target/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Target target = targetService.findByVersion(version);
		Target preTarget = (Target)targetService.findByPreVersion(Target.class,target.getManageKey(),version);
		if(preTarget!=null && preTarget.getManageKey().equals(target.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preTarget, target);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", target);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "target/detail";
	}*/
	/**
	 * 根据关键字获取目标select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Target> 目标Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Target> select2Query(String queryKey,Page<Target> pageInfo, HttpServletResponse response) {
		Page<Target> page = targetService.queryByKey(queryKey, pageInfo);
		Select2<Target> select2 = new Select2<Target>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个目标
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Target> 目标列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Target> queryById(Integer[] ids,HttpServletResponse response) {
		List<Target> targetList = targetService.queryById(ids);
		return targetList;
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
			@ModelAttribute(value="target") Target target,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",target);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "target/tab-add-form";
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
			@ModelAttribute(value="target") Target target,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",target);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "target/tab-detail-form";
	}
}