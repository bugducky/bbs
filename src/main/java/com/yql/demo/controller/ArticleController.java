package com.yql.demo.controller;

import com.yql.demo.dao.ArticleDao;
import com.yql.demo.entity.Article;
import com.yql.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin({"http://localhost:8080",})
@RestController
public class ArticleController {


    @Autowired
    ArticleService as;

    @GetMapping("/article/getarticle/{a_id}")
    public Article getArticleFromID(@PathVariable String a_id) {
        return as.getArticleFromID(a_id);
    }

    @GetMapping("/article/sortid/props/{sort_id}")
    public List<Article> getArticlesPropsFromSortID(@PathVariable int sort_id) {
        return as.getArticlesPropsFromSortID(sort_id);
    }

    @GetMapping("/article/sortid/{sort_id}")
    public List<Article> getArticlesFromSortID(@PathVariable int sort_id) {
        return as.getArticlesFromSortID(sort_id);
    }

    @PostMapping("/article/post")
    public void postArticle(@RequestBody Article a) {
        a.setA_time(new Timestamp(new Date().getTime()).toString());
        as.postArticle(a);
    }
}
