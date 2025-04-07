package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Topic;
import com.nguyennhutduy.demo.repository.TopicRepository;
import com.nguyennhutduy.demo.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic getTopicById(Long topicId) {
        return topicRepository.findById(
                topicId)
                .orElseThrow(() -> new RuntimeException("Topic with ID " + topicId + " not found"));
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    @Override
    public Topic updateTopic(Topic topic) {
        Topic existingTopic = topicRepository.findById(topic.getId())
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        if (topic.getName() != null && !topic.getName().equals(existingTopic.getName())) {
            existingTopic.setName(topic.getName());
        }
        existingTopic.setUpdatedBy(topic.getUpdatedBy());
        return topicRepository.save(existingTopic);
    }

    @Override
    public void deleteTopic(Long topicId) {
        if (!topicRepository.existsById(topicId)) {
            throw new RuntimeException("Topic with ID " + topicId + " not found");
        }
        topicRepository.deleteById(topicId);
    }

}
