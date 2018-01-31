package creativei.service;

import creativei.entity.FollowUp;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;

public interface FollowUpService {
    public FollowUp createFollowUp(FollowUp followUp) throws  InvalidParamRequest;
}
