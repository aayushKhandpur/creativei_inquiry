package creativei.controller;

import creativei.manager.FollowUpManager;
import creativei.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class FollowUpController {
    @Autowired
    FollowUpManager followUpManager;

    @GetMapping("/follow-up/server-info")
    public ResponseObject followUpEnumList(){
        return followUpManager.getFollowUpServerInfo();
    }
}
