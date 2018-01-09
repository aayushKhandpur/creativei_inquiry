package creativei.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import creativei.enums.ExceptionType;
import creativei.exception.InvalidParamRequest;
import creativei.manager.InquiryManager;
import creativei.vo.InquiryVo;
import creativei.vo.ResponseObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "localhost:8100")
@ControllerAdvice
@RestController
public class InquiryController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseObject handleConflict(InvalidParamRequest e, HttpServletResponse response)
            throws IOException {

        return  ResponseObject.getResponse(ExceptionType.NULLVALUE_EXCEPTION.getMessage(), ExceptionType.NULLVALUE_EXCEPTION.getCode());
    }
    private static final Logger logger =LoggerFactory.getLogger(InquiryController.class);
    private final ObjectMapper mapper=new ObjectMapper();

    @Autowired
    InquiryManager inquiryManager;
    @RequestMapping(value = "/inquiry/register" ,produces = "application/json",method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject createInquiry(@RequestBody String inquiryStr, HttpServletRequest request) {
        logger.info("CreateInquiry method");
        try {
            if (StringUtils.isBlank(inquiryStr)){
                logger.error("Request data is null or empty.");
                return (ResponseObject.getResponse(ExceptionType.NULLVALUE_EXCEPTION.getMessage(), ExceptionType.NULLVALUE_EXCEPTION.getCode()));
            }
            InquiryVo inquiryVo = mapper.readValue(inquiryStr, InquiryVo.class);
            ResponseObject responseObject = inquiryManager.create(inquiryVo);
            return responseObject;
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }

    @RequestMapping(value="/inquiry/update",produces = "application/json",method =RequestMethod.POST)
    public @ResponseBody
    ResponseObject updateInquiry(@RequestBody String inquiryStr, HttpServletRequest request){
        logger.info("UpdateInquiry method");
        try {
            if (StringUtils.isBlank(inquiryStr)){
                logger.error("Request data is null or empty.");
                return (ResponseObject.getResponse(ExceptionType.NULLVALUE_EXCEPTION.getMessage(), ExceptionType.GENERAL_ERROR.getCode()));
            }
            InquiryVo inquiryVo = mapper.readValue(inquiryStr, InquiryVo.class);
            ResponseObject responseObject = inquiryManager.update(inquiryVo);
            return responseObject;
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }
}
