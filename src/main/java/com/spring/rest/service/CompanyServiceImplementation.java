package com.spring.rest.service;

import com.spring.rest.dao.CompanyDAO;
import com.spring.rest.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    @Transactional
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    @Override
    @Transactional
    public void saveCompany(Company company) {
        companyDAO.saveCompany(company);
    }

    @Override
    @Transactional
    public Company getCompany(int id) {
        return companyDAO.getCompany(id);
    }

    @Override
    @Transactional
    public void deleteCompany(int id) {
        companyDAO.deleteCompany(id);
    }
}
