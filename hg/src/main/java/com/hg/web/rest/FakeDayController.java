package com.hg.web.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hg.web.common.HgResponse;
import com.hg.web.entity.FakeDay;
import com.hg.web.service.FakeDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * author: Xiaochuan Wang
 * date: 2018/11/30 14:39
 * description:
 */
@RestController
@RequestMapping("/web/fake/")
public class FakeDayController {
    @Autowired
    private FakeDailyReportService fakeDailyReportService;

    @GetMapping("/getFakeDailyReport")
    public HgResponse getFakeDailyReport() {
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
        List<FakeDay> fakeList1 = fakeDailyReportService.list(wrapper1);

        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.between("day", d3, d4);
        wrapper2.orderByAsc("day");
        List<FakeDay> fakeList2 = fakeDailyReportService.list(wrapper2);
        return HgResponse.success(Arrays.asList(fakeList2,fakeList1));
    }


    @GetMapping("/getFakeDayList")
    public HgResponse getFakeDayList() {
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.orderByDesc("day");
        return HgResponse.success(fakeDailyReportService.list(wrapper1));
    }

    @GetMapping("/getFakeDayByDay")
    public HgResponse<FakeDay> getFakeDayByDat(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date day) {
        FakeDay condition = new FakeDay();
        condition.setDay(day);
        QueryWrapper wrapper= new QueryWrapper(condition);

        return HgResponse.success(fakeDailyReportService.getOne(wrapper));
    }

    @PostMapping("/updateFakeDay")
    public HgResponse updateFakeDailyReport(@RequestBody FakeDay fake) {
        fakeDailyReportService.updateById(fake);
        return HgResponse.success();
    }

    @PostMapping("/addFakeDay")
    public HgResponse addFakeDay(@RequestBody  FakeDay fake) {
        fakeDailyReportService.save(fake);
        return HgResponse.success();
    }
}