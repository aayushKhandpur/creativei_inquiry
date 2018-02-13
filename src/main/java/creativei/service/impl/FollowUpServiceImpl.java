package creativei.service.impl;


import creativei.dao.FollowUpDao;
import creativei.entity.FollowUp;
import creativei.enums.ExceptionType;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.service.FollowUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("FollowUpService")
public class FollowUpServiceImpl implements FollowUpService {
    private static final Logger logger= LoggerFactory.getLogger(FollowUpService.class);
    @Autowired
    FollowUpDao followUpDao;

    @Override
    public FollowUp createFollowUp(FollowUp followUp) throws InvalidParamRequest {
        if (!validateFollowUp(followUp))
            throw new InvalidParamRequest("Required field can not be empty");
        return followUpDao.save(followUp);
    }

    @Override
    public FollowUp updateFollowUp(FollowUp followUp) throws InvalidParamRequest {
        if (!validateFollowUp(followUp))
            throw new InvalidParamRequest("Required field can not be empty");
        return followUpDao.save(followUp);
    }

    private Boolean validateFollowUp(FollowUp followUp) {
        Boolean []cond=new Boolean[5];
        Arrays.fill(cond,false);
        if (((followUp.getCaseIndex() == null) && (cond[0]=true)) | (followUp.getFollowUpDate() == null&& (cond[1]=true)) | (followUp.getType() == null&& (cond[2]=true)) | (followUp.getStatus() == null && (cond[3]=true)) | (followUp.getSubStatus() == null&& (cond[4]=true))) {
            for(int i=0;i<cond.length;i++){
                if(cond[i]==true){
                    switch (i){
                        case 0:
                            logger.error("CaseIndex field can not be null or empty");
                            break;
                        case 1:
                            logger.error("FollowUp Date field can not be null or empty");
                            break;
                        case 2:
                            logger.error("FollowUp Type field can not be null or empty");
                            break;
                        case 3:
                            logger.error("FollowUp Status field can not be null or empty");
                            break;
                        case 4:
                            logger.error("Follow Up SubStatus field can not be null or empty");
                            break;
                    }
                }
            }
            return false;
        }
        return true;
    }
}