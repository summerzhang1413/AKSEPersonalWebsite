package com.springapp.service.impl;

import com.springapp.dao.NewsDao;
import com.springapp.domain.News;
import com.springapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsServiceImpl")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> findAllNews() {
        return newsDao.findAllNews();

    }

    @Override
    public void insert(News news) {
        newsDao.insert(news);
    }

    @Override
    public void delete(int id) {
        newsDao.delete(id);
    }

    @Override
    public News findById(int id) {
        return newsDao.findById(id);
    }


}
