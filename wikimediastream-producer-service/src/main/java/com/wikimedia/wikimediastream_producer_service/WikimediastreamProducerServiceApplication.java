package com.wikimedia.wikimediastream_producer_service;

import com.wikimedia.wikimediastream_producer_service.service.WikimediaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediastreamProducerServiceApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(WikimediastreamProducerServiceApplication.class, args);
	}

	@Autowired
	private WikimediaProducerService wikimediaProducerService;

	@Override
	public void run(String... args) throws Exception {
		wikimediaProducerService.sendMessage();
	}
}
