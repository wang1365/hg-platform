package com.hg.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.web.repository.ImageMapper;
import com.hg.web.entity.Image;
import com.hg.web.service.ImageService;
import org.springframework.stereotype.Service;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 09:06
 * @description:
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {
}