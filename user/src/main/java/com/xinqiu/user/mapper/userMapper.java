package com.xinqiu.user.mapper;
import com.xinqiu.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface userMapper {
    //根据主键获取数据
    User selectByPrimaryKey(String id);

    //获取表中的全部数据
    List<User> getAllUser();
}