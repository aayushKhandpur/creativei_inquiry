package creativei.controller;

import creativei.manager.BranchManager;
import creativei.manager.InquiryManager;
import creativei.manager.LocalityManager;
import creativei.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class MainController {

    @Autowired
    BranchManager branchManager;
    @Autowired
    LocalityManager localityManager;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/pincodes",produces ="application/json",method = RequestMethod.GET)
    public @ResponseBody
    ResponseObject getMatchingPincodes( @RequestParam String pincode){
      ResponseObject responseObject= localityManager.getPincodes(pincode);
      return responseObject;
    }
    @RequestMapping(value = "/locality/pincode",produces = "application/json",method=RequestMethod.GET)
    public @ResponseBody
    ResponseObject getLocalitiesByPincode(@RequestParam String pincode){
        ResponseObject responseObject=localityManager.getLocalityDataByPincode(pincode);
        return responseObject;
    }
}
