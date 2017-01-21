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
 * 负债
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="f_debt")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Debt
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
/**月支出*/
private Double payPerMonth;
	/**月支出开始，用于查询*/
private Double payPerMonthStart;
	/**月支出结束，用于查询*/
private Double payPerMonthEnd;
/**一次性支出*/
private Double payOnce;
	/**一次性支出开始，用于查询*/
private Double payOnceStart;
	/**一次性支出结束，用于查询*/
private Double payOnceEnd;
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
 * @param payPerMonth 要设置的月支出
 */
public void setPayPerMonth(Double payPerMonth){
    this.payPerMonth = payPerMonth;
}
/**
 * @return Double 月支出 
 */
@Column(name="pay_per_month",nullable=true)
public Double getPayPerMonth(){
		return this.payPerMonth;	
}
/**
  * @param payPerMonthStart 要设置的月支出开始日期
  */
public void setPayPerMonthStart(Double payPerMonthStart){
    this.payPerMonthStart = payPerMonthStart;
}
/**
  * @return Double 月支出开始日期
  */
@Transient
public Double getPayPerMonthStart(){
    return this.payPerMonthStart;
}
/**
  * @param payPerMonthEnd 要设置的月支出结束日期
  */
public void setPayPerMonthEnd(Double payPerMonthEnd){
    this.payPerMonthEnd = payPerMonthEnd;
}
/**
  * @return Double 月支出结束日期
  */
@Transient
public Double getPayPerMonthEnd(){
    return this.payPerMonthEnd;
}
/**
 * @param payOnce 要设置的一次性支出
 */
public void setPayOnce(Double payOnce){
    this.payOnce = payOnce;
}
/**
 * @return Double 一次性支出 
 */
@Column(name="pay_once",nullable=true)
public Double getPayOnce(){
		return this.payOnce;	
}
/**
  * @param payOnceStart 要设置的一次性支出开始日期
  */
public void setPayOnceStart(Double payOnceStart){
    this.payOnceStart = payOnceStart;
}
/**
  * @return Double 一次性支出开始日期
  */
@Transient
public Double getPayOnceStart(){
    return this.payOnceStart;
}
/**
  * @param payOnceEnd 要设置的一次性支出结束日期
  */
public void setPayOnceEnd(Double payOnceEnd){
    this.payOnceEnd = payOnceEnd;
}
/**
  * @return Double 一次性支出结束日期
  */
@Transient
public Double getPayOnceEnd(){
    return this.payOnceEnd;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Debt other = null;
		try{
			other = (Debt) obj;
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
		return "Debt [manageKey=" + manageKey + "]";
	}
}