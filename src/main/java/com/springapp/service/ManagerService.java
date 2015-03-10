package com.springapp.service;


import com.springapp.domain.Manager;

public interface ManagerService {

    public Manager findByNameAndPwd(String name, String pwd);
}
