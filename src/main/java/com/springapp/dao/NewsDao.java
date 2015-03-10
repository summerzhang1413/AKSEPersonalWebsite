package com.springapp.dao;


import com.springapp.domain.News;

import java.util.List;

public interface NewsDao {

    public List<News> findAllNews();

    public void insert(News news);

    public void delete(int id);

    public News findById(int id);

}
