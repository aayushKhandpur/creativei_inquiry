package creativei.manager.impl;

import creativei.entity.FollowUp;
import creativei.entity.Inquiry;
import creativei.enums.ExceptionType;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.NoDataAvailable;
import creativei.helper.ResponseHelper;
import creativei.manager.FollowUpManager;
import creativei.service.FollowUpService;
import creativei.service.InquiryService;
import creativei.vo.FollowUpServerInfo;
import creativei.vo.FollowUpVo;
import creativei.vo.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowUpManagerImpl implements FollowUpManager {
    private final Logger logger = LoggerFactory.getLogger(FollowUpManagerImpl.class);
    @Autowired
    FollowUpService followUpService;

    @Autowired
    InquiryService inquiryService;

    @Override
    public ResponseObject getFollowUpServerInfo() {
        FollowUpServerInfo followUpServerInfo = new FollowUpServerInfo();
        return ResponseObject.getResponse(followUpServerInfo);
    }

    @Override
    public ResponseObject createFollowUp(FollowUpVo followUpVo) {
        try {
            FollowUp followUp = new FollowUp(followUpVo);
            followUp = followUpService.createFollowUp(followUp);
            //update inquiry isAttendedStatus
            updateInquiryAttendedStatus(followUp.getInquiry());

            followUpVo = ResponseHelper.getCreateFollowUpData(followUp);
            return ResponseObject.getResponse(followUpVo);
        } catch (InvalidParamRequest e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }

    private void updateInquiryAttendedStatus(Inquiry inquiry){
        if(inquiry == null){
            logger.error("Null inquiry for the follow-up create request");
            return;
        }
        try {
            inquiry = inquiryService.getById(inquiry.getId());
            if(!inquiry.getAttended()){
                inquiry.setAttended(true);
                inquiryService.update(inquiry);
            }
        } catch (NoDataAvailable nda) {
            logger.error("Unable to get inquiry for the follow-up. Inq Id: "+ inquiry.getId(), nda);
        } catch (DataIntegrityException | InvalidParamRequest die) {
            logger.error("Unable to update inquiry un-attended status. Inq Id: "+ inquiry.getId(), die);
        }
    }

    @Override
    public ResponseObject updateFollowUp(FollowUpVo followUpVo) {
        try {
            FollowUp followUp = new FollowUp(followUpVo);
            followUp = followUpService.updateFollowUp(followUp);
            followUpVo = ResponseHelper.getCreateFollowUpData(followUp);
            return ResponseObject.getResponse(followUpVo);
        } catch (InvalidParamRequest e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }
}
