package creativei.controller;

import creativei.entity.Branch;
import creativei.manager.BranchManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aayush on 12/7/2017.
 */
@RestController
public class MainController {

    @Autowired
    BranchManager branchManager;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/branch/save", produces = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    Branch createBranch(){
        Branch branch = new Branch("Malviya Nagar");
        return branchManager.create(branch);
    }
}
