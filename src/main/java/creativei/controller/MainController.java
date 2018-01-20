package creativei.controller;

import creativei.manager.BranchManager;
import creativei.manager.InquiryManager;
import creativei.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aayush on 12/7/2017.
 */
@RestController
public class MainController {

    @Autowired
    BranchManager branchManager;
    @Autowired
    InquiryManager inquiryManager;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/pincode/beginWith",produces ="application/json",method = RequestMethod.GET)
    public @ResponseBody
    ResponseObject getPincodeStartWith( @RequestParam String pincode){
      ResponseObject responseObject=  inquiryManager.getPincodes(pincode);
      return responseObject;
    }
    @RequestMapping(value = "/pincode/equalsTo",produces = "application/json",method=RequestMethod.GET)
    public @ResponseBody
    ResponseObject getLocalityData(@RequestParam String pincode){
        ResponseObject responseObject=inquiryManager.getLocalityDataByPincode(pincode);
        return responseObject;
    }
}
