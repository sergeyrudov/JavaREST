package com.spring.rest.dao;

import com.spring.rest.entity.Company;
import java.util.List;

public interface CompanyDAO {

    public List<Company> getAllCompanies();

    public void saveCompany(Company company);

    public Company getCompany(int id);

    public void deleteCompany(int id);
}
