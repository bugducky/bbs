package com.yql.demo.service;

import com.yql.demo.dao.CommentDao;
import com.yql.demo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDao cd;

    public void updateComment(Comment c) {
        c.setComment_date(new Timestamp(new Date().getTime()).toString());
        cd.updateComment(c);
    }

    public void delComment(Comment c) {
        cd.delComment(c.getComment_id());
    }

    public void subComment(Comment c) {
        c.setComment_date(new Timestamp(new Date().getTime()).toString());
        cd.subComment(c);
    }


    public List<Comment> getComments(String comment_a_id) {
        return cd.getComments(comment_a_id);
    }
}
