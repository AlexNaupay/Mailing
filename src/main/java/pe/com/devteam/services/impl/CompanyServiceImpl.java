package pe.com.devteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.devteam.bean.Company;
import pe.com.devteam.bean.CompanyCriteria;
import pe.com.devteam.dao.CompanyDAO;
import pe.com.devteam.services.CompanyService;
import pe.com.devteam.utils.Constants;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public Company findById(int id) throws SQLException {
        return companyDAO.selectByPrimaryKey(id);
    }

    @Override
    public List<Company> findAll(Company company) throws SQLException {
        CompanyCriteria companyCriteria = new CompanyCriteria();
        CompanyCriteria.Criteria criteria = companyCriteria.createCriteria();

        criteria.andStateEqualTo(1);

        if (company != null && company.getName() != null)
            criteria.andNameLike(company.getName());

        if (company != null && company.getId() != null)
            criteria.andIdEqualTo(company.getId());


        return companyDAO.selectByExample(companyCriteria);
    }

    @Override
    public Company saveOrUpdate(Company company) throws SQLException {
        Date date = new Date();

        if (company != null && company.getId() == 0){
            company.setCreatedAt(date);
            company.setUpdatedAt(date);
            company.setState(Constants.ENTITY_ENABLED);

            companyDAO.insertSelective(company);  // selective: fill only if not null attribute
        }else if (company != null && company.getId() != null) {
            company.setUpdatedAt(date);
            companyDAO.updateByPrimaryKeySelective(company);  // selective: undate only fill attibute
        }else{
            throw new SQLException ("I can not save");
        }

        return company;
    }
}
