package com.huqiao.smartadmin.aimme.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * Class
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="s_class")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Clazz
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
/**Key*/
private String key;
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
 * @param key 要设置的Key
 */
public void setKey(String key){
    this.key = key;
}
/**
 * @return String Key 
 */
@Column(name="_key",length=255,nullable=true)
public String getKey(){
		return this.key;	
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Clazz other = null;
		try{
			other = (Clazz) obj;
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
		return "Clazz [manageKey=" + manageKey + "]";
	}
}