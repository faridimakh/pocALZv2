package com.fullstackmaina.producerservice.service;

import com.fullstackmaina.producerservice.model.WikiChange;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaProducerwikichangeService {

    private static final String TOPIC = "db-topic";

    @Autowired
    private KafkaTemplate<String, WikiChange> kafkaTemplate;

    public void send(WikiChange wikiChange) {
        log.info("Order object is {}", wikiChange);
        kafkaTemplate.send(TOPIC, wikiChange.get_id(), wikiChange);
    }
}
