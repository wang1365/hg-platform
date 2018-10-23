package com.xiaochuan.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaochuan.web.repository.ImageCategoryMapper;
import com.xiaochuan.web.repository.ImageMapper;
import com.xiaochuan.web.dto.ImageDTO;
import com.xiaochuan.web.entity.Image;
import com.xiaochuan.web.entity.ImageCategory;
import com.xiaochuan.web.service.ImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 09:06
 * @description:
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private ImageCategoryMapper categoryMapper;

    @Override
    public Image save(Image image) {
        imageMapper.insert(image);
        return image;
    }

    @Override
    public List<Image> getImageByName(String name) {
        Image image = new Image();
        image.setName(name);
        QueryWrapper wrapper = new QueryWrapper(image);
        List<Image> lt =  imageMapper.selectList(wrapper);
        return lt;
    }

    @Override
    public List<ImageDTO> getImageList() {
        List<Image> images = imageMapper.selectList(null);
        return images.stream().map(image -> {
            ImageDTO dto = new ImageDTO();
            BeanUtils.copyProperties(image, dto);
            ImageCategory category = categoryMapper.selectById(image.getCatId());
            String catName = category != null ? category.getName() : "";
            dto.setCatName(catName);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        imageMapper.deleteById(id);
    }
}