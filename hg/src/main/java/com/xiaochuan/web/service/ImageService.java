package com.xiaochuan.web.service;

import com.xiaochuan.web.dto.ImageDTO;
import com.xiaochuan.web.entity.Image;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 09:02
 * @description:
 */
public interface ImageService {
    Image save(Image image);
    List<Image> getImageByName(String name);
    List<ImageDTO> getImageList();
    void delete(int id);
}