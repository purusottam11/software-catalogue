package com.purusottam.softwarecatalogue.controller;

import com.purusottam.softwarecatalogue.bean.VersionBean;
import com.purusottam.softwarecatalogue.exception.BusinessException;
import com.purusottam.softwarecatalogue.service.VersionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
@AllArgsConstructor
@RequestMapping("/version/api/v1")
public class VersionController {
    private final VersionService versionService;

    @PostMapping("/addVersion")
    public VersionBean addVersion(@RequestBody VersionBean versionBean) {
        try {
            return versionService.addVersion(versionBean);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/updateVersion/{id}")
    public VersionBean updateVersion(@PathVariable Long id, @RequestBody VersionBean versionBean) {
        try {
            return versionService.updateVersion(id, versionBean);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getVersion/{versionId}")
    public VersionBean getVersion(@PathVariable Long versionId) {
        try {
            return versionService.getVersion(versionId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @DeleteMapping("/deleteVersion/{id}")
    public String deleteVersion(@PathVariable Long id) {
        try {
            return versionService.deleteVersion(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/getVersionsByProductId/{productId}")
    public List<VersionBean> getVersionsByProductId(@PathVariable Long productId) {
        try {
            return versionService.getVersionsByProductId(productId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
