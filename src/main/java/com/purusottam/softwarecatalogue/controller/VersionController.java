package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.service.VersionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/version")
public class VersionController {
    private final VersionService versionService;

}
