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
import com.huqiao.smartadmin.aimme.service.IClazzService;
import com.huqiao.smartadmin.common.controller.BaseController;
import com.huqiao.smartadmin.common.entity.Select2;
import com.huqiao.smartadmin.util.Md5Util;
import com.huqiao.smartadmin.util.web.JsonResult;
import com.huqiao.smartadmin.util.web.Page;
/**
 * Class控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("clazz")
public class ClazzController  extends BaseController {
   /**Class服务*/
    @Resource
    private IClazzService clazzService;
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
		  * @return Clazz Class对象
		  */
		@ModelAttribute(value="clazz")
		public Clazz initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Clazz clazz = null;
		if (manageKey == null ||manageKey.equals("")) {
			clazz = new Clazz();
		} else {
			clazz =  clazzService.getEntityByProperty(Clazz.class,"manageKey", manageKey);
			if (clazz==null) {
				clazz=new Clazz();
			}
		}
		return clazz;
	}
    /**
     * Class分页查询
     * @param request HttpServletRequest对象
     * @param clazz Class查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Clazz clazz,Page pageInfo) {
        Page<Clazz> clazzPage = clazzService.getListPage(clazz,pageInfo);
        request.setAttribute("pageBean", clazzPage);
		listFormParam(request,clazz,pageInfo);
    }
 	/**
     * 为Class分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param clazz Class查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Clazz clazz,Page pageInfo){
		//复杂关联关系数据准备
	}
    /**
     * 添加Class页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"clazz");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加Class
     * @param request HttpServletRequest对象
     * @param clazz 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("clazz") Clazz clazz,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	clazz.setManageKey(Md5Util.getManageKey());
    	clazzService.add(clazz);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改Class页面
     * @param clazz 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="clazz") Clazz clazz,HttpServletRequest request) {
	request.setAttribute("tempBean", clazz);
    	//复杂关联关系数据准备
	//clearTempDataList(request.getSession(),"clazz");
    }
    /**
     *  修改Class 
     * @param clazz 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="clazz") Clazz clazz,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        clazzService.update(clazz);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看Class页面
     * @param clazz 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="clazz") Clazz clazz,HttpServletRequest request) {
	request.setAttribute("tempBean", clazz);
    	//复杂关联关系数据准备
        listFormParam(request,clazz,null);
    }
	/**
     * 删除单个Class对象
     * @param request HttpServletRequest对象
     * @param clazz 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Clazz clazz) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	clazzService.delete(clazz);
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
    	Clazz clazz = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			clazz = clazzService.getEntityByProperty(Clazz.class,"manageKey",manageKey);
    			clazzService.delete(clazz);
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
		List<Clazz> clazzs = new ArrayList<Clazz>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Clazz temp_clazz = clazzService.getEntityByProperty(Clazz.class, "manageKey", manageKey);
				if(temp_clazz!=null && !clazzs.contains(temp_clazz)){
					clazzs.add(temp_clazz);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("clazzs",clazzs);
		return "clazz/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param clazz 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Clazz clazz,Page pageInfo){
		Page<HistoryRecord<Clazz>> clazzPage = clazzService.getHistoryListPage(clazz, pageInfo);
		request.setAttribute("pageBean", clazzPage);
		request.setAttribute("manageKey", clazz.getManageKey());
	    return "clazz/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Clazz clazz = clazzService.findByVersion(version);
		Clazz preClazz = (Clazz)clazzService.findByPreVersion(Clazz.class,clazz.getManageKey(),version);
		if(preClazz!=null && preClazz.getManageKey().equals(clazz.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preClazz, clazz);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", clazz);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "clazz/detail";
	}*/
	/**
	 * 根据关键字获取Classselect2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Clazz> ClassSelect2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Clazz> select2Query(String queryKey,Page<Clazz> pageInfo, HttpServletResponse response) {
		Page<Clazz> page = clazzService.queryByKey(queryKey, pageInfo);
		Select2<Clazz> select2 = new Select2<Clazz>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个Class
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Clazz> Class列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Clazz> queryById(Integer[] ids,HttpServletResponse response) {
		List<Clazz> clazzList = clazzService.queryById(ids);
		return clazzList;
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
			@ModelAttribute(value="clazz") Clazz clazz,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",clazz);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "clazz/tab-add-form";
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
			@ModelAttribute(value="clazz") Clazz clazz,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",clazz);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "clazz/tab-detail-form";
	}
}