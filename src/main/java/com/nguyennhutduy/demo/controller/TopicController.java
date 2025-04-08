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
import org.springframework.web.bind.annotation.RestController;

import com.nguyennhutduy.demo.entity.Topic;
import com.nguyennhutduy.demo.service.TopicService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/topics")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    // Create Topic
    // http://localhost:8081/api/topics
    @PostMapping
    public ResponseEntity<?> createTopic(@RequestBody Topic topic) {
        try {
            Topic savedTopic = topicService.createTopic(topic);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTopic);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get Topic by ID
    // http://localhost:8081/api/topics/{id}
    @GetMapping("{id}")
    public ResponseEntity<?> getTopicById(@PathVariable("id") Long topicId) {
        try {
            Topic topic = topicService.getTopicById(topicId);
            return ResponseEntity.ok(topic);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Get All Topics
    // http://localhost:8081/api/topics/
    @GetMapping
    public ResponseEntity<?> getAllTopic() {
        try {
            List<Topic> topics = topicService.getAllTopic();
            return ResponseEntity.ok(topics);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Update Topic
    // http://localhost:8081/api/topics/{id}
    @PutMapping("{id}")
    public ResponseEntity<?> updateTopic(@PathVariable("id") Long topicId,
            @RequestBody Topic topic) {
        try {
            topic.setId(topicId);
            Topic updatedTopic = topicService.updateTopic(topic);
            return ResponseEntity.ok(updatedTopic);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }

    // Delete Topic
    // http://localhost:8081/api/topics/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long topicId) {
        try {
            topicService.deleteTopic(topicId);
            return ResponseEntity.ok("Topic successfully deleted!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
        }
    }
}
