package com.hg.web.service;

import com.hg.web.dto.ImageDTO;
import com.hg.web.entity.Image;

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