package com.wikimedia.wikimediastream_producer_service.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
public class WikiMediaChangesHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesHandler.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info("Received WikiMedia changes: {}", messageEvent);
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
