package com.hg.web.service;

import com.hg.web.entity.ImageCategory;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 16:48
 * @description:
 */
public interface ImageCategoryService {
    List<ImageCategory> getAll();
    ImageCategory getImageCategory(int catId);
    ImageCategory add(ImageCategory imageCategory);
    void delete(int id);
}