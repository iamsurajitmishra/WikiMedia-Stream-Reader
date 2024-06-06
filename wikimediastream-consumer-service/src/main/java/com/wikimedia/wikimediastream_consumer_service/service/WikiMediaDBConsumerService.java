package com.wikimedia.wikimediastream_consumer_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaDBConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaDBConsumerService.class);

    @KafkaListener(topics = "wikimedia_recent_change", groupId = "wikimedia-kf")
    public void consumeWikiMediaStream(String eventMessage) {
            LOGGER.info(String.format("Event message received: %s",eventMessage));
    }
}
