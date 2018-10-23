package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.entity.Company;
import com.xiaochuan.web.service.CompanyService;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web/company/")
public class CompanyController {
    private CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getCompanyList")
    public TraceResponse getCompanyList() {
        return TraceResponse.success(companyService.getAll());
    }

    @PostMapping("/addCompany")
    public TraceResponse addCompany(@RequestBody Company company) {
        return TraceResponse.success(companyService.add(company));
    }

    @PostMapping("/updateCompany")
    public TraceResponse updateCompany(@RequestBody Company company) {
        return TraceResponse.success(companyService.update(company));
    }

    @PostMapping("/deleteCompany")
    public void deleteCompany(int id) {
        companyService.delete(id);
    }
}
