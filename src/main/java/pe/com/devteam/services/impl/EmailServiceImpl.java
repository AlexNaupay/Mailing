package pe.com.devteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.com.devteam.bean.*;
import pe.com.devteam.dao.EmailDAO;
import pe.com.devteam.modelsview.UploadMailModelView;
import pe.com.devteam.services.EmailService;
import pe.com.devteam.utils.Helper;

import java.util.Date;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private EmailDAO emailDAO;

    @Override
    public int countMail(int companyId, int businessId) {
        EmailCriteria emailCriteria = new EmailCriteria();
        EmailCriteria.Criteria criteria = emailCriteria.createCriteria();

        criteria.andStateEqualTo(1);
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andBusinessIdEqualTo(businessId);

        return emailDAO.countByExample(emailCriteria);
    }

    @Override
    public int countMail(Company company, Business business) {
        return countMail(company.getId(), business.getId());
    }

    @Override
    public int processFile(UploadMailModelView upload) {
        return processFile(upload.getFile(), upload.getCompanyId(), upload.getBusinessId());
    }

    @Override
    public int processFile(MultipartFile upload, int companyId, int businessId) {
        List<String> emails = Helper.readFile(upload);
        Date date = new Date();

        if (emails != null)
        for(String email: emails){
            Email emailObject = new Email();
            emailObject.setMail(email);
            emailObject.setCompanyId(companyId);
            emailObject.setBusinessId(businessId);
            emailObject.setCreatedAt(date);
            emailObject.setUpdatedAt(date);

            emailDAO.insertSelective(emailObject);
        }

        return (emails!= null)?emails.size():0;
    }


}
