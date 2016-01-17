package pe.com.devteam.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pe.com.devteam.bean.Business;
import pe.com.devteam.services.BusinessService;
import pe.com.devteam.utils.Constants;

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
	
	@RequestMapping("/business/{id}")
    public  @ResponseBody Map<String, Object> show(@PathVariable("id") int id) {

        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", businessService.findById(id));
            map.put("error", 0);

            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("error", 1);
            return map;
        }

    }


    // save a business
    @RequestMapping(value = "/business", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> save (@RequestBody Business business){
    	System.out.println(business.getName());
        return saveOrUpdate(business);
    }

    // update a business
    @RequestMapping(value = "/business", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> update (@RequestBody Business business){
        return saveOrUpdate(business);
    }

    // delete a business
    @RequestMapping(value = "/business/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete (/*Business business, */@PathVariable("id") int id) throws SQLException {
        Business business = businessService.findById(id);
        business.setState(Constants.ENTITY_DISABLED);
        return saveOrUpdate(business);
    }

    private Map<String, Object> saveOrUpdate(Business business){
        Map<String, Object> map = new HashMap<>();

        try {
            business = businessService.saveOrUpdate(business);
            map.put("data", business);
            map.put("error", 0);
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("error", 1);
            return map;
        }
    }

}
