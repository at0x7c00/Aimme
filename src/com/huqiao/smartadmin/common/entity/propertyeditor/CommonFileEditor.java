package com.huqiao.smartadmin.common.entity.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.List;

import com.huqiao.smartadmin.common.entity.CommonFile;
import com.huqiao.smartadmin.common.service.ICommonFileService;
/**
 * 文件编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class CommonFileEditor extends PropertyEditorSupport {
	private ICommonFileService fileeService;

	public CommonFileEditor(ICommonFileService fileeService) {
		this.fileeService = fileeService;
	}

	public String getAsText() {
		CommonFile filee = (CommonFile) getValue();
		if (filee == null)
			return "";
		return String.valueOf(filee.getId());
	}

	public void setAsText(String id) throws IllegalArgumentException {
		CommonFile filee = new CommonFile();
		List<CommonFile> list = fileeService.getByProperty(CommonFile.class,"manageKey", id);
		if(list!=null && list.size()>0){
			filee = list.get(0);
		}
		setValue(filee);
	}
}