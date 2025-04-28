package com.nguyennhutduy.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyennhutduy.demo.entity.Post;
import com.nguyennhutduy.demo.repository.PostRepository;
import com.nguyennhutduy.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    // Create Post
    // http://localhost:8081/api/posts
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try {
            Post savedPost = postService.createPost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Create List Post
    // http://localhost:8081/api/posts/list
    @PostMapping("/list")
    public ResponseEntity<?> createListPost(@RequestBody List<Post> post) {
        try {
            List<Post> savedPost = postService.createListPost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get Post by ID
    // http://localhost:8081/api/posts/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long postId) {
        try {
            Post post = postService.getPostById(postId);
            return ResponseEntity.ok(post);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All Posts
    // http://localhost:8081/api/posts/
    @GetMapping
    public ResponseEntity<?> getAllPost() {
        try {
            List<Post> posts = postService.getAllPost();
            return ResponseEntity.ok(posts);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update Post
    // http://localhost:8081/api/posts/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updatePost(@PathVariable("id") Long postId,
            @RequestBody Post post) {
        try {
            post.setId(postId);
            Post updatedPost = postService.updatePost(post);
            return ResponseEntity.ok(updatedPost);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete Post
    // http://localhost:8081/api/posts/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok("Post successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
