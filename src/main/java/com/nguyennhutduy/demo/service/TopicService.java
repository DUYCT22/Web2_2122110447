package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Topic;

public interface TopicService {
    Topic createTopic(Topic topic);

    Topic getTopicById(Long topicId);

    List<Topic> getAllTopic();

    Topic updateTopic(Topic topic);

    void deleteTopic(Long topicId);
}
