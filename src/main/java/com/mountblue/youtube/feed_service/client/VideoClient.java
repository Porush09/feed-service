package com.mountblue.youtube.feed_service.client;

import com.mountblue.youtube.feed_service.dto.FeedPageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "video-service")
public interface VideoClient {

    @GetMapping("/api/videos/home")
    FeedPageResponse getHomeVideos(@RequestParam("page") int page,
                                   @RequestParam("size") int size);
}
