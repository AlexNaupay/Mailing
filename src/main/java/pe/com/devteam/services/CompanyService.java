package pe.com.devteam.services;

import pe.com.devteam.bean.Company;

import java.sql.SQLException;
import java.util.List;

public interface CompanyService {

    Company findById(int id) throws SQLException;

    List<Company> findAll(Company company) throws SQLException;

    Company saveOrUpdate(Company company) throws SQLException;
}
