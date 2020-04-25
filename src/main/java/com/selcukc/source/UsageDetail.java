package com.selcukc.source;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsageDetail {

    private String userId;
    private long duration;
//    private boolean valid;
    private String profile;

}
