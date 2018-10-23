package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.dto.ImageDTO;
import com.xiaochuan.web.entity.Image;
import com.xiaochuan.web.entity.ImageCategory;
import com.xiaochuan.web.service.ImageCategoryService;
import com.xiaochuan.web.service.ImageService;
import com.xiaochuan.web.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 09:07
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/web")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageCategoryService categoryService;

    @Autowired
    StorageService storageService;

    @PostMapping("/addImage")
    public TraceResponse addReport(@RequestParam("file") MultipartFile file,
                                   @RequestParam Integer catId,
                                   @RequestParam String name) {
        if (catId <= 0 || StringUtils.isEmpty(name)) {
            log.error("Invalid parameter");
            return TraceResponse.fail("Invalid parameter");
        }

        TraceResponse res;
        try {
            ImageCategory category = getImageCategory(catId);

            Path root = Paths.get(category.getLocalPath());
            String rootUrlPath = category.getUrlPath();
            String urlPath = rootUrlPath.endsWith("/") ? rootUrlPath + name : rootUrlPath + "/" + name;
            Path path = storageService.store(file, root, name);
            log.info("Store image success, file: {} root: {}, name: {}", file.getOriginalFilename(), root.toString(), name);

            Image image = new Image();
            image.setCatId(catId);
            image.setName(name);
            image.setLocalPath(path.toString());
            image.setUrlPath(urlPath);

            imageService.save(image);
            res = TraceResponse.success();
        } catch (Exception e) {
            log.error("failed! {}", e);
            res = TraceResponse.fail(e.getMessage());
        }

        return res;
    }

    @GetMapping("getImageList")
    TraceResponse<List<ImageDTO>> getImageList() {
        List<ImageDTO> images = imageService.getImageList();
        return TraceResponse.success(images);
    }

    @PostMapping("deleteImage")
    TraceResponse deleteImage(@RequestParam int id) {
        TraceResponse res;
        try {
            imageService.delete(id);
            res = TraceResponse.success();
        } catch (Exception e) {
            log.error("deleteOrderById image faild: {}, {}", id, e);
            res = TraceResponse.fail(e.getMessage());
        }
        return res;
    }

    @GetMapping("getImageByName")
    TraceResponse<List<Image>> getImageByName(@RequestParam String name) {
        TraceResponse res;
        try {
            res = TraceResponse.success(imageService.getImageByName(name));
        } catch (Exception e) {
            log.error("deleteOrderById image faild: {}, {}", name, e);
            res = TraceResponse.fail(e.getMessage());
        }
        return res;
    }


    private ImageCategory getImageCategory(Integer catId) {
        return categoryService.getImageCategory(catId);
    }
}