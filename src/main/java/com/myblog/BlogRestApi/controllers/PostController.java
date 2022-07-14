package com.myblog.BlogRestApi.controllers;

import com.myblog.BlogRestApi.domain.Post;
import com.myblog.BlogRestApi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/post")
public class PostController {
    @Autowired
    private PostService postService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Post addPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @GetMapping(value = "")
    public List<Post> allPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value="/{id}")
    public Post getPost(@PathVariable("id") Integer id){
        return postService.getPost(id);
    }

    @PutMapping(value = "/{id}")
    public Post updatePost(@PathVariable("id") Integer id, @RequestBody Post post){
        return postService.updatePost(post,id);
    }


    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable("id") Integer id){
        postService.deletePost(id);
    }


}
