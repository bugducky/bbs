package com.yql.demo.service;


import com.yql.demo.dao.ArticleDao;
import com.yql.demo.dao.SortDao;
import com.yql.demo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
