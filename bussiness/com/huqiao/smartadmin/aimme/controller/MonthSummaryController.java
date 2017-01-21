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

import com.huqiao.smartadmin.aimme.entity.MonthSummary;
import com.huqiao.smartadmin.aimme.service.IMonthSummaryService;
import com.huqiao.smartadmin.common.controller.BaseController;
import com.huqiao.smartadmin.common.entity.Select2;
import com.huqiao.smartadmin.util.Md5Util;
import com.huqiao.smartadmin.util.web.JsonResult;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 月资金结余控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("monthSummary")
public class MonthSummaryController  extends BaseController {
   /**月资金结余服务*/
    @Resource
    private IMonthSummaryService monthSummaryService;
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
		  * @return MonthSummary 月资金结余对象
		  */
		@ModelAttribute(value="monthSummary")
		public MonthSummary initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		MonthSummary monthSummary = null;
		if (manageKey == null ||manageKey.equals("")) {
			monthSummary = new MonthSummary();
		} else {
			monthSummary =  monthSummaryService.getEntityByProperty(MonthSummary.class,"manageKey", manageKey);
			if (monthSummary==null) {
				monthSummary=new MonthSummary();
			}
		}
		return monthSummary;
	}
    /**
     * 月资金结余分页查询
     * @param request HttpServletRequest对象
     * @param monthSummary 月资金结余查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,MonthSummary monthSummary,Page pageInfo) {
        Page<MonthSummary> monthSummaryPage = monthSummaryService.getListPage(monthSummary,pageInfo);
        request.setAttribute("pageBean", monthSummaryPage);
		listFormParam(request,monthSummary,pageInfo);
    }
 	/**
     * 为月资金结余分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param monthSummary 月资金结余查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,MonthSummary monthSummary,Page pageInfo){
		//复杂关联关系数据准备
	}
    /**
     * 添加月资金结余页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"monthSummary");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加月资金结余
     * @param request HttpServletRequest对象
     * @param monthSummary 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("monthSummary") MonthSummary monthSummary,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	monthSummary.setManageKey(Md5Util.getManageKey());
    	monthSummaryService.add(monthSummary);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改月资金结余页面
     * @param monthSummary 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="monthSummary") MonthSummary monthSummary,HttpServletRequest request) {
	request.setAttribute("tempBean", monthSummary);
    	//复杂关联关系数据准备
	//clearTempDataList(request.getSession(),"monthSummary");
    }
    /**
     *  修改月资金结余 
     * @param monthSummary 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="monthSummary") MonthSummary monthSummary,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        monthSummaryService.update(monthSummary);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看月资金结余页面
     * @param monthSummary 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="monthSummary") MonthSummary monthSummary,HttpServletRequest request) {
	request.setAttribute("tempBean", monthSummary);
    	//复杂关联关系数据准备
        listFormParam(request,monthSummary,null);
    }
	/**
     * 删除单个月资金结余对象
     * @param request HttpServletRequest对象
     * @param monthSummary 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute MonthSummary monthSummary) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	monthSummaryService.delete(monthSummary);
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
    	MonthSummary monthSummary = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			monthSummary = monthSummaryService.getEntityByProperty(MonthSummary.class,"manageKey",manageKey);
    			monthSummaryService.delete(monthSummary);
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
		List<MonthSummary> monthSummarys = new ArrayList<MonthSummary>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				MonthSummary temp_monthSummary = monthSummaryService.getEntityByProperty(MonthSummary.class, "manageKey", manageKey);
				if(temp_monthSummary!=null && !monthSummarys.contains(temp_monthSummary)){
					monthSummarys.add(temp_monthSummary);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("monthSummarys",monthSummarys);
		return "monthSummary/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param monthSummary 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显��页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,MonthSummary monthSummary,Page pageInfo){
		Page<HistoryRecord<MonthSummary>> monthSummaryPage = monthSummaryService.getHistoryListPage(monthSummary, pageInfo);
		request.setAttribute("pageBean", monthSummaryPage);
		request.setAttribute("manageKey", monthSummary.getManageKey());
	    return "monthSummary/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		MonthSummary monthSummary = monthSummaryService.findByVersion(version);
		MonthSummary preMonthSummary = (MonthSummary)monthSummaryService.findByPreVersion(MonthSummary.class,monthSummary.getManageKey(),version);
		if(preMonthSummary!=null && preMonthSummary.getManageKey().equals(monthSummary.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preMonthSummary, monthSummary);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", monthSummary);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "monthSummary/detail";
	}*/
	/**
	 * 根据关键字获取月资金结余select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<MonthSummary> 月资金结余Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<MonthSummary> select2Query(String queryKey,Page<MonthSummary> pageInfo, HttpServletResponse response) {
		Page<MonthSummary> page = monthSummaryService.queryByKey(queryKey, pageInfo);
		Select2<MonthSummary> select2 = new Select2<MonthSummary>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个月资金结余
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<MonthSummary> 月资金结余列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<MonthSummary> queryById(Integer[] ids,HttpServletResponse response) {
		List<MonthSummary> monthSummaryList = monthSummaryService.queryById(ids);
		return monthSummaryList;
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
			@ModelAttribute(value="monthSummary") MonthSummary monthSummary,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",monthSummary);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "monthSummary/tab-add-form";
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
			@ModelAttribute(value="monthSummary") MonthSummary monthSummary,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",monthSummary);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "monthSummary/tab-detail-form";
	}
}