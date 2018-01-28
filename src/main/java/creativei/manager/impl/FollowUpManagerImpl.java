package creativei.manager.impl;

import creativei.manager.FollowUpManager;
import creativei.vo.FollowUpServerInfo;
import creativei.vo.ResponseObject;
import org.springframework.stereotype.Service;

@Service
public class FollowUpManagerImpl implements FollowUpManager {

    @Override
    public ResponseObject getFollowUpServerInfo() {
        FollowUpServerInfo followUpServerInfo=new FollowUpServerInfo();
        return ResponseObject.getResponse(followUpServerInfo);
    }
}
