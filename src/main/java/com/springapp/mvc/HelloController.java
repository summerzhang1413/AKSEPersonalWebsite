package com.springapp.mvc;

import com.springapp.domain.News;
import com.springapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private NewsService newsService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(Model model) {
		model.addAttribute("message", "Hello world!");

        model.addAttribute("allnews", getPresentNews());

        return "home";
	}

    @RequestMapping("/home")
    public String toHome(Model model){
        model.addAttribute("allnews", getPresentNews());
        return "home";
    }

    @RequestMapping("/index")
    public String indexManager(){
        return "manager";
    }

    private List<News> getPresentNews(){
        List<News> allNews = newsService.findAllNews();
        List<News> presentNews = new ArrayList<News>();
        if (allNews.size() > 5) {
            for (int i = 0; i < 6; i++) {
                presentNews.add(i, allNews.get(i));
            }
            return presentNews;
        }
        return allNews;
    }


}  