package com.springapp.mvc;


import com.springapp.domain.News;
import com.springapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/frontStage")
public class FrontStageController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/showAllNews")
    public String showAllNews(Model model){
        List<News> allNews = newsService.findAllNews();
        model.addAttribute("allnews", allNews);
        return "allNews_front";
    }

    @RequestMapping("/showDetailsNews")
    public String showDetailsNews(Model model, HttpServletRequest request){
        String param = request.getParameter("id");
        int id = Integer.valueOf(param);
        News byId = newsService.findById(id);
        model.addAttribute("detailsNews", byId);
        return "detailsNews";
    }

}
