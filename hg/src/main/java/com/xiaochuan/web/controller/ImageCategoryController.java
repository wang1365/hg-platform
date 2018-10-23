package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.entity.ImageCategory;
import com.xiaochuan.web.service.ImageCategoryService;
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
    TraceResponse addImageCategory(@RequestBody ImageCategory imageCategory) {
        service.add(imageCategory);
        return TraceResponse.success();
    }

    @GetMapping("getImageCategoryList")
    TraceResponse<List<ImageCategory>> getImageCategoryList() {
        return TraceResponse.success(service.getAll());
    }

    @GetMapping("deleteImageCategory")
    TraceResponse deleteImageCategory(int id) {
        service.delete(id);
        return TraceResponse.success();
    }
}