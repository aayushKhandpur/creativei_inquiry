package creativei.manager;

import creativei.vo.FollowUpVo;
import creativei.vo.ResponseObject;
import org.springframework.stereotype.Service;


public interface FollowUpManager {
    ResponseObject getFollowUpServerInfo();

    ResponseObject createFollowUp(FollowUpVo followUpVo);
}
