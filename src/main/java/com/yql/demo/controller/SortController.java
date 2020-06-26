package com.yql.demo.controller;

import com.yql.demo.entity.Sort;
import com.yql.demo.service.ArticleService;
import com.yql.demo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
public class SortController {

    @Autowired
    SortService ss;
    @Autowired
    ArticleService as;

    @GetMapping("/sort/getall")
    public List<Sort> getAllSort() {
        return ss.getAllSort();
    }

    @PostMapping("/sort/add")
    public void addSort(@RequestBody Sort s) {
        ss.addSort(s.getSort_name());
    }

    @PostMapping("/sort/del")
    public void delSort(@RequestBody Sort s) {
        ss.delSort(s.getSort_id());
    }

    @GetMapping("/sort/get/{sort_id}")
    public Sort getSortByID(@PathVariable int sort_id) {
        return ss.getSortByID(sort_id);
    }

    @PostMapping("/sort/update")
    public void updateSort(@RequestBody Sort s) {
        ss.updateSort(s);
    }

}
