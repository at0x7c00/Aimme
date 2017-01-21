package com.huqiao.smartadmin.aimme.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * 资产
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="f_property")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Property
{
/**唯一识别ID号 */
protected Integer id;
	/**@param id 要设置的唯一标示号*/
public void setId(Integer id){this.id=id;}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(columnDefinition="integer")
	/**@return Integer 唯一标示号*/
public Integer getId(){return this.id;}
/**名称*/
private String name;
/**月收入*/
private Double incomePerMonth;
	/**月收入开始，用于查询*/
private Double incomePerMonthStart;
	/**月收入结束，用于查询*/
private Double incomePerMonthEnd;
/**预估价值*/
private Double predictiveValue;
	/**预估��值开始，用于查询*/
private Double predictiveValueStart;
	/**预估价值结束，用于查询*/
private Double predictiveValueEnd;
	/**MD5管理ID*/
	protected String manageKey;
	/**@return String MD5管理ID */
	public String getManageKey() {
		return manageKey;
	}
	/**
	 * @param manageKey 要设置的MD5管理ID 
	 */
	public void setManageKey(String manageKey) {
		this.manageKey = manageKey;
	}
/**
 * @param name 要设置的名称
 */
public void setName(String name){
    this.name = name;
}
/**
 * @return String 名称 
 */
@Column(name="name",length=255,nullable=true)
public String getName(){
		return this.name;	
}
/**
 * @param incomePerMonth 要设置的月收入
 */
public void setIncomePerMonth(Double incomePerMonth){
    this.incomePerMonth = incomePerMonth;
}
/**
 * @return Double 月收入 
 */
@Column(name="income_per_month",nullable=true)
public Double getIncomePerMonth(){
		return this.incomePerMonth;	
}
/**
  * @param incomePerMonthStart 要设置的月收入开始日期
  */
public void setIncomePerMonthStart(Double incomePerMonthStart){
    this.incomePerMonthStart = incomePerMonthStart;
}
/**
  * @return Double 月收入开始日期
  */
@Transient
public Double getIncomePerMonthStart(){
    return this.incomePerMonthStart;
}
/**
  * @param incomePerMonthEnd 要设置的月收入结束日期
  */
public void setIncomePerMonthEnd(Double incomePerMonthEnd){
    this.incomePerMonthEnd = incomePerMonthEnd;
}
/**
  * @return Double 月收入结束日期
  */
@Transient
public Double getIncomePerMonthEnd(){
    return this.incomePerMonthEnd;
}
/**
 * @param predictiveValue 要设置的预估价值
 */
public void setPredictiveValue(Double predictiveValue){
    this.predictiveValue = predictiveValue;
}
/**
 * @return Double 预估价值 
 */
@Column(name="predictive_value",nullable=true)
public Double getPredictiveValue(){
		return this.predictiveValue;	
}
/**
  * @param predictiveValueStart 要设置的预估价值开始日期
  */
public void setPredictiveValueStart(Double predictiveValueStart){
    this.predictiveValueStart = predictiveValueStart;
}
/**
  * @return Double 预估价值开始日期
  */
@Transient
public Double getPredictiveValueStart(){
    return this.predictiveValueStart;
}
/**
  * @param predictiveValueEnd 要设置的预估价值结束日期
  */
public void setPredictiveValueEnd(Double predictiveValueEnd){
    this.predictiveValueEnd = predictiveValueEnd;
}
/**
  * @return Double 预估价值结束日期
  */
@Transient
public Double getPredictiveValueEnd(){
    return this.predictiveValueEnd;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Property other = null;
		try{
			other = (Property) obj;
		}catch(Exception e){
			return false;
		}
		if (manageKey == null) {
			if (other.getManageKey() != null)
				return false;
		} else if (!manageKey.equals(other.getManageKey()))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manageKey == null) ? 0 : manageKey.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Property [manageKey=" + manageKey + "]";
	}
}