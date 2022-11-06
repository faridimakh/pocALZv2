package com.vishaluplanch.stream.kafka.serde;

import com.vishaluplanch.stream.kafka.model.WikiChange;

public final class ordderserdes extends WrapperSerde<WikiChange> {
    public ordderserdes() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(WikiChange.class));
    }
}
