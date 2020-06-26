package com.yql.demo.controller;


import com.yql.demo.dao.CommentDao;
import com.yql.demo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
public class CommentController {
    @Autowired
    CommentDao dao;

    @PostMapping("/comment/submit")
    public boolean subComment(@RequestBody Comment c) {
        c.setComment_date(new Timestamp(new Date().getTime()).toString());
        return dao.subComment(c);
    }

    @PostMapping("/comment/getComment")
    public List<Comment> getComments(@RequestBody Comment c) {
        return dao.getComments(c.getComment_a_id());
    }

}
