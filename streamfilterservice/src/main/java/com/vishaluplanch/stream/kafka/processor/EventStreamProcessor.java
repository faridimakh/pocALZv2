package com.vishaluplanch.stream.kafka.processor;

import com.vishaluplanch.stream.kafka.model.WikiChange;
import com.vishaluplanch.stream.kafka.serde.ordderserdes;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class EventStreamProcessor {

    @Autowired
    private StreamsBuilder streamsBuilder;

    @PostConstruct
    public void streamTopology() {
        Predicate<String, WikiChange> edit = (s, wikiChange) -> wikiChange.getType().equalsIgnoreCase("edit");
        Predicate<String, WikiChange> log = (s, wikiChange) -> wikiChange.getType().equalsIgnoreCase("log");
        Predicate<String, WikiChange> ne_w = (s, wikiChange) -> wikiChange.getType().equalsIgnoreCase("new");
        Predicate<String, WikiChange> categorize = (s, wikiChange) -> wikiChange.getType().equalsIgnoreCase("categorize");
        Serde<WikiChange> orderSerde = new ordderserdes();
        KStream<String, WikiChange> kStream = streamsBuilder.stream("db-topic", Consumed.with(Serdes.String(), orderSerde));
        KStream<String, WikiChange>[] kk = kStream.branch(edit, log, ne_w, categorize);
        kk[0].to("wikichangesresponses-edit", Produced.with(Serdes.String(), orderSerde));
        kk[1].to("wikichangesresponses-log", Produced.with(Serdes.String(), orderSerde));
        kk[2].to("wikichangesresponses-new", Produced.with(Serdes.String(), orderSerde));
        kk[3].to("wikichangesresponses-categorize", Produced.with(Serdes.String(), orderSerde));
    }
}
