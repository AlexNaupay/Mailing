package pe.com.devteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.devteam.bean.Business;
import pe.com.devteam.bean.BusinessCriteria;
import pe.com.devteam.dao.BusinessDAO;
import pe.com.devteam.services.BusinessService;
import pe.com.devteam.utils.Constants;

import java.sql.SQLException;
import java.util.Date;
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
        
        criteria.andStateEqualTo(1);

        if (business != null && business.getName() != null)
            criteria.andNameLike(business.getName());

        if (business != null && business.getId() != null)
            criteria.andIdEqualTo(business.getId());


        return businessDAO.selectByExample(businessCriteria);
    }

    @Override
    public Business saveOrUpdate(Business business) throws SQLException {
        if (business != null && business.getId() == 0){
            business.setCreatedAt(new Date());
            business.setUpdatedAt(new Date());
            business.setState(Constants.ENTITY_ENABLED);

            businessDAO.insertSelective(business);  // selective: fill only if not null attribute
        }else if (business != null && business.getId() != null) {
            business.setUpdatedAt(new Date());
            businessDAO.updateByPrimaryKeySelective(business);  // selective: undate only fill attibute
        }else{
        	throw new SQLException ("I can not save");
        }

        return business;
    }
}
