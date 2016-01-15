package pe.com.devteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.devteam.bean.Business;
import pe.com.devteam.bean.BusinessCriteria;
import pe.com.devteam.dao.BusinessDAO;
import pe.com.devteam.services.BusinessService;

import java.sql.SQLException;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private BusinessDAO businessDAO;

    public Business findById(int id) throws SQLException {
        return businessDAO.selectByPrimaryKey(id);
    }

    @Override
    public List<Business> findAll(Business business) throws SQLException {
        BusinessCriteria businessCriteria = new BusinessCriteria();
        BusinessCriteria.Criteria criteria = businessCriteria.createCriteria();
        
        criteria.andStateIdEqualTo(1);

        if (business != null && business.getName() != null)
            criteria.andNameLike(business.getName());

        if (business != null && business.getId() != null)
            criteria.andIdEqualTo(business.getId());


        return businessDAO.selectByExample(businessCriteria);
    }
}
