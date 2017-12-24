package creativei.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import creativei.entity.Branch;
import creativei.manager.BranchManager;
import creativei.vo.BranchVo;
import creativei.vo.ResponseObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Aayush on 12/23/2017.
 */
@RestController
public class BranchController {
    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    BranchManager branchManager;

    @RequestMapping(value = "/branch/create", produces = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject createBranch(@RequestBody String branchStr, HttpServletRequest request){
        try {
            BranchVo branchVo = mapper.readValue(branchStr, BranchVo.class);
            return branchManager.create(branchVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(e.getMessage(), 1001);
        }

    }
}
