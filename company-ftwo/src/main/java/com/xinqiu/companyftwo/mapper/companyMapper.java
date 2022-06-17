package com.xinqiu.companyftwo.mapper;
import com.xinqiu.api.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface companyMapper {
    //根据主键获取数据
    Company selectByPrimaryKey(String id);

    //获取表中的全部数据
    List<Company> getAllCompany();
}