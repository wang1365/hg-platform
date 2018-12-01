package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.entity.FakeDay;
import com.hg.web.repository.FakeDailyReportMapper;
import com.hg.web.service.FakeDailyReportService;
import org.springframework.stereotype.Service;

/**
 * author: Xiaochuan Wang
 * date: 2018/11/30 14:38
 * description:
 */
@Service
public class FakeDailyReportServiceImpl extends ServiceImpl<FakeDailyReportMapper, FakeDay> implements FakeDailyReportService {
}