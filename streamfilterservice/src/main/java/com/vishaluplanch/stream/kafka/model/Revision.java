package com.vishaluplanch.stream.kafka.model;

import lombok.Data;

@Data
public class Revision {
    private Long old;
    private Long revised;

}