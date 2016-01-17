package pe.com.devteam.services;

import org.springframework.web.multipart.MultipartFile;
import pe.com.devteam.bean.Business;
import pe.com.devteam.bean.Company;
import pe.com.devteam.modelsview.UploadMailModelView;

public interface EmailService {

    int countMail(int companyId, int businessId);

    int countMail(Company company, Business business);

    int processFile(UploadMailModelView upload);

    int processFile(MultipartFile upload, int companyId, int businessId);
}
