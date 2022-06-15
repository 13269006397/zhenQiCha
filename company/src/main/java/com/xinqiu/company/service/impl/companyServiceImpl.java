package com.xinqiu.company.service.impl;

import com.xinqiu.api.entity.Company;
import com.xinqiu.api.entity.User;
import com.xinqiu.company.mapper.companyMapper;
import com.xinqiu.company.service.companyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class companyServiceImpl implements companyService {

    @Autowired
    private companyMapper companyMapper;

    @Override
    public Company get(String id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyMapper.getAllCompany();
    }
}
