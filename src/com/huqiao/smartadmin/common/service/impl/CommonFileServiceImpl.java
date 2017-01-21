package com.huqiao.smartadmin.common.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.huqiao.smartadmin.common.dao.ICommonFileDao;
import com.huqiao.smartadmin.common.entity.CommonFile;
import com.huqiao.smartadmin.common.entity.CommonFolder;
import com.huqiao.smartadmin.common.service.ICommonFileService;
import com.huqiao.smartadmin.util.web.Page;

/**
 *  文件Service实现
 * @author NOVOTS
 * @version Version 1.0
 */
@Service
public class CommonFileServiceImpl extends BaseServiceImpl<CommonFile> implements ICommonFileService {
	
    /**定义Log日志*/
    private final Logger log = Logger.getLogger(CommonFileServiceImpl.class);
    /**文件dao*/
    @Resource
    private ICommonFileDao fileeDao;
    
    @Override
    public Page<CommonFile> getPage(CommonFile filee,Page pageInfo) {
        int countRecord = fileeDao.findRowCount(filee).intValue();
        Page<CommonFile>  page = new Page<CommonFile>(pageInfo == null?0:pageInfo.getPageNum(),countRecord,pageInfo.getNumPerPage());
        List<CommonFile> fileeList = fileeDao.findPage(filee,page.getStartIndex(), page.getNumPerPage(),pageInfo.getOrderField(),pageInfo.getOrderDirection());
        page.setList(fileeList);
        page.setOrderDirection(pageInfo.getOrderDirection()==null?"asc":pageInfo.getOrderDirection());
        page.setOrderField(pageInfo.getOrderField()==null?"id":pageInfo.getOrderField());
        return page;
    }
    /**
     * 导出文件记录
     * @param response HttpServletResponse对象
     * @param wb excel页
     * @param strFileName 文件名
     * @throws Exception 抛出异常
     */
    public static void exportExcelFile(HttpServletResponse response,
			HSSFWorkbook wb, String strFileName) throws Exception {
		try {
			ServletOutputStream out = response.getOutputStream();
			strFileName = URLEncoder.encode(strFileName,"UTF-8");

//			response.setContentType("application/attachment");
			response.setContentType("application/msexcel;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + strFileName);
			
			try {
				wb.write(out);
				out.close();
			} catch (Exception e) {
				//throw new MisException("用户取消文件导出！" + e.toString());
			}
			// log.info(misEx.getInfo());
		} catch (Exception e) {
			//log.error("文件导出时出错！", e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean downLoadFile(HttpServletResponse response, String key) {
		List<CommonFile> fileeList = this.getByProperty(CommonFile.class, "manageKey", key);
		if(fileeList ==null || fileeList.size() == 0){
			log.error("文件未找到");
			return false;
		}else{
			CommonFile filee = fileeList.get(0);
			CommonFolder comFolder = filee.getFolder();
			String strFileFullPath = "";
			String strFileName = "";

			strFileFullPath = comFolder.getStorePath();

			if ("".equals(filee.getExtensionName())) {
				strFileName = filee.getManageKey();
			} else {
				strFileName = filee.getManageKey();
			}
			
			// 读出文件写入response 对象中
			File file1 = null;
			file1 = new File(strFileFullPath+File.separator+strFileName);
			
			try {
				ServletOutputStream out = response.getOutputStream();
				FileInputStream sIS = new FileInputStream(file1);
				int availInt = sIS.available();
				byte b[] = new byte[availInt];
				int readOut = sIS.read(b);
				strFileName = new String(strFileName.getBytes("GBK"), "ISO-8859-1");
				//response.setContentType("application/msexcel;charset=UTF-8");
				response.setContentType("application/attachment");
				response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filee.getName(),"UTF-8"));

				try {
					out.write(b);
					out.close();
				} catch (Exception e) {

				}
				sIS.close();
			} catch (Exception e) {
				log.error("文件下载时出错！" + e.toString());
			}
			return true;
		}
	}
	/* (非 Javadoc)
	 * <p>Title: queryByKey</p>
	 * <p>Description: </p>
	 * @param queryKey
	 * @param pageInfo
	 * @return
	 * @see com.huqiao.smartadmin.common.service.ICommonFileService#queryByKey(java.lang.String, com.huqiao.smartadmin.util.web.Page)
	 */
	@Override
	public Page<CommonFile> queryByKey(String queryKey, Page<CommonFile> pageInfo) {
		// TODO Auto-generated method stub
		int countRecord = fileeDao.findRowCount(queryKey).intValue();
		Page<CommonFile> page = new Page<CommonFile>(pageInfo == null ? 0 : pageInfo.getPageNum(), countRecord, pageInfo.getNumPerPage());
		List<CommonFile> commonFiles = fileeDao.findByKey(pageInfo,queryKey);
		page.setList(commonFiles);
		
		return page;
	}
	
	public void delete(CommonFile file){
		new File(file.getFullName()).delete();
		fileeDao.delete(file);
	}
}