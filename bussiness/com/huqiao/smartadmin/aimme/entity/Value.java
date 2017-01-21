package com.huqiao.smartadmin.aimme.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Value
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="s_value")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Value
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
/**值*/
private String value;
/**创建时间*/
private Date createTime;
	/**创建时间开始，用于查询*/
private Date createTimeStart;
	/**创建时间结束，用于查询*/
private Date createTimeEnd;
/**Class*/
private Clazz clazz;
	/**Class模糊查询条件*/
private String clazzQuery;
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
 * @param value 要设置的值
 */
public void setValue(String value){
    this.value = value;
}
/**
 * @return String 值 
 */
@Column(name="value",length=255,nullable=true)
public String getValue(){
		return this.value;	
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
 * @param clazz 要设置的Class
 */
public void setClazz(Clazz clazz){
    this.clazz = clazz;
}
/**
 * @param clazzQuery 要设置的Class模糊查询条件
 */
public void setClazzQuery(String clazzQuery){
    this.clazzQuery = clazzQuery;
}
/**
 * @return Clazz Class 
 */
@ManyToOne(targetEntity=com.huqiao.smartadmin.aimme.entity.Clazz.class,fetch=FetchType.LAZY)
@JoinColumn(name="clazz",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public Clazz getClazz(){
		return this.clazz;	
}
/**
 * @return  String Class模糊查询条件
 */
@Transient
public String getClazzQuery(){
    return this.clazzQuery;
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Value other = null;
		try{
			other = (Value) obj;
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
		return "Value [manageKey=" + manageKey + "]";
	}
}