package creativei.controller;

import creativei.enums.ExceptionType;
import creativei.manager.BranchManager;
import creativei.manager.InquiryManager;
import creativei.manager.LocalityManager;
import creativei.service.DataUploadService;
import creativei.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class MainController {

    @Autowired
    BranchManager branchManager;
    @Autowired
    LocalityManager localityManager;
    @Autowired
    DataUploadService dataUploadService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Creative-I Inquiry.";
    }

    @GetMapping("/creativei/upload")
    public Boolean uploadLocalityDate() throws IOException {
        CSVReader reader = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("LocalityData.csv").getFile());
            boolean isSuccess = dataUploadService.uploadLoaclityData(file);
            return isSuccess;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
