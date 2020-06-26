package com.yql.demo.service;

import com.yql.demo.dao.ArticleDao;
import com.yql.demo.dao.SortDao;
import com.yql.demo.entity.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {
    @Autowired
    SortDao dao;
    @Autowired
    ArticleDao ad;

    public List<Sort> getAllSort() {
        return dao.getAllSort();
    }

    public void addSort(String str) {
        dao.addSort(str);
    }

    public void delSort(int sort_id) {
        dao.delSort(sort_id);
        ad.delArticleBySortID(sort_id);
    }

    public Sort getSortByID(int sort_id) {
        return dao.getSortByID(sort_id);
    }

    public void updateSort(Sort sort) {
        dao.updateSortName(sort.getSort_id(), sort.getSort_name());
    }

}
