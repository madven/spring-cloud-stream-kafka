package com.selcukc.source;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EnableScheduling
@Service
@RequiredArgsConstructor
@Slf4j
public class UsageDetailSender {

    private final UsageDetailStreams usageDetailStreams;

    private String[] users = {"user1", "user2", "user3"};

    @Scheduled(fixedDelay = 3000)
    public void sendGreeting() {
        List<UsageDetail> usageDetails = IntStream.range(0, 5)
                .mapToObj(i -> UsageDetail.builder()
                        .userId(users[new Random().nextInt(3)])
                        .duration(new Random().nextInt(100))
//                        .valid(new Random().nextBoolean())
                        .profile("kafka")
                        .build())
                .collect(Collectors.toList());

        Message<List<UsageDetail>> message = MessageBuilder
                .withPayload(usageDetails)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();

        usageDetailStreams.outboundUsageDetail().send(message);

        log.info("Sending usageDetails {}", usageDetails);
    }

}
