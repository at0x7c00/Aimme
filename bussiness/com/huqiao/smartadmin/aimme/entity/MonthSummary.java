package com.huqiao.smartadmin.aimme.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * 月资金结余
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="f_month_summary")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class MonthSummary
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
/**创建时间*/
private Date createTime;
	/**创建时间开始，用于查询*/
private Date createTimeStart;
	/**创建时间结束，用于查询*/
private Date createTimeEnd;
/**收入*/
private Double income;
	/**收入开始，用于查询*/
private Double incomeStart;
	/**收入结束，用于查询*/
private Double incomeEnd;
/**余额*/
private Double balance;
	/**余额开始，用于查询*/
private Double balanceStart;
	/**余额结束，用于查询*/
private Double balanceEnd;
/**支出*/
private Double outcome;
	/**支出开始，用于查询*/
private Double outcomeStart;
	/**支出结束，用于查询*/
private Double outcomeEnd;
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
 * @param createTime 要设置的创建时间
 */
public void setCreateTime(Date createTime){
    this.createTime = createTime;
}
/**
 * @return Date 创建时间 
 */
@Column(name="create_time",nullable=true)
public Date getCreateTime(){
		return this.createTime;	
}
/**
  * @param createTimeStart 要设置的创建时间开始日期
  */
public void setCreateTimeStart(Date createTimeStart){
    this.createTimeStart = createTimeStart;
}
/**
  * @return Date 创建时间开始日期
  */
@Transient
public Date getCreateTimeStart(){
    return this.createTimeStart;
}
/**
  * @param createTimeEnd 要设置的创建时间结束日期
  */
public void setCreateTimeEnd(Date createTimeEnd){
    this.createTimeEnd = createTimeEnd;
}
/**
  * @return Date 创建时间结束日期
  */
@Transient
public Date getCreateTimeEnd(){
    return this.createTimeEnd;
}
/**
 * @param income 要设置的收入
 */
public void setIncome(Double income){
    this.income = income;
}
/**
 * @return Double 收入 
 */
@Column(name="income",nullable=true)
public Double getIncome(){
		return this.income;	
}
/**
  * @param incomeStart 要设置的收入开始日期
  */
public void setIncomeStart(Double incomeStart){
    this.incomeStart = incomeStart;
}
/**
  * @return Double 收入开始日期
  */
@Transient
public Double getIncomeStart(){
    return this.incomeStart;
}
/**
  * @param incomeEnd 要设置的收入结束日期
  */
public void setIncomeEnd(Double incomeEnd){
    this.incomeEnd = incomeEnd;
}
/**
  * @return Double 收入结束日期
  */
@Transient
public Double getIncomeEnd(){
    return this.incomeEnd;
}
/**
 * @param balance 要设置的余额
 */
public void setBalance(Double balance){
    this.balance = balance;
}
/**
 * @return Double 余额 
 */
@Column(name="balance",nullable=true)
public Double getBalance(){
		return this.balance;	
}
/**
  * @param balanceStart 要设置的余额开始日期
  */
public void setBalanceStart(Double balanceStart){
    this.balanceStart = balanceStart;
}
/**
  * @return Double 余额开始日期
  */
@Transient
public Double getBalanceStart(){
    return this.balanceStart;
}
/**
  * @param balanceEnd 要设置的余额结束日期
  */
public void setBalanceEnd(Double balanceEnd){
    this.balanceEnd = balanceEnd;
}
/**
  * @return Double 余额结束日期
  */
@Transient
public Double getBalanceEnd(){
    return this.balanceEnd;
}
/**
 * @param outcome 要设置的支出
 */
public void setOutcome(Double outcome){
    this.outcome = outcome;
}
/**
 * @return Double 支出 
 */
@Column(name="outcome",nullable=true)
public Double getOutcome(){
		return this.outcome;	
}
/**
  * @param outcomeStart 要设置的支出开始日期
  */
public void setOutcomeStart(Double outcomeStart){
    this.outcomeStart = outcomeStart;
}
/**
  * @return Double 支出开始日期
  */
@Transient
public Double getOutcomeStart(){
    return this.outcomeStart;
}
/**
  * @param outcomeEnd 要设置的支出结束日期
  */
public void setOutcomeEnd(Double outcomeEnd){
    this.outcomeEnd = outcomeEnd;
}
/**
  * @return Double 支出结束日期
  */
@Transient
public Double getOutcomeEnd(){
    return this.outcomeEnd;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		MonthSummary other = null;
		try{
			other = (MonthSummary) obj;
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
		return "MonthSummary [manageKey=" + manageKey + "]";
	}
}