package com.myblog.BlogRestApi.controllers;

import com.myblog.BlogRestApi.domain.Comment;
import com.myblog.BlogRestApi.domain.Post;
import com.myblog.BlogRestApi.services.CommentService;
import com.myblog.BlogRestApi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/post")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/{id}/comments")
    public void  createPostComment(@RequestBody Comment comment, @PathVariable Integer id){
        Post post = postService.getPost(id);

        post.getComment().add(comment);

    }

    @DeleteMapping(value = "/{postId}/comments/{commentId}")
    public void DeletePostComment(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId){

        commentService.deleteComment(commentId);

    }

}
