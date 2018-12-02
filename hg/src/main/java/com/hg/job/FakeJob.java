package com.hg.job;

import com.hg.web.entity.FakeTotal;
import com.hg.web.service.FakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/12/1 11:00
 * @description:
 */
@Service
public class FakeJob {
    @Autowired
    private FakeService fakeService;

    @Scheduled(fixedRate = 10*1000L)
    void fakeEverything() {
        Random random = new Random();
        FakeTotal fake = fakeService.getById(1);
        BigDecimal delta = new BigDecimal(Math.random()*10);
        fake.setTotalSaleAmount(fake.getTotalSaleAmount().add(delta));
        fake.setTotalSaleCount(fake.getTotalSaleCount() + random.nextInt(2)+1);
        fake.setTotalWeight(fake.getTotalWeight() + random.nextInt(2)+1);

        fakeService.updateById(fake);
    }

    @Scheduled(initialDelay = 2*1000, fixedRate = 10*1000L)
    void fakeUser() {
        FakeTotal fake = fakeService.getById(1);
        fake.setUserCount(fake.getUserCount() + 1);

        fakeService.updateById(fake);
    }
}