package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.Company;
import com.hg.web.service.CompanyService;
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
    public HgResponse getCompanyList() {
        return HgResponse.success(companyService.list(null));
    }

    @PostMapping("/addCompany")
    public HgResponse addCompany(@RequestBody Company company) {
        return HgResponse.success(companyService.save(company));
    }

    @PostMapping("/updateCompany")
    public HgResponse updateCompany(@RequestBody Company company) {
        return HgResponse.success(companyService.updateById(company));
    }

    @PostMapping("/deleteCompany")
    public void deleteCompany(long id) {
        companyService.removeById(id);
    }
}
