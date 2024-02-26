package com.icomfortableworld.domain.feed.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedModel {
    private Long feedId;
    private String content;
    private String like_count;
    private LocalDateTime created_time;
}
