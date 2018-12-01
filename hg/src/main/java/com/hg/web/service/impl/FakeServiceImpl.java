package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.entity.Fake;
import com.hg.web.repository.FakeMapper;
import com.hg.web.service.FakeService;
import org.springframework.stereotype.Service;

/**
 * author: Xiaochuan Wang
 * date: 2018/11/30 14:38
 * description:
 */
@Service
public class FakeServiceImpl extends ServiceImpl<FakeMapper, Fake> implements FakeService {
}