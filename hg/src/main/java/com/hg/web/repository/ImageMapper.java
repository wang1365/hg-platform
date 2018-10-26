package com.hg.web.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hg.web.entity.Image;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 09:00
 * @description:
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {
}