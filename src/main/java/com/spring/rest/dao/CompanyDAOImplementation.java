package com.spring.rest.dao;

import com.spring.rest.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAOImplementation implements CompanyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Company> getAllCompanies() {
        Session session = sessionFactory.getCurrentSession();
        List<Company> allCompanies = session.createQuery("from Company", Company.class)
                .getResultList();
        return allCompanies;
    }

    @Override
    public void saveCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(company);
    }

    @Override
    public Company getCompany(int id) {
        Session session = sessionFactory.getCurrentSession();
        Company company = session.get(Company.class, id);
        return company;
    }

    @Override
    public void deleteCompany(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Company> query = session.createQuery("delete from Company where id = :companyId");
        query.setParameter("companyId", id);
        query.executeUpdate();
    }
}
