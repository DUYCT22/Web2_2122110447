package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Post;

public interface PostService {
    Post createPost(Post post);

    Post getPostById(Long postId);

    List<Post> getAllPost();

    Post updatePost(Post post);

    void deletePost(Long postId);
}
