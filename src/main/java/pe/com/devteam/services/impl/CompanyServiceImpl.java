package pe.com.devteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.devteam.dao.CompanyDAO;
import pe.com.devteam.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyDAO companyDAO;

}
