package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.ImageCategory;
import com.hg.web.service.ImageCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 17:13
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web/")
public class ImageCategoryController {
    @Autowired
    private ImageCategoryService service;

    @PostMapping("addImageCategory")
    HgResponse addImageCategory(@RequestBody ImageCategory imageCategory) {
        service.save(imageCategory);
        return HgResponse.success();
    }

    @GetMapping("getImageCategoryList")
    HgResponse<List<ImageCategory>> getImageCategoryList() {
        return HgResponse.success(service.list(null));
    }

    @GetMapping("deleteImageCategory")
    HgResponse deleteImageCategory(long id) {
        service.removeById(id);
        return HgResponse.success();
    }
}