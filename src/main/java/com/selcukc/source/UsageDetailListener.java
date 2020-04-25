package com.selcukc.source;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class UsageDetailListener {

    private final UsageDetailStreams usageDetailStreams;

    @StreamListener(UsageDetailStreams.INPUT)
    public void handleGreetings(@Payload List<UsageDetail> usageDetails) {
        log.info("Received usageDetails: {}", usageDetails);
    }

}
