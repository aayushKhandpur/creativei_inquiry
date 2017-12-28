package creativei.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import creativei.entity.Inquiry;
import creativei.manager.InquiryManager;
import creativei.vo.BranchVo;
import creativei.vo.InquiryVo;
import creativei.vo.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 12/24/2017.
 */
@RestController
public class InquiryController {
    private static final Logger logger =LoggerFactory.getLogger(InquiryController.class);
    private final ObjectMapper mapper=new ObjectMapper();

    @Autowired
    InquiryManager inquiryManager;

    @RequestMapping(value = "/inquiry/register" ,produces = "application/json",method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject createInquiry(@RequestBody String inquiryStr, HttpServletRequest request){
        try{
            InquiryVo inquiryVo=mapper.readValue(inquiryStr,InquiryVo.class);
             ResponseObject responseObject=inquiryManager.create(inquiryVo);
            return responseObject;
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResponseObject.getResponse(e.getMessage(), 1001);
        }
    }

}
