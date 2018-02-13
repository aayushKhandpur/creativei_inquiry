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
        if (followUp.getCaseIndex() == null || followUp.getFollowUpDate() == null || followUp.getType() == null || followUp.getStatus() == null || followUp.getSubStatus() == null) {
            logger.error("Some or more required field is missing");
            return false;
        }
        return true;
    }
}