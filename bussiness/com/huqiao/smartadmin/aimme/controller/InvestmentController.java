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

import com.huqiao.smartadmin.aimme.entity.Investment;
import com.huqiao.smartadmin.aimme.service.IInvestmentService;
import com.huqiao.smartadmin.common.controller.BaseController;
import com.huqiao.smartadmin.common.entity.Select2;
import com.huqiao.smartadmin.util.Md5Util;
import com.huqiao.smartadmin.util.web.JsonResult;
import com.huqiao.smartadmin.util.web.Page;
/**
 * 投资控制器
 * @author NOVOTS
 * @version Version 1.0
 */
@Controller
@RequestMapping("investment")
public class InvestmentController  extends BaseController {
   /**投资服务*/
    @Resource
    private IInvestmentService investmentService;
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
		  * @return Investment 投资对象
		  */
		@ModelAttribute(value="investment")
		public Investment initModelAttribute(@RequestParam(value = "manageKey", required = false) String manageKey, Model model) {
		Investment investment = null;
		if (manageKey == null ||manageKey.equals("")) {
			investment = new Investment();
		} else {
			investment =  investmentService.getEntityByProperty(Investment.class,"manageKey", manageKey);
			if (investment==null) {
				investment=new Investment();
			}
		}
		return investment;
	}
    /**
     * 投资分页查询
     * @param request HttpServletRequest对象
     * @param investment 投资查询对象
     * @param pageInfo 分页查询对象
     * 
     */
    @RequestMapping(value="/list")
    public void list(HttpServletRequest request,Investment investment,Page pageInfo) {
        Page<Investment> investmentPage = investmentService.getListPage(investment,pageInfo);
        request.setAttribute("pageBean", investmentPage);
		listFormParam(request,investment,pageInfo);
    }
 	/**
     * 为投资分页查询表单准备数据
     * @param request HttpServletRequest对象
     * @param investment 投资查询对象
     * @param pageInfo 分页查询对象
     * 
     */
	public void listFormParam(HttpServletRequest request,Investment investment,Page pageInfo){
		//复杂关联关系数据准备
	}
    /**
     * 添加投资页面
     * @param request HttpServletRequest对象
     * @param callBack  回调函数名称
     *
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUI(HttpServletRequest request,@RequestParam(value = "callBack",required = false)String callBack) {
    	//复杂关联关系数据准备
		//clearTempDataList(request.getSession(),"investment");
		request.setAttribute("callBack", callBack);
    }
    /**
     * 添加投资
     * @param request HttpServletRequest对象
     * @param investment 要添加的对象
     * @return JsonResult 操作结果
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult add(HttpServletRequest request,
	@Valid @ModelAttribute("investment") Investment investment,
	@RequestParam(value = "callBack",required = false)String callBack,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	//默认系统时间类型保存
	/*
		#ONE_TO_MANY_VALUE_SAVE_ADD
	*/
	    //保存多对多关联关系
	//保持一对多关联关系
	investment.setManageKey(Md5Util.getManageKey());
    	investmentService.add(investment);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.add.success"));
        return jsonResult;
    }
    /**
     * 修改投资页面
     * @param investment 需要修改的对象实体
     * @param request HttpServletRequest请求对象
     * 
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
	public void updateUI(@ModelAttribute(value="investment") Investment investment,HttpServletRequest request) {
	request.setAttribute("tempBean", investment);
    	//复杂关联关系数据准备
	//clearTempDataList(request.getSession(),"investment");
    }
    /**
     *  修改投资 
     * @param investment 待修改的实体对象
     * @param request HttpServletRequest对象
     * @return JsonResult 操作结果
     *
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request,
	@ModelAttribute(value="investment") Investment investment,
	BindingResult result) {
    	JsonResult jsonResult = new JsonResult();
    	if(!validate(jsonResult,result)){
    		return jsonResult;
    	}
	    //保存多对多关联关系
		//保持一对多关联关系
        investmentService.update(investment);
	// jsonResult.setNavTabId(rel);
        jsonResult.setMessage(getI18NMessage(request, "base.common.controller.operate.update.success"));
        return jsonResult;
    }
	/**
	 *  查看投资页面
     * @param investment 需要查看的实体对象
     * @param request HttpServletRequest对象
     * 
     */
    @RequestMapping(value="/detail",method=RequestMethod.GET)
	public void detail(@ModelAttribute(value="investment") Investment investment,HttpServletRequest request) {
	request.setAttribute("tempBean", investment);
    	//复杂关联关系数据准备
        listFormParam(request,investment,null);
    }
	/**
     * 删除单个投资对象
     * @param request HttpServletRequest对象
     * @param investment 待删除对象
     * @return JsonResult 操作结果
     * 
     */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,@ModelAttribute Investment investment) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCallbackType("");
        try {
        	investmentService.delete(investment);
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
    	Investment investment = null;
		JsonResult jsonResult = new JsonResult();
    	for(String manageKey : manageKeys){
			 try {
    			investment = investmentService.getEntityByProperty(Investment.class,"manageKey",manageKey);
    			investmentService.delete(investment);
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
		List<Investment> investments = new ArrayList<Investment>();
		if(manageKeys!=null){
			for(String manageKey : manageKeys){
				Investment temp_investment = investmentService.getEntityByProperty(Investment.class, "manageKey", manageKey);
				if(temp_investment!=null && !investments.contains(temp_investment)){
					investments.add(temp_investment);
				}
			}
		}
		request.setAttribute("showCheckBox",request.getParameter("showCheckBox"));
		request.setAttribute("keyName",request.getParameter("keyName"));
		request.setAttribute("investments",investments);
		return "investment/select-list-html";
	}
	/**
	 *  历史记录列表
     * @param request HttpServletRequest对象
	 * @param investment 查询对象
     * @param pageInfo 分页查询对象
     * @return String 显示页面路径
     * 
	@RequestMapping(value = "history",params="list")
	public String historyList(HttpServletRequest request,Investment investment,Page pageInfo){
		Page<HistoryRecord<Investment>> investmentPage = investmentService.getHistoryListPage(investment, pageInfo);
		request.setAttribute("pageBean", investmentPage);
		request.setAttribute("manageKey", investment.getManageKey());
	    return "investment/history-list";
	} */
	/**
	 * 查看历史记录
     * @param request HttpServletRequest对象
     * @param version 版本号
     * @return String 显示页面路径
     *
	@RequestMapping(value = "history",params="view")
	public String historyView(HttpServletRequest request,@RequestParam(value = "version")Integer version){
		Investment investment = investmentService.findByVersion(version);
		Investment preInvestment = (Investment)investmentService.findByPreVersion(Investment.class,investment.getManageKey(),version);
		if(preInvestment!=null && preInvestment.getManageKey().equals(investment.getManageKey())){
			Map<String,CheckResult> checkResult = BeanPropUtil.propValueCheck(preInvestment, investment);
			request.setAttribute("checkResult", checkResult);
		}
		request.setAttribute("tempBean", investment);
		request.setAttribute("showOk", "no");
		request.setAttribute("historyView", true);
		return "investment/detail";
	}*/
	/**
	 * 根据关键字获取投资select2对象
	 * @param queryKey 查询关键字
	 * @param pageInfo 查询分页信息
	 * @param response HttpServletResponse对象
	 * @return Select2<Investment> 投资Select2对象
	 */
	@RequestMapping(value="/select2Query")
	@ResponseBody 
	public Select2<Investment> select2Query(String queryKey,Page<Investment> pageInfo, HttpServletResponse response) {
		Page<Investment> page = investmentService.queryByKey(queryKey, pageInfo);
		Select2<Investment> select2 = new Select2<Investment>();
		select2.setTotal_count(page.getTotalCount());
		select2.setItems(page.getList());
		return select2;
	}
	/**
	 * 查找多个投资
	 * @param ids id数组
	 * @param response HttpServletResponse 对象
	 * @return List<Investment> 投资列表
	 */
	@RequestMapping(value="/queryById")
	@ResponseBody
public List<Investment> queryById(Integer[] ids,HttpServletResponse response) {
		List<Investment> investmentList = investmentService.queryById(ids);
		return investmentList;
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
			@ModelAttribute(value="investment") Investment investment,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",investment);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "investment/tab-add-form";
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
			@ModelAttribute(value="investment") Investment investment,
			@RequestParam(value= "trTarget") String trTarget,
			@RequestParam(value= "trIndex") Integer trIndex,
			@RequestParam(value = "propName") String propName,
			HttpServletRequest request) {
		addUI(request, null);
		request.setAttribute("tempBean",investment);
		request.setAttribute("trTarget", trTarget);
		request.setAttribute("trIndex", trIndex);
		request.setAttribute("propName", propName);
		return "investment/tab-detail-form";
	}
}