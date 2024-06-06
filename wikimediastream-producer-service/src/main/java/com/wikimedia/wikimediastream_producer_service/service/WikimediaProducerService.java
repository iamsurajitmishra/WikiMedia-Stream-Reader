package com.wikimedia.wikimediastream_producer_service.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Service
public class WikimediaProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaProducerService.class);

    private static final String URL = "https://stream.wikimedia.org/v2/stream/recentchange";
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recent_change";
        //To read real time stream data from wiki media
        EventHandler eventHandler= new WikiMediaChangesHandler(kafkaTemplate, topic);

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(URL));

        EventSource  eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

    }


}
