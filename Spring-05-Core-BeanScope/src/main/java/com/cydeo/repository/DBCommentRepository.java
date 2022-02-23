package com.cydeo.repository;

import com.cydeo.model.Comment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component @Primary
public class DBCommentRepository implements  CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment " + comment.getText());
    }
}
