package com.xiaochuan.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaochuan.utils.OsUtil;
import com.xiaochuan.web.repository.ImageCategoryMapper;
import com.xiaochuan.web.entity.ImageCategory;
import com.xiaochuan.web.service.ImageCategoryService;
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