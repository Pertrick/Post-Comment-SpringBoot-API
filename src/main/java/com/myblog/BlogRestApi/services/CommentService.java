package com.myblog.BlogRestApi.services;

import com.myblog.BlogRestApi.domain.Comment;
import com.myblog.BlogRestApi.exception.ResourceNotFoundException;
import com.myblog.BlogRestApi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment getComment(Integer id){
        return commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No comment found with id="+ id)
        );
    }

    public Comment updateComment(Comment comment, Integer id){
        commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No comment found with id="+id)
        );
        return commentRepository.save(comment);
    }

    public void deleteComment(Integer id){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No comment found with id="+id)
        );
        commentRepository.deleteById(comment.getId());
    }
}
