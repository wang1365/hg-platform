package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.ImageDTO;
import com.hg.web.entity.Image;
import com.hg.web.entity.ImageCategory;
import com.hg.web.service.ImageCategoryService;
import com.hg.web.service.ImageService;
import com.hg.web.service.StorageService;
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
    public HgResponse addReport(@RequestParam("file") MultipartFile file,
                                @RequestParam Integer catId,
                                @RequestParam String name) {
        if (catId <= 0 || StringUtils.isEmpty(name)) {
            log.error("Invalid parameter");
            return HgResponse.fail("Invalid parameter");
        }

        HgResponse res;
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
            res = HgResponse.success();
        } catch (Exception e) {
            log.error("failed! {}", e);
            res = HgResponse.fail(e.getMessage());
        }

        return res;
    }

    @GetMapping("getImageList")
    HgResponse<List<ImageDTO>> getImageList() {
        List<ImageDTO> images = imageService.getImageList();
        return HgResponse.success(images);
    }

    @PostMapping("deleteImage")
    HgResponse deleteImage(@RequestParam int id) {
        HgResponse res;
        try {
            imageService.delete(id);
            res = HgResponse.success();
        } catch (Exception e) {
            log.error("deleteOrderById image faild: {}, {}", id, e);
            res = HgResponse.fail(e.getMessage());
        }
        return res;
    }

    @GetMapping("getImageByName")
    HgResponse<List<Image>> getImageByName(@RequestParam String name) {
        HgResponse res;
        try {
            res = HgResponse.success(imageService.getImageByName(name));
        } catch (Exception e) {
            log.error("deleteOrderById image faild: {}, {}", name, e);
            res = HgResponse.fail(e.getMessage());
        }
        return res;
    }


    private ImageCategory getImageCategory(Integer catId) {
        return categoryService.getImageCategory(catId);
    }
}