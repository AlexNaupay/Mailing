package pe.com.devteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.devteam.bean.Company;
import pe.com.devteam.services.CompanyService;
import pe.com.devteam.utils.Constants;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * It returns all entities of the company , filtering by company's attribute
     * @param company filter by attributes
     * @return map results finded
     */
    @RequestMapping(value="/companies", method = RequestMethod.GET)
    public Map<String, Object> index(Company company) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", companyService.findAll(company));
            map.put("error", 0);

            return map;
        } catch (SQLException e) {
            //e.printStackTrace();
            map.put("error", 1);
            return map;
        }

    }

    /**
     * Find a particular company by id attibute
     * @param id identifier of the company searched
     * @return
     */
    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
    public Map<String, Object> show(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", companyService.findById(id));
            map.put("error", 0);

            return map;
        } catch (SQLException e) {
            //e.printStackTrace();
            map.put("error", 1);
            return map;
        }
    }

    /**
     * Save a company
     * @param company Company to saved
     * @return
     */
    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    public Map<String, Object> save (@RequestBody Company company){
        System.out.println(company.getName());
        return saveOrUpdate(company);
    }

    /**
     * Update a Company
     * @param company Company that contain changed
     * @return
     */
    @RequestMapping(value = "/companies", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> update (@RequestBody Company company){
        return saveOrUpdate(company);
    }

    /**
     * Delete a particular entity
     * @param id Company id to delete
     * @return Entity deleted
     * @throws SQLException
     */
    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete (/*Company company, */@PathVariable("id") int id) throws SQLException {
        Company company = companyService.findById(id);
        company.setState(Constants.ENTITY_DISABLED);
        return saveOrUpdate(company);
    }

    /**
     * Save or update a Company, called for method above
     * @param company Company will be saved or updated
     * @return The new entity saved or updated
     */
    private Map<String, Object> saveOrUpdate(Company company){
        Map<String, Object> map = new HashMap<>();

        try {
            company = companyService.saveOrUpdate(company);
            map.put("data", company);
            map.put("error", 0);
            return map;
        } catch (SQLException e) {
            //e.printStackTrace();
            map.put("error", 1);
            return map;
        }
    }

}
