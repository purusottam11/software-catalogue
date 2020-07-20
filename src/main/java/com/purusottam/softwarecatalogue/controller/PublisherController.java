package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.bean.PublisherBean;
import com.purusottam.softwarecatalogue.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
@AllArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping("/addPublisher")
    public PublisherBean addPublisherBean(@RequestBody PublisherBean publisherBean) {
        return publisherService.addPublisher(publisherBean);
    }

    @PutMapping("/updatePublisher/{publisherId}")
    public PublisherBean updatePublisher(@RequestBody PublisherBean publisherBean, @PathVariable Long publisherId) {
        return publisherService.updatePublisher(publisherBean, publisherId);
    }

    @GetMapping("/getPublishers")
    public List<PublisherBean> getPublishers() {
        return publisherService.getAllPublisher();
    }

    @GetMapping("/getPublisher/{publisherId}")
    public PublisherBean getPublisher(@PathVariable Long publisherId) {
        return publisherService.getPublisher(publisherId);
    }

}
