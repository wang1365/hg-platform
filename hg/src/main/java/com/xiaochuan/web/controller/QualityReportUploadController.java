package com.xiaochuan.web.controller;

import com.xiaochuan.utils.DatetimeUtil;
import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.dto.QualityReportDTO;
import com.xiaochuan.web.entity.QualityReport;
import com.xiaochuan.web.service.QualityReportService;
import com.xiaochuan.web.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 14:54
 */

@RestController
public class QualityReportUploadController {
    private final StorageService storageService;
    private final QualityReportService qualityReportService;


    @Autowired
    public QualityReportUploadController(StorageService storageService, QualityReportService qualityReportService) {
        this.storageService = storageService;
        this.qualityReportService = qualityReportService;
        storageService.init();
    }

    /**
     * 上传质量检测报告
     *
     * @param file
     * @param reportDate
     * @return
     */
    @PostMapping("/web/qualityReport/addQualityReport")
    public TraceResponse addQualityReport(@RequestParam("file") MultipartFile file,
                                    @RequestParam Integer goodsId,
                                   @RequestParam String title,
                                    @RequestParam(defaultValue = "") String description,
                                    @RequestParam(defaultValue = "") String origin,
                                    @RequestParam String reportDate) {
        String targetName = String.format("%d.%s",
                LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)),
                file.getOriginalFilename());
        Path path = storageService.store(file, targetName);
        QualityReport report = new QualityReport();
        report.setGoodsId(goodsId);
        report.setTitle(title);
        report.setDescription(description);
        report.setPath(path.toAbsolutePath().toString());
        report.setOrigin(origin);
        report.setCreateTime(new Date(System.currentTimeMillis()));
        report.setReportDate(DatetimeUtil.parseToDate(reportDate));
        report.setPath("/resources/" + targetName);
        qualityReportService.insert(report);

        return TraceResponse.success();
    }

    @RequestMapping(value = "/web/qualityReport/getQualityReportList", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public TraceResponse getQualityReportList() {
        List<QualityReportDTO> reports = qualityReportService.selectAll();
        return TraceResponse.success(reports);
    }

    @RequestMapping(value = "/web/qualityReport/deleteQualityReport", method = {RequestMethod.POST})
    public TraceResponse deleteQualityReport(@RequestParam("id") int id) {
        qualityReportService.delete(id);
        return TraceResponse.success();
    }
}
