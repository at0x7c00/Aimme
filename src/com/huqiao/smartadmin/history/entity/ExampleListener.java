package com.huqiao.smartadmin.history.entity;

import org.hibernate.envers.RevisionListener;

import com.huqiao.smartadmin.util.web.LoginInfo;
import com.novots.itsm.util.threadlocal.ThreadLocalUtil;

public class ExampleListener implements RevisionListener {
	
    public void newRevision(Object revisionEntity) {
        TestRevisionEntity exampleRevEntity = (TestRevisionEntity) revisionEntity;
        LoginInfo loginInfo = (LoginInfo)ThreadLocalUtil.loginInfoThreadLocal.get();
        if(loginInfo==null){
        	return;
        }
        exampleRevEntity.setUsername(loginInfo.getUser().getUsername());
    }
}