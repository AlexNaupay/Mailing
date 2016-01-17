package pe.com.devteam.modelsview;

import org.springframework.web.multipart.MultipartFile;

public class UploadMailModelView {

    private int companyId;

    private int businessId;

    private MultipartFile file;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
