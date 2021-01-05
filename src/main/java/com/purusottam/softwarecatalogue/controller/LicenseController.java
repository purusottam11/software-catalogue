package com.purusottam.softwarecatalogue.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.purusottam.softwarecatalogue.bean.LicenseBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.exception.ErrorCode;
import com.purusottam.softwarecatalogue.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/license")
@AllArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;


    @GetMapping("/getLicenses")
    public List<LicenseBean> getAllLicense() {
        try {
            return licenseService.getLicenses();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PostMapping("/addLicense")
    public LicenseBean addLicense(@RequestBody LicenseBean licenseBean) {
        try {
            return licenseService.addLicense(licenseBean);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/updateLicense/{id}")
    public LicenseBean updateLicense(@RequestBody LicenseBean licenseBean, @PathVariable Long id) {
        try {
            return licenseService.updateLicense(licenseBean, id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/getLicense/{id}")
    public LicenseBean getLicense(@PathVariable Long id) {
        try {
            return licenseService.getLicenses(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }


}
