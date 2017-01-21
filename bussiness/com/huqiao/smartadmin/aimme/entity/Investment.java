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
 * 投资
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="f_investment")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Investment
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
/**月投入*/
private Double payPerMonth;
	/**月投入开始，用于查询*/
private Double payPerMonthStart;
	/**月投入结束，用于查询*/
private Double payPerMonthEnd;
/**月收益*/
private Double incomePerMonth;
	/**月收益开始��用于查询*/
private Double incomePerMonthStart;
	/**月收益结束，用于查询*/
private Double incomePerMonthEnd;
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
 * @param payPerMonth 要设置的月投入
 */
public void setPayPerMonth(Double payPerMonth){
    this.payPerMonth = payPerMonth;
}
/**
 * @return Double 月投入 
 */
@Column(name="pay_per_month",nullable=true)
public Double getPayPerMonth(){
		return this.payPerMonth;	
}
/**
  * @param payPerMonthStart 要设置的月投入开始日期
  */
public void setPayPerMonthStart(Double payPerMonthStart){
    this.payPerMonthStart = payPerMonthStart;
}
/**
  * @return Double 月投入开始日期
  */
@Transient
public Double getPayPerMonthStart(){
    return this.payPerMonthStart;
}
/**
  * @param payPerMonthEnd 要设置的月投入结束日期
  */
public void setPayPerMonthEnd(Double payPerMonthEnd){
    this.payPerMonthEnd = payPerMonthEnd;
}
/**
  * @return Double 月投入结束日期
  */
@Transient
public Double getPayPerMonthEnd(){
    return this.payPerMonthEnd;
}
/**
 * @param incomePerMonth 要设置的月收益
 */
public void setIncomePerMonth(Double incomePerMonth){
    this.incomePerMonth = incomePerMonth;
}
/**
 * @return Double 月收益 
 */
@Column(name="income_per_month",nullable=true)
public Double getIncomePerMonth(){
		return this.incomePerMonth;	
}
/**
  * @param incomePerMonthStart 要设置的月收益开始日期
  */
public void setIncomePerMonthStart(Double incomePerMonthStart){
    this.incomePerMonthStart = incomePerMonthStart;
}
/**
  * @return Double 月收益开始日期
  */
@Transient
public Double getIncomePerMonthStart(){
    return this.incomePerMonthStart;
}
/**
  * @param incomePerMonthEnd 要设置的月收益结束日期
  */
public void setIncomePerMonthEnd(Double incomePerMonthEnd){
    this.incomePerMonthEnd = incomePerMonthEnd;
}
/**
  * @return Double 月收益结束日期
  */
@Transient
public Double getIncomePerMonthEnd(){
    return this.incomePerMonthEnd;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Investment other = null;
		try{
			other = (Investment) obj;
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
		return "Investment [manageKey=" + manageKey + "]";
	}
}