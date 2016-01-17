package pe.com.devteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import pe.com.devteam.modelsview.UploadMailModelView;
import pe.com.devteam.services.EmailService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/mailhome")
    public String home(){
        return "mail";
    }


    /**
     * It count the number of emails that matched with the parameters
     * @param params
     * @return
     */
    @RequestMapping(value = "/emails", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> count(@RequestParam Map<String, String> params){
        int companyId = Integer.parseInt(params.getOrDefault("company_id", "0"));
        int businessId = Integer.parseInt(params.getOrDefault("business_id", "0"));
        
        Map<String, Object> map = new HashMap<>();
        map.put("data",emailService.countMail(companyId, businessId));
        map.put("error",0);
        return map;
    }


    /*@RequestMapping(value = "/emails", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> upload(@RequestBody UploadMailModelView upload){
        Map<String, Object> map = new HashMap<>();

        System.out.println(upload);

        map.put("data",emailService.processFile(upload));
        map.put("error",0);
        return map;
    }*/

    @RequestMapping(value = "/emails", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> upload(@RequestParam("file") MultipartFile upload,
    		@RequestParam int companyId, @RequestParam int businessId){
        Map<String, Object> map = new HashMap<>();

        map.put("data",emailService.processFile(upload, companyId, businessId));
        map.put("error",0);
        return map;
    }


}
