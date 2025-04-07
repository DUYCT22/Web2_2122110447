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
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic savedTopic = topicService.createTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTopic);
    }

    // Get Topic by ID
    // http://localhost:8081/api/topics/{id}
    @GetMapping("{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable("id") Long topicId) {
        Topic topic = topicService.getTopicById(topicId);
        return ResponseEntity.ok(topic);
    }

    // Get All Topics
    // http://localhost:8081/api/topics/
    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopic() {
        List<Topic> topics = topicService.getAllTopic();
        return ResponseEntity.ok(topics);
    }

    // Update Topic
    // http://localhost:8081/api/topics/{id}
    @PutMapping("{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable("id") Long topicId,
            @RequestBody Topic topic) {
        topic.setId(topicId);
        Topic updatedTopic = topicService.updateTopic(topic);
        return ResponseEntity.ok(updatedTopic);
    }

    // Delete Topic
    // http://localhost:8081/api/topics/
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long topicId) {
        topicService.deleteTopic(topicId);
        return ResponseEntity.ok("Topic successfully deleted!");
    }
}
