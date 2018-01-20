package creativei.manager.impl;

import creativei.entity.City;
import creativei.entity.Inquiry;
import creativei.entity.Locality;
import creativei.entity.State;
import creativei.enums.ExceptionType;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.UniqueConstraintViolationException;
import creativei.helper.ResponseHelper;
import creativei.manager.InquiryManager;
import creativei.service.InquiryService;
import creativei.service.LocalityService;
import creativei.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

@Service
public class InquiryManagerImpl implements InquiryManager {
   private static final Logger logger= LoggerFactory.getLogger(InquiryManagerImpl.class);
    @Autowired
    InquiryService inquiryService;
    @Autowired
    LocalityService localityService;

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
     }catch(InvalidParamRequest ipr) {
         logger.error(ipr.getMessage(),ipr);
         return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(),ExceptionType.INVALID_METHOD_PARAM.getCode());
     }catch (DataIntegrityException de) {
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
    public ResponseObject update(InquiryVo inquiryVo) {
    Inquiry inquiry;
    try{
         inquiry=new Inquiry(inquiryVo);
         inquiry=inquiryService.update(inquiry);
         inquiryVo=ResponseHelper.getCreateInquiryResponseData(inquiry,inquiryVo);
         return ResponseObject.getResponse(inquiryVo);
     }catch (UniqueConstraintViolationException ue){
         logger.error(ue.getMessage(),ue);
         return ResponseObject.getResponse(ue.getMessage(), ExceptionType.DUPLICATE_VALUE.getCode());
     }catch(InvalidParamRequest ipr) {
         logger.error(ipr.getMessage(),ipr);
         return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(),ExceptionType.INVALID_METHOD_PARAM.getCode());
     }catch (DataIntegrityException de) {
         logger.error(de.getMessage(), de);
         return ResponseObject.getResponse(ExceptionType.DATABASE_EXCEPTION.getMessage(), ExceptionType.DATABASE_EXCEPTION.getCode());
     } catch (Exception e){
         logger.error(e.getMessage(), e);
         return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
      }
    }

    @Override
    public ResponseObject updateAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public ResponseObject getAllEnum() {
        InquiryServerInfoVo inquiryServerInfoVo=new InquiryServerInfoVo();
        return ResponseObject.getResponse(inquiryServerInfoVo);
    }

    @Override
    public ResponseObject getPincodes(String pincode) {
        List<String> pin= localityService.getListOfPincode(pincode);
        return ResponseObject.getResponse(pin);
    }

    @Override
    public ResponseObject getLocalityDataByPincode(String pincode) {
        AddressDataVo addressDataVo =new AddressDataVo();
        List<Locality> localities= localityService.getLocality(pincode);
        City cityId= localityService.getLocality(pincode).get(0).getCity();
        CityVo city=new CityVo();
        city.setName(cityId.getName());
        city.setId(cityId.getId());
        State stateId=cityId.getState();
        String state=stateId.getName();
        String country=stateId.getCountry();
        List<LocalityVo> loc=new ArrayList<>();
        Iterator iterator=localities.iterator();
        int i=0;
        while(iterator.hasNext()) {
            loc.add(new LocalityVo(localities.get(i).getId(),localities.get(i).getName()));
            iterator.next();
            i++;
        }
        addressDataVo.setLocality(loc);
        addressDataVo.setCountry(country);
        addressDataVo.setState(state);
        addressDataVo.setCity(city);
        return ResponseObject.getResponse(addressDataVo);
    }
}
