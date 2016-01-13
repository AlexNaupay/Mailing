package pe.com.devteam.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.devteam.bean.Business;
import pe.com.devteam.services.BusinessService;

@Controller
public class BusinessController {
	
	@Autowired
    BusinessService businessService;

	
	@RequestMapping("/business")
    public  @ResponseBody Map<String, Object> index(Business business) {

        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", businessService.findAll(business));
            map.put("error", 0);

            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("error", 1);
            return map;
        }

    }

}
