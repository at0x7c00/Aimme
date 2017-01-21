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

import com.huqiao.smartadmin.aimme.entity.Debt;
import com.huqiao.smartadmin.aimme.service.IDebtService;
import com.huqiao.smartadmin.common.controller.BaseController;
import com.huqiao.smartadmin.common.entity.Select2;
import com.huqiao.smartadmin.util.Md5Util;
import com.huqiao.smartadmin.util.web.JsonResult;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 负债控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("debt")
public class DebtController  extends BaseController {
   /**负债服务*/
    @Resource
    private IDebtService debtService;
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
		  * @return Debt 负债对象
		  */
		@ModelAttribute(value="debt")
		public Debt initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Debt debt = null;
		if (manageKey == null ||manageKey.equals("")) {
			debt = new Debt();
		} else {
			debt =  debtService.getEntityByProperty(Debt.class,"manageKey", manageKey);
			if (debt==null) {
				debt=new Debt();
			}
		}
		return debt;
	}
    /**
     * 负债分页查询
     * @param request HttpServletRequest对象
     * @param debt 负债查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Debt debt,Page pageInfo) {
        Page<Debt> debtPage = debtService.getListPage(debt,pageInfo);
        request.setAttribute("pageBean", debtPage);
		listFormParam(request,debt,pageInfo);
    }
 	/**
     * 为负债分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param debt 负债查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Debt debt,Page pageInfo){
		//复杂关联关系数据准备
	}
    /**
     * 添加负债页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"debt");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加负债
     * @param request HttpServletRequest对象
     * @param debt 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("debt") Debt debt,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型���存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	debt.setManageKey(Md5Util.getManageKey());
    	debtService.add(debt);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改负债页面
     * @param debt 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="debt") Debt debt,HttpServletRequest request) {
	request.setAttribute("tempBean", debt);
    	//复杂关联关系数据准备
	//clearTempDataList(request.getSession(),"debt");
    }
    /**
     *  修改负债 
     * @param debt 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="debt") Debt debt,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        debtService.update(debt);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看负债页面
     * @param debt 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="debt") Debt debt,HttpServletRequest request) {
	request.setAttribute("tempBean", debt);
    	//复杂关联关系数据准备
        listFormParam(request,debt,null);
    }
	/**
     * 删除单个负债对象
     * @param request HttpServletRequest对象
     * @param debt 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Debt debt) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	debtService.delete(debt);
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
    	Debt debt = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			debt = debtService.getEntityByProperty(Debt.class,"manageKey",manageKey);
    			debtService.delete(debt);
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
		List<Debt> debts = new ArrayList<Debt>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Debt temp_debt = debtService.getEntityByProperty(Debt.class, "manageKey", manageKey);
				if(temp_debt!=null && !debts.contains(temp_debt)){
					debts.add(temp_debt);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("debts",debts);
		return "debt/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param debt 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Debt debt,Page pageInfo){
		Page<HistoryRecord<Debt>> debtPage = debtService.getHistoryListPage(debt, pageInfo);
		request.setAttribute("pageBean", debtPage);
		request.setAttribute("manageKey", debt.getManageKey());
	    return "debt/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Debt debt = debtService.findByVersion(version);
		Debt preDebt = (Debt)debtService.findByPreVersion(Debt.class,debt.getManageKey(),version);
		if(preDebt!=null && preDebt.getManageKey().equals(debt.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preDebt, debt);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", debt);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "debt/detail";
	}*/
	/**
	 * 根据关键字获取负债select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Debt> 负债Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Debt> select2Query(String queryKey,Page<Debt> pageInfo, HttpServletResponse response) {
		Page<Debt> page = debtService.queryByKey(queryKey, pageInfo);
		Select2<Debt> select2 = new Select2<Debt>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个负债
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Debt> 负债列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Debt> queryById(Integer[] ids,HttpServletResponse response) {
		List<Debt> debtList = debtService.queryById(ids);
		return debtList;
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
			@ModelAttribute(value="debt") Debt debt,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",debt);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "debt/tab-add-form";
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
			@ModelAttribute(value="debt") Debt debt,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",debt);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "debt/tab-detail-form";
	}
}