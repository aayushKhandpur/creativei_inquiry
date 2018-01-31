package creativei.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import creativei.entity.FollowUp;
import creativei.enums.ExceptionType;
import creativei.helper.RequestHelper;
import creativei.manager.FollowUpManager;
import creativei.vo.FollowUpVo;
import creativei.vo.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class FollowUpController {
    @Autowired
    FollowUpManager followUpManager;
    private Logger logger = LoggerFactory.getLogger(FollowUpController.class);

    @GetMapping("/follow-up/server-info")
    public ResponseObject followUpEnumList() {
        return followUpManager.getFollowUpServerInfo();
    }

    @RequestMapping(value = "/follow-up/create", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseObject createFollowUp(@RequestBody String followUpStr, HttpServletRequest request) {
        try {
            if (RequestHelper.isEmptyRequestString(followUpStr)) {
                return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode());
            }
            FollowUpVo followUpVo = new ObjectMapper().readValue(followUpStr, FollowUpVo.class);
            ResponseObject responseObject = followUpManager.createFollowUp(followUpVo);
            return responseObject;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }

    }
}
