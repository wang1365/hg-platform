package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.FakeDailyReport;
import com.hg.web.service.FakeDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: Xiaochuan Wang
 * date: 2018/11/30 14:39
 * description:
 */
@RestController
@RequestMapping("/web/fake/")
public class FakeDailyReportController {
    @Autowired
    private FakeDailyReportService fakeDailyReportService;

    @GetMapping("/getFakeDailyReport")
    HgResponse<List<FakeDailyReport>> getFakeDailyReport() {
        List<FakeDailyReport> fakeList = fakeDailyReportService.list(null);
        return HgResponse.success(fakeList);
    }

    @PostMapping("/updateFakeDailyReport")
    HgResponse updateFakeDailyReport(FakeDailyReport fake) {
        fakeDailyReportService.updateById(fake);
        return HgResponse.success();
    }

    @PostMapping("/addFakeDailyReport")
    HgResponse addFakeDailyReport(FakeDailyReport fake) {
        fakeDailyReportService.save(fake);
        return HgResponse.success();
    }
}