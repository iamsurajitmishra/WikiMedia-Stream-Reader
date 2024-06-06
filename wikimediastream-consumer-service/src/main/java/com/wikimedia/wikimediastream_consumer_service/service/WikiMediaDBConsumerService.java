package com.wikimedia.wikimediastream_consumer_service.service;

import com.wikimedia.wikimediastream_consumer_service.entity.WikiMediaEntityData;
import com.wikimedia.wikimediastream_consumer_service.repository.WikiMediaEventDataRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WikiMediaDBConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaDBConsumerService.class);

    private WikiMediaEventDataRepository  wikiMediaEventDataRepository;

    @KafkaListener(topics = "wikimedia_recent_change", groupId = "wikimedia-kf")
    public void consumeWikiMediaStream(String eventMessage) {
            LOGGER.info(String.format("Event message received: %s",eventMessage));
        WikiMediaEntityData wikiMediaEntityData = new WikiMediaEntityData();
        wikiMediaEntityData.setWikiMediaEventData(eventMessage);
        wikiMediaEventDataRepository.save(wikiMediaEntityData);
    }
}
