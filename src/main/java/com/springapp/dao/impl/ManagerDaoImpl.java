package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.ManagerDao;
import com.springapp.domain.Manager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("managerDaoImpl")
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    public BaseDao baseDao;

    public SessionFactory sessionFactory;

    @Resource(name="sessionFactory")
    private void setSessionFactory(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public Manager findByNameAndPwd(String name, String pwd) {
        String hql = "from Manager n where n.name = ? and n.pwd = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, name);
        query.setParameter(1, pwd);
        List<Manager> manager_list = query.list();
        if (manager_list == null || manager_list.size() == 0) {
            return null;
        }
        return manager_list.get(0);
    }


}
