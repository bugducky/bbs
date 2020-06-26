package com.yql.demo.service;


import com.yql.demo.dao.ArticleDao;
import com.yql.demo.dao.SortDao;
import com.yql.demo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleService {

    @Autowired
    ArticleDao ad;
    @Autowired
    SortDao sd;

    public Article getArticleFromID(String a_id) {
        return ad.getArticleFromID(a_id);
    }

    public List<Article> getArticlesPropsFromSortID(int sort_id) {
        return ad.getArticlePropertyBySortID(sort_id);
    }


    public List<Article> getArticlesFromSortID(int sort_id) {
        return ad.getArticlesFromSortID(sort_id);
    }

    public void postArticle(Article a) {
        ad.postArticle(a);
        sd.addArticleNum(a.getA_sort_id());
    }

}
