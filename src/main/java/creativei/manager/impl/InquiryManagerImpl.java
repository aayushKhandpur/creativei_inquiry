package creativei.manager.impl;

import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.entity.Locality;
import creativei.enums.ExceptionType;
import creativei.enums.InquiryStatus;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.NoDataAvailable;
import creativei.exception.UniqueConstraintViolationException;
import creativei.helper.ResponseHelper;
import creativei.manager.InquiryManager;
import creativei.service.InquiryAddressService;
import creativei.service.InquiryService;
import creativei.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryManagerImpl implements InquiryManager {
    private static final Logger logger = LoggerFactory.getLogger(InquiryManagerImpl.class);
    @Autowired
    InquiryService inquiryService;
    @Autowired
    InquiryAddressService inquiryAddressService;

    @Override
    public ResponseObject getAll() {
        List<Inquiry> inquiries = inquiryService.getAll();
        List<InquiryVo> inquiryVos = ResponseHelper.getAllInquiryResponse(inquiries, new InquiryVo());
        return ResponseObject.getResponse(inquiryVos);
    }

    @Override
    public ResponseObject getByStatus(InquiryStatus status) {
        List<Inquiry> inquiries = null;
        try {
            inquiries = inquiryService.getByStatus(status);
            List<InquiryVo> inquiryVos = ResponseHelper.getInquiryResponseByStatus(inquiries, new InquiryVo());
            return ResponseObject.getResponse(inquiryVos);
        } catch (NoDataAvailable noDataAvailable) {
            logger.error(noDataAvailable.getMessage(), noDataAvailable);
            return ResponseObject.getResponse(ExceptionType.DATA_NOT_AVAILABLE.getMessage(), ExceptionType.DATA_NOT_AVAILABLE.getCode());
        }
    }

    @Override
    public ResponseObject create(InquiryVo inquiryVo) {
        try {
            Inquiry inquiry = new Inquiry(inquiryVo);
            inquiry = inquiryService.create(inquiry);
            inquiry.getInquiryAddress().setLocation(inquiryAddressService.getLocalityData(inquiry.getInquiryAddress().getLocation().getId()));
            inquiryVo = ResponseHelper.getCreateInquiryResponseData(inquiry, inquiryVo);
            return ResponseObject.getResponse(inquiryVo);
        } catch (UniqueConstraintViolationException ue) {
            logger.error(ue.getMessage(), ue);
            return ResponseObject.getResponse(ExceptionType.DUPLICATE_VALUE.getMessage(), ExceptionType.DUPLICATE_VALUE.getCode());
        } catch (InvalidParamRequest ipr) {
            logger.error(ipr.getMessage(), ipr);
            return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode());
        } catch (DataIntegrityException de) {
            logger.error(de.getMessage(), de);
            return ResponseObject.getResponse(ExceptionType.DATABASE_EXCEPTION.getMessage(), ExceptionType.DATABASE_EXCEPTION.getCode());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());

        }
    }

    @Override
    public ResponseObject getById(Long id) {
        try {
            Inquiry inquiry = inquiryService.getById(id);
            InquiryVo inquiryVo = ResponseHelper.getInquiryResponseById(inquiry, new InquiryVo());
            return ResponseObject.getResponse(inquiryVo);
        } catch (NoDataAvailable noDataAvailable) {
            logger.error("Inquiry field is empty for id: " + id);
            return ResponseObject.getResponse(ExceptionType.DATA_NOT_AVAILABLE.getMessage(), ExceptionType.DATA_NOT_AVAILABLE.getCode());
        }
    }

    @Override
    public ResponseObject getByName(String name) {
        return null;
    }

    @Override
    public ResponseObject createAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public ResponseObject update(InquiryVo inquiryVo) {
        Inquiry inquiry;
        try {
            inquiry = new Inquiry(inquiryVo);
            inquiry = inquiryService.update(inquiry);
            inquiryVo = ResponseHelper.getCreateInquiryResponseData(inquiry, inquiryVo);
            return ResponseObject.getResponse(inquiryVo);
        } catch (UniqueConstraintViolationException ue) {
            logger.error(ue.getMessage(), ue);
            return ResponseObject.getResponse(ue.getMessage(), ExceptionType.DUPLICATE_VALUE.getCode());
        } catch (InvalidParamRequest ipr) {
            logger.error(ipr.getMessage(), ipr);
            return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode());
        } catch (DataIntegrityException de) {
            logger.error(de.getMessage(), de);
            return ResponseObject.getResponse(ExceptionType.DATABASE_EXCEPTION.getMessage(), ExceptionType.DATABASE_EXCEPTION.getCode());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }

    @Override
    public ResponseObject updateAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public ResponseObject getInquiryServerInfo() {
        InquiryServerInfoVo inquiryServerInfoVo = new InquiryServerInfoVo();
        return ResponseObject.getResponse(inquiryServerInfoVo);
    }

}
