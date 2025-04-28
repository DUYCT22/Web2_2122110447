package com.nguyennhutduy.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyennhutduy.demo.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
