package com.springapp.dao;


import com.springapp.domain.Manager;

public interface ManagerDao {

    public Manager findByNameAndPwd(String name, String pwd);
}
