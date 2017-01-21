package com.huqiao.smartadmin.aimme.entity;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.huqiao.smartadmin.aimme.entity.enumtype.Emergency;
import com.huqiao.smartadmin.util.Md5Util;
/**
 * 目标
 * @author NOVOTS
 * @version Version 1.0
 */
@Entity
@Table(name="t_target")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Target
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
/**进度*/
private Double progress;
	/**进度开始，用于查询*/
private Double progressStart;
	/**进度结束，用于查询*/
private Double progressEnd;
/**截止时间*/
private Date deadLine;
	/**截止时间开始，用于查询*/
private Date deadLineStart;
	/**���止时间结束，用于查询*/
private Date deadLineEnd;
/**资源*/
private String resource;
/**检查项*/
private String checkItem;
/**输出品*/
private String output;
/**上级目标*/
private Target parent;
	/**上级目标模糊查询条件*/
private String parentQuery;
/**下级目标*/
private Set<Target> children;
	/**下级目标临时集合*/
private List<Target> childrenList;
/**关联值*/
private String key;
/**紧急程度*/
private Emergency emergency;
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
 * @param progress 要设置的进度
 */
public void setProgress(Double progress){
    this.progress = progress;
}
/**
 * @return Double 进度 
 */
@Column(name="progress",nullable=true)
public Double getProgress(){
		return this.progress;	
}
/**
  * @param progressStart 要设置的进度开始日期
  */
public void setProgressStart(Double progressStart){
    this.progressStart = progressStart;
}
/**
  * @return Double 进度开始日期
  */
@Transient
public Double getProgressStart(){
    return this.progressStart;
}
/**
  * @param progressEnd 要设置的进度结束日期
  */
public void setProgressEnd(Double progressEnd){
    this.progressEnd = progressEnd;
}
/**
  * @return Double 进度结束日期
  */
@Transient
public Double getProgressEnd(){
    return this.progressEnd;
}
/**
 * @param deadLine 要设置的截止时间
 */
public void setDeadLine(Date deadLine){
    this.deadLine = deadLine;
}
/**
 * @return Date 截止时间 
 */
@Column(name="dead_line",nullable=true)
public Date getDeadLine(){
		return this.deadLine;	
}
/**
  * @param deadLineStart 要设置的截止时间开始日期
  */
public void setDeadLineStart(Date deadLineStart){
    this.deadLineStart = deadLineStart;
}
/**
  * @return Date 截止时间开始日期
  */
@Transient
public Date getDeadLineStart(){
    return this.deadLineStart;
}
/**
  * @param deadLineEnd 要设置的截止时间结束日期
  */
public void setDeadLineEnd(Date deadLineEnd){
    this.deadLineEnd = deadLineEnd;
}
/**
  * @return Date 截止时间结束日期
  */
@Transient
public Date getDeadLineEnd(){
    return this.deadLineEnd;
}
/**
 * @param resource 要设置的资源
 */
public void setResource(String resource){
    this.resource = resource;
}
/**
 * @return String 资源 
 */
@Column(name="resource",length=255,columnDefinition="text",nullable=true)
public String getResource(){
		return this.resource;	
}
/**
 * @param checkItem 要设置的检查项
 */
public void setCheckItem(String checkItem){
    this.checkItem = checkItem;
}
/**
 * @return String 检查项 
 */
@Column(name="check_item",length=255,nullable=true)
public String getCheckItem(){
		return this.checkItem;	
}
/**
 * @param output 要设置的输出品
 */
public void setOutput(String output){
    this.output = output;
}
/**
 * @return String 输出品 
 */
@Column(name="output",length=255,nullable=true)
public String getOutput(){
		return this.output;	
}
/**
 * @param parent 要设置的上级目标
 */
public void setParent(Target parent){
    this.parent = parent;
}
/**
 * @param parentQuery 要设置的上级目标模糊查询条件
 */
public void setParentQuery(String parentQuery){
    this.parentQuery = parentQuery;
}
/**
 * @return Target 上级目标 
 */
@ManyToOne(targetEntity=com.huqiao.smartadmin.aimme.entity.Target.class,fetch=FetchType.LAZY)
@JoinColumn(name="parent",nullable=true)
@Fetch(FetchMode.SELECT)
@JsonIgnore
public Target getParent(){
		return this.parent;	
}
/**
 * @return  String 上级目标模糊查询条件
 */
@Transient
public String getParentQuery(){
    return this.parentQuery;
}
/**
 * @param children 要设置的下级目标
 */
public void setChildren(Set<Target> children){
    this.children = children;
}
/**
 * @return Set<Target> 下级目标 
 */
@OneToMany(targetEntity=com.huqiao.smartadmin.aimme.entity.Target.class,mappedBy="parent",fetch=FetchType.LAZY)
@Cascade(value = {CascadeType.SAVE_UPDATE,CascadeType.DELETE_ORPHAN})
@JsonIgnore
public Set<Target> getChildren(){
		return this.children;	
}
	/**
	 * @return  Target 获取getChildren对应的临时集合
	 */
	@Transient
	public List<Target> getChildrenList() {
		return childrenList;
	}
	/**
	 * @param  childrenList 要设置的下级目标对应的临时集合
	 */
	public void setChildrenList(List<Target> childrenList) {
		this.childrenList = childrenList;
	}
	/**
	*  转换children对应的临时集合到Set中<br/>
	*  方法通过检查rowGuard的值，来过滤掉"空对象"
	 * @param HttpServletRequest request
	 */
	public void childrenListToSet(HttpServletRequest request){
		if(children==null){
			children = new LinkedHashSet<Target>();
		}else{
			children.clear();
		}
		if(childrenList!=null){
			for(int i = 0;i<childrenList.size();i++){
				String rowGuard = request.getParameter("rowGuard" + i);
				if(rowGuard==null || rowGuard.trim().equals("")){
					continue;
				}
				Target tmptarget = childrenList.get(i);
				tmptarget.setParent(this);
				tmptarget.setManageKey(Md5Util.getManageKey());
				children.add(tmptarget);
			}
		}
	}
/**
 * @param key 要设置的关联值
 */
public void setKey(String key){
    this.key = key;
}
/**
 * @return String 关联值 
 */
@Column(name="key",length=255,nullable=true)
public String getKey(){
		return this.key;	
}
/**
 * @param emergency 要设置的紧急程度
 */
public void setEmergency(Emergency emergency){
    this.emergency = emergency;
}
/**
 * @return Emergency 紧急程度 
 */
@Column(name="emergency",nullable=true,columnDefinition="enum('Low','Mid','High')")
@Enumerated(EnumType.STRING)
public Emergency getEmergency(){
		return this.emergency;	
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Target other = null;
		try{
			other = (Target) obj;
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
		return "Target [manageKey=" + manageKey + "]";
	}
}