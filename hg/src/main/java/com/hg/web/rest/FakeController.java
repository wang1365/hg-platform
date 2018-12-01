package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.Fake;
import com.hg.web.service.FakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
public class FakeController {
    @Autowired
    private FakeService fakeService;

    @GetMapping("/getFake")
    HgResponse<Fake> getFake() {
        List<Fake> fakeList = fakeService.list(null);
        Fake fake = CollectionUtils.isEmpty(fakeList) ? null : fakeList.get(0);
        return HgResponse.success(fake);
    }

    @PostMapping("/updateFake")
    HgResponse updateFake(Fake fake) {
        fakeService.updateById(fake);
        return HgResponse.success();
    }
}