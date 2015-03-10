package com.springapp.dao.impl;


import com.springapp.dao.BaseDao;
import com.springapp.dao.NewsDao;
import com.springapp.domain.News;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("newsDaoImpl")
public class NewsDaoImpl implements NewsDao{

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
    public List<News> findAllNews() {
        String hql = "from News";
        Query query = getSession().createQuery(hql);
        List<News> newsList = query.list();
        return newsList;
    }

    @Override
    public void insert(News news) {
        baseDao.save(news);
    }

    @Override
    public void delete(int id) {
        String hql = "delete News n where n.id = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        query.executeUpdate();
    }

    @Override
    public News findById(int id) {
        String hql = "from News n where n.id = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        List<News> list = query.list();
        return list.get(0);
    }
}
