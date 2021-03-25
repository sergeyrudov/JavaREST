package com.spring.rest.controller;


import com.spring.rest.entity.Company;
import com.spring.rest.exception_handling.NoSuchCompanyException;
import com.spring.rest.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MyController {

    @Autowired
    private CompanyService companyService;

    // return list of companies
    @GetMapping("/companies")
    public List<Company> showAllCompanies() {
        return companyService.getAllCompanies();
    }

    // return signe company with id parameter
    @GetMapping("/companies/{companyId}")
    public Company showCompany(@PathVariable int companyId) {
        Company company = companyService.getCompany(companyId);
        if (company == null) {
            throw new NoSuchCompanyException("Company with id: " + companyId + " is absent");
        } else {
            return company;
        }
    }

    // save company to DB
    @PostMapping("/companies")
    public Company saveCompany(@RequestBody Company company) {
        companyService.saveCompany(company);
        return company;
    }

    // edit company
    @PutMapping("/companies/{companyId}")
    public Company updateCompany(@RequestBody Company company, @PathVariable String companyId) {
        companyService.saveCompany(company);
        return company;
    }

    // delete company from DB
    @DeleteMapping("/companies/{companyId}")
    public String deleteCompany(@PathVariable int companyId) {
        Company company = companyService.getCompany(companyId);
        if (company==null) {
            throw new NoSuchCompanyException("Company with id: " + companyId + " is absent");
        } else {
            companyService.deleteCompany(companyId);
            return "Company with id: " + companyId + " was successfully removed!";
        }
    }
}
