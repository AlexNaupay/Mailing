package pe.com.devteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.devteam.dao.CampaignDAO;
import pe.com.devteam.services.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService{

    @Autowired
    private CampaignDAO campaignDAO;

    
}
