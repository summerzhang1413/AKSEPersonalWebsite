package com.springapp.dao;

import com.springapp.domain.BaseDomain;

import java.util.List;


public interface BaseDao {

    public void save(BaseDomain obj);

    public void delete(BaseDomain obj);

    public void update(BaseDomain obj);
    //@param queryString 查询数据的hql语句
    public List find(String queryString);
    //根据传入的参数param进行hql查询
    public List find(String queryString, Object param);

}
