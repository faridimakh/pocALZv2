package com.fullstackmaina.producerservice.controller;

import com.fullstackmaina.producerservice.model.WikiChange;
import com.fullstackmaina.producerservice.service.KafkaProducerwikichangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class wikichangeController {

    @Autowired
    private KafkaProducerwikichangeService kafkaProducerService;

    @PostMapping("/post")
    public void order(@RequestBody List<WikiChange> wikiChanges) {
        for (WikiChange wikiChange : wikiChanges) {
            kafkaProducerService.send(wikiChange);
        }
    }

}
