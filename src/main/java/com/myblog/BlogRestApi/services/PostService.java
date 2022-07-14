package com.myblog.BlogRestApi.services;

import com.myblog.BlogRestApi.domain.Post;
import com.myblog.BlogRestApi.exception.ResourceNotFoundException;
import com.myblog.BlogRestApi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPost(Integer id){
        return postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No post found with id="+id)
        );
    }

    public Post updatePost(Post post, Integer id) {
        postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No Product found with id=" + id)
        );

        return postRepository.save(post);

    }


    public void deletePost(Integer id){
      Post post =  postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No Product found with id=" + id)
        );

        postRepository.deleteById(post.getId());
    }




}
