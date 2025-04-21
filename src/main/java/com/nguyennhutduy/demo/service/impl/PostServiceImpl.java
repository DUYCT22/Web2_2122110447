package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Post;
import com.nguyennhutduy.demo.repository.PostRepository;
import com.nguyennhutduy.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(
                postId)
                .orElseThrow(() -> new RuntimeException("Post with ID " + postId + " not found"));
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Post post) {
        Post existingPost = postRepository.findById(post.getId())
                .orElseThrow(() -> new RuntimeException("Post not found"));
        if (post.getTopic() != null && !post.getTopic().equals(existingPost.getTopic())) {
            existingPost.setTopic(post.getTopic());
        }
        if (post.getTitle() != null && !post.getTitle().equals(existingPost.getTitle())) {
            existingPost.setTitle(post.getTitle());
        }
        if (post.getDetail() != null && !post.getDetail().equals(existingPost.getDetail())) {
            existingPost.setDetail(post.getDetail());
        }
        if (post.getStatus() != 0 && post.getStatus() != existingPost.getStatus()) {
            existingPost.setStatus(post.getStatus());
        }
        existingPost.setUpdatedBy(post.getUpdatedBy());
        return postRepository.save(existingPost);
    }

    @Override
    public void deletePost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new RuntimeException("Post with ID " + postId + " not found");
        }
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> createListPost(List<Post> post) {
        return postRepository.saveAll(post);
    }

}
