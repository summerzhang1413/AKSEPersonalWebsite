package com.springapp.mvc;

import com.springapp.domain.Manager;
import com.springapp.domain.News;
import com.springapp.service.ManagerService;
import com.springapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/managePage")
public class ManagerController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private NewsService newsService;


    @RequestMapping("/login2")
    public String login(){
        return "manager";
    }

    @RequestMapping(value = "/login")
    public void login(Manager manager, HttpServletResponse response) throws Exception{

        Manager manager2 = managerService.findByNameAndPwd(manager.getName(), manager.getPwd());
        if (manager2 == null){
            response.sendRedirect("/managePage/login2");
            httpSession.setAttribute("login_error", "用户名或密码错误");
            return;
        }
        httpSession.setAttribute("sessionManager", manager2);
        response.sendRedirect("/managePage/login2");
    }

    @RequestMapping(value = "/logout2")
    public String logout(){
        return "logout";
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletResponse response) throws IOException {
        Object sessionManager = httpSession.getAttribute("sessionManager");
        if (sessionManager == null){
            response.sendRedirect("/managePage/logout2");
            httpSession.setAttribute("logout_error",  "请先登录！");
            return;
        }
        httpSession.removeAttribute("sessionManager");
        response.sendRedirect("/managePage/logout2");
    }

    @RequestMapping("/showAllNews")
    public String showAllNews(Model model){
        List<News> allNews = newsService.findAllNews();
        model.addAttribute("allnews", allNews);
        return "allNews";
    }

    @RequestMapping("/toAddNews")
    public String toAddNews(){
        return "addNews";
    }

    @RequestMapping("/addNews")
    public void addNews(News news, HttpServletResponse response) throws IOException{
        News news2 = new News();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        news2.setTitle(news.getTitle());
        news2.setTime(time);
        news2.setContent(news.getContent());

        newsService.insert(news2);
        response.sendRedirect("/managePage/showAllNews");
    }

    @RequestMapping("/deleteNews")
    public void deleteNews(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String param = request.getParameter("id");
        int id = Integer.valueOf(param);
        newsService.delete(id);
        response.sendRedirect("/managePage/showAllNews");
    }


}
