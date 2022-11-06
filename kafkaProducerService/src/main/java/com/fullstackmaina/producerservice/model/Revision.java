package com.fullstackmaina.producerservice.model;

import lombok.Data;

@Data
public class Revision {
    private Long old;
    private Long revised;

}