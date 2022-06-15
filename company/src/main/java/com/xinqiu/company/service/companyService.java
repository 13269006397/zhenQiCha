package com.xinqiu.company.service;

import com.xinqiu.api.entity.Company;
import java.util.List;

public interface companyService {

    Company get(String id);

    List<Company> getAllCompany();


}
