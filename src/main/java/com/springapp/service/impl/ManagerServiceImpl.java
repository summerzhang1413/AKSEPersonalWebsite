package com.springapp.service.impl;

import com.springapp.dao.ManagerDao;
import com.springapp.domain.Manager;
import com.springapp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("managerServiceImpl")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager findByNameAndPwd(String name, String pwd) {
        return managerDao.findByNameAndPwd(name, pwd);
    }


}
