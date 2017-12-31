package creativei.manager.impl;

import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.enums.ExceptionType;
import creativei.exception.DataIntegrityException;
import creativei.exception.UniqueConstraintViolationException;
import creativei.helper.ResponseHelper;
import creativei.manager.InquiryManager;
import creativei.service.BranchService;
import creativei.service.InquiryAddressService;
import creativei.service.InquiryService;
import creativei.service.impl.InquiryAddressServiceImpl;
import creativei.vo.AddressVo;
import creativei.vo.InquiryVo;
import creativei.vo.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
@Service
public class InquiryManagerImpl implements InquiryManager {
   private static final Logger logger= LoggerFactory.getLogger(InquiryManagerImpl.class);
    @Autowired
    InquiryService inquiryService;
    @Autowired
    InquiryAddressService inquiryAddressService;

    @Override
    public ResponseObject getAll() {
        return null;
    }

    @Override
    public ResponseObject create(InquiryVo inquiryVo) {
     try{
            Inquiry inquiry=new Inquiry(inquiryVo);
            inquiry= inquiryService.create(inquiry);
            inquiryVo=ResponseHelper.getCreateInquiryResponseData(inquiry,inquiryVo);
            return ResponseObject.getResponse(inquiryVo);
     }catch (UniqueConstraintViolationException ue){
         logger.error(ue.getMessage(),ue);
         return ResponseObject.getResponse(ue.getMessage(), ExceptionType.DUPLICATE_VALUE.getCode());
     } catch (DataIntegrityException de) {
         logger.error(de.getMessage(), de);
         return ResponseObject.getResponse(ExceptionType.DATABASE_EXCEPTION.getMessage(), ExceptionType.DATABASE_EXCEPTION.getCode());
     } catch (Exception e){
         logger.error(e.getMessage(), e);
         return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());

     }
    }

    @Override
    public ResponseObject getById(Long id) {
        return null;
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
    public ResponseObject update(Inquiry inquiry) {
        return null;
    }

    @Override
    public ResponseObject updateAll(List<Inquiry> inquiries) {
        return null;
    }
}
