package creativei.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import creativei.enums.ExceptionType;
import creativei.enums.InquiryStatus;
import creativei.exception.InvalidParamRequest;
import creativei.helper.RequestHelper;
import creativei.helper.RequestHelper;
import creativei.manager.InquiryManager;
import creativei.vo.InquiryVo;
import creativei.vo.ResponseObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class InquiryController {
    private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    InquiryManager inquiryManager;

    @RequestMapping(value = "/inquiry/register", produces = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject createInquiry(@RequestBody String inquiryStr, HttpServletRequest request) {
        logger.info("CreateInquiry method");
        try {
            if(RequestHelper.isEmptyRequestString(inquiryStr))
                return (ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode()));
            InquiryVo inquiryVo = mapper.readValue(inquiryStr, InquiryVo.class);
            ResponseObject responseObject = inquiryManager.create(inquiryVo);
            return responseObject;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }

    @RequestMapping(value = "/inquiry/update", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseObject updateInquiry(@RequestBody String inquiryStr, HttpServletRequest request) {
        logger.info("UpdateInquiry method");
        try {
            if(RequestHelper.isEmptyRequestString(inquiryStr))
                return (ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode()));
            InquiryVo inquiryVo = mapper.readValue(inquiryStr, InquiryVo.class);
            ResponseObject responseObject = inquiryManager.update(inquiryVo);
            return responseObject;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }

    @RequestMapping(value = "/inquiry/server-info", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
     ResponseObject enumList(){
         ResponseObject responseObject=inquiryManager.getInquiryServerInfo();
         return responseObject;
    }

    @RequestMapping(value="inquiry/getById",produces = "application/json",method = RequestMethod.GET)
    public @ResponseBody
    ResponseObject getInquiryById(@RequestParam Long id){
        return inquiryManager.getById(id);
    }

    @RequestMapping(value = "inquiry/getAll",produces = "application/json",method = RequestMethod.GET)
    public @ResponseBody
    ResponseObject getAllInqueries(){return inquiryManager.getAll();}

    @RequestMapping(value = "inquiry/getByStatus",produces = "application/json",method = RequestMethod.GET)
    public @ResponseBody
    ResponseObject getInquiriesByStatus(@RequestParam InquiryStatus status){return inquiryManager.getByStatus(status);}
}

