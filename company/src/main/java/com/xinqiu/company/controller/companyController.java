package com.xinqiu.company.controller;

import com.xinqiu.api.entity.Company;
import com.xinqiu.api.entity.User;
import com.xinqiu.company.service.companyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户模块
 */
@Slf4j
@RestController
@RequestMapping("/company")
public class companyController {

    @Autowired
    private companyService companyService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/getCompany")
    public Company getCompany(@RequestBody Company company) {
        return companyService.get(company.getId());
    }

    @GetMapping("/getCompanyList")
    public List<Company> getCompanyList() {
        log.info("-------- 被远程调用了 --------");
        ArrayList<Company> companyList = new ArrayList<>();
        Company company = new Company();
        company.setCompanyId("1");
        company.setCompanyName("宁德时代");
        companyList.add(company);
        return companyList;
    }

}
