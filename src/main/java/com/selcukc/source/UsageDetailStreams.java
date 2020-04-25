package com.selcukc.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UsageDetailStreams {

    String INPUT = "usage-detail-in";
    String OUTPUT = "usage-detail-out";

    @Input(INPUT)
    SubscribableChannel inboundUsageDetail();

    @Output(OUTPUT)
    MessageChannel outboundUsageDetail();

}
