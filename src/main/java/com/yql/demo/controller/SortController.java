package com.yql.demo.controller;

import com.yql.demo.dao.SortDao;
import com.yql.demo.entity.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("http://localhost:8080")
@RestController
public class SortController {

    @Autowired
    SortDao dao;

    @GetMapping("/sort/getAll")
    public ArrayList<Sort> getAllSort() {
        return dao.getAllSort();
    }



}
