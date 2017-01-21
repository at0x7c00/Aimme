package com.huqiao.smartadmin.common.entity.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.huqiao.smartadmin.common.entity.CommonFolder;
import com.huqiao.smartadmin.common.service.ICommonFolderService;

/**
 * 文件夹编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class CommonFolderEditor extends PropertyEditorSupport {
	private ICommonFolderService commonFolderService;

	public CommonFolderEditor(ICommonFolderService commonFolderService) {
		this.commonFolderService = commonFolderService;
	}

	public String getAsText() {
		CommonFolder commonFolder = (CommonFolder) getValue();
		if (commonFolder == null)
			return "";
		return String.valueOf(commonFolder.getId());
	}

	public void setAsText(String id) throws IllegalArgumentException {
		CommonFolder commonFolder = new CommonFolder();
		Integer integerId = null;
		try {
			integerId = Integer.parseInt(id);
		} catch (Exception e) {
		}
		commonFolder = commonFolderService.getById(CommonFolder.class, integerId);
		setValue(commonFolder);
	}
}