package com.hg.web.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.hg.web.common.HgResponse;
import com.hg.web.entity.FakeDailyReport;
import com.hg.web.service.FakeDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

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
    HgResponse getFakeDailyReport() {
        QueryWrapper wrapper1 = new QueryWrapper();
        LocalDate today = LocalDate.now();
        LocalDate monthStart = today.withDayOfMonth(1);
        LocalDate monthEnd = today.plusMonths(1L).withDayOfMonth(1).minusDays(1L);
        LocalDate preMonthStart = today.minusMonths(1).withDayOfMonth(1);
        LocalDate preMonthEnd = today.withDayOfMonth(1).minusDays(1);

        Date d1 = Date.from(monthStart.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date d2 = Date.from(monthEnd.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date d3 = Date.from(preMonthStart.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date d4 = Date.from(preMonthEnd.atStartOfDay(ZoneId.systemDefault()).toInstant());

        wrapper1.between("day", d1, d2);
        wrapper1.orderByAsc("day");
        List<FakeDailyReport> fakeList1 = fakeDailyReportService.list(wrapper1);

        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.between("day", d3, d4);
        wrapper2.orderByAsc("day");
        List<FakeDailyReport> fakeList2 = fakeDailyReportService.list(wrapper2);
        return HgResponse.success(Arrays.asList(fakeList1, fakeList2));
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