package com.wikimedia.wikimediastream_producer_service.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;


@Service
public class WikimediaProducerService {

    @Value("${spring.kafka.topic.name}")
    private String topic ;

    @Value("${wiki.media.stream.source.url}")
    private String url;


    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {

        //To read real time stream data from wiki media
        EventHandler eventHandler= new WikiMediaChangesHandler(kafkaTemplate, topic);

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));

        EventSource  eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

    }


}
