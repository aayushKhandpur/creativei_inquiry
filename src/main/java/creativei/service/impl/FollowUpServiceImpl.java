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
            throw new InvalidParamRequest("Required field are either null or does not contain the appropirate value");
        return followUpDao.save(followUp);
    }

    @Override
    public FollowUp updateFollowUp(FollowUp followUp) throws InvalidParamRequest {
        if (!validateFollowUp(followUp))
            throw new InvalidParamRequest("Required field are either null or does not contain the appropirate value");
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
                            logger.error("CaseIndex field does not have appropirate value");
                            break;
                        case 1:
                            logger.error("FollowUp Date field does not have appropirate value");
                            break;
                        case 2:
                            logger.error("FollowUp Type field does not have appropirate value");
                            break;
                        case 3:
                            logger.error("FollowUp Status field does not have appropirate value");
                            break;
                        case 4:
                            logger.error("Follow Up SubStatus field does not have appropirate value");
                            break;
                    }
                }
            }
            return false;
        }
        return true;
    }
}