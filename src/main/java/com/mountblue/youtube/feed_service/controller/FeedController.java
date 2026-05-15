package com.mountblue.youtube.feed_service.controller;

import com.mountblue.youtube.feed_service.client.VideoClient;
import com.mountblue.youtube.feed_service.dto.FeedPageResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    private final VideoClient videoClient;

    public FeedController(VideoClient videoClient) {
        this.videoClient = videoClient;
    }

    @GetMapping("/home")
    public FeedPageResponse getHomeFeed(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "12") int size) {
        return videoClient.getHomeVideos(page, size);
    }
}
