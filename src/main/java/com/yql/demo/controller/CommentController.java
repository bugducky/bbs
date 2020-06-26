package com.yql.demo.controller;


import com.yql.demo.entity.Comment;
import com.yql.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
public class CommentController {
    @Autowired
    CommentService cs;

    @PostMapping("/comment/submit")
    public void subComment(@RequestBody Comment c) {
        c.setComment_date(new Timestamp(new Date().getTime()).toString());
        cs.subComment(c);
    }

    @PostMapping("/comment/getComment")
    public List<Comment> getComments(@RequestBody Comment c) {
        return cs.getComments(c.getComment_a_id());
    }

    @PostMapping("/comment/update")
    public void updateComment(@RequestBody Comment c) {
        cs.updateComment(c);
    }

    @PostMapping("/comment/del")
    public void delComment(@RequestBody Comment c) {
        cs.delComment(c);
    }


}
