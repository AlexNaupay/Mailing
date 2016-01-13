package pe.com.devteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.devteam.dao.EmailDAO;
import pe.com.devteam.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private EmailDAO emailDAO;

}
