package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.FakeTotal;
import com.hg.web.service.FakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

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
    public HgResponse<FakeTotal> getFake() {
        List<FakeTotal> fakeList = fakeService.list(null);
        FakeTotal fake = CollectionUtils.isEmpty(fakeList) ? null : fakeList.get(0);
        return HgResponse.success(fake);
    }

    @PostMapping("/updateFake")
    public HgResponse updateFake(@RequestBody FakeTotal fake) {
        fakeService.updateById(fake);
        return HgResponse.success();
    }
}