package com.spring.rest.service;

import com.spring.rest.entity.Company;
import java.util.List;

public interface CompanyService {

    public List<Company> getAllCompanies();

    public void saveCompany(Company company);

    public Company getCompany(int id);

    public void deleteCompany(int id);
}
