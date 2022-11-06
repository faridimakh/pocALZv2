package com.fullstackmaina.producerservice.conf;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class topicCreation {

    @Bean
    public NewTopic topicuser() {
        return TopicBuilder.name("db-topic")
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic wikichangesresponses_og() {

        return TopicBuilder.name("wikichangesresponses-log").partitions(3).compact().build();
    }

    @Bean
    public NewTopic wikichangesresponses_edit() {
        return TopicBuilder.name("wikichangesresponses-edit").partitions(3).compact().build();
    }

    @Bean
    public NewTopic wikichangesresponses_categorize() {
        return TopicBuilder.name("wikichangesresponses-categorize").partitions(3).compact().build();
    }

    @Bean
    public NewTopic wikichangesresponses_new() {
        return TopicBuilder.name("wikichangesresponses-new").partitions(3).compact().build();
    }

}

