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
    private static final Logger logger = LoggerFactory.getLogger(FollowUpService.class);
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

        if (followUp.getCaseIndex() == null) {
            logger.error("CaseIndex field does not have appropirate value");
            return false;
        }
        if (followUp.getFollowUpDate() == null) {
            logger.error("FollowUp Type field does not have appropirate value");
            return false;
        }

        if (followUp.getType() == null) {
            logger.error("FollowUp Type field does not have appropirate value");
            return false;
        }
        if (followUp.getStatus() == null) {
            logger.error("FollowUp Status field does not have appropirate value");
            return false;
        }
        if (followUp.getSubStatus() == null) {
            logger.error("Follow Up SubStatus field does not have appropirate value");
            return false;
        }
        return true;
    }
}