package com.xiaochuan.web.repository;

import com.xiaochuan.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByName(String name);

    List<User> select();


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}