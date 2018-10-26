package com.hg.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hg.utils.OsUtil;
import com.hg.web.repository.ImageCategoryMapper;
import com.hg.web.entity.ImageCategory;
import com.hg.web.service.ImageCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 16:49
 * @description:
 */
@Service
public class ImageCategoryServiceImpl implements ImageCategoryService {
    @Autowired
    private ImageCategoryMapper mapper;

    @Override
    public List<ImageCategory> getAll() {
        ImageCategory category = new ImageCategory();
        category.setProfileType(OsUtil.isLinux() ? 0 : 1);
        return mapper.selectList(new QueryWrapper<>(category));
    }

    @Override
    public ImageCategory getImageCategory(int id) {
        return mapper.selectById(id);
    }

    @Override
    public ImageCategory add(ImageCategory imageCategory) {
        imageCategory.setProfileType(OsUtil.isLinux() ? 0 : 1);
        mapper.insert(imageCategory);
        return imageCategory;
    }

    @Override
    public void delete(int id) {
        mapper.deleteById(id);
    }
}