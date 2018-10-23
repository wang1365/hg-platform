package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.entity.Company;
import com.xiaochuan.web.entity.Qualification;
import com.xiaochuan.web.service.QualificationService;
import com.xiaochuan.web.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web/qualification")
public class QualificationController {
private QualificationService qualificationService;
@Autowired
    StorageService storageService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @PostMapping("addQualification")
    TraceResponse addQualification(@RequestParam("file") MultipartFile file,
            @RequestParam int companyId) {

        String targetName = String.format("%d.%s",
                LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)),
                file.getOriginalFilename());
        Path path = storageService.store(file, targetName);
        Qualification qualification = new Qualification();
        qualification.setCompanyId(companyId);
        qualification.setPath(path.toAbsolutePath().toString());
        qualification.setPath("/resources/" + targetName);
        int id = this.qualificationService.addQualification(qualification);
        return TraceResponse.success(id);
    }

    @GetMapping("getQualificationList")
    TraceResponse getQualificationList() {
        return TraceResponse.success(qualificationService.getAllQualification());
    }

    @PostMapping("deleteQualification")
    TraceResponse deleteQualification(@RequestParam int id) {
        qualificationService.deleteQualification(id);
        return TraceResponse.success();
    }
}