package creativei.helper;

import creativei.entity.Branch;
import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.entity.InquiryEducation;
import creativei.enums.*;
import creativei.vo.AddressVo;
import creativei.vo.BranchVo;
import creativei.vo.EducationVo;
import creativei.vo.InquiryVo;
import org.springframework.beans.factory.annotation.Autowired;
import util.LocalizationUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Aayush on 12/24/2017.
 */
public class ResponseHelper {

       public static BranchVo getCreateBranchResponseData(Branch branch, BranchVo branchVo){
        branchVo.setAddress(branch.getAddress());
        branchVo.setName(branch.getName());
        branchVo.setEmail(branch.getEmail());
        branchVo.setAlternateName(branch.getAlternateName());
        branchVo.setFixedLineNumber(branch.getFixedLineNumber());
        branchVo.setMobile(branch.getMobile());
        branchVo.setId(branch.getId());
        return branchVo;
    }

    public static InquiryVo getCreateInquiryResponseData(Inquiry inquiry,InquiryVo inquiryVo){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm/dd/yyyy");
        Date defaultDate=null;
        String date="31/10/1996";
        try {
            defaultDate=simpleDateFormat.parse(date);
        }catch(ParseException e) {
            e.printStackTrace();
        }
        inquiryVo.setAreaOfInterest(AreaOfInterest.enumToString(inquiry.getAreaOfInterest()));
        inquiryVo.setName(inquiry.getName());
        String dateStr =inquiry.getDob().compareTo(defaultDate)==0 ? "" : LocalizationUtil.getFormattedDate(inquiry.getDob());
        inquiryVo.setDob(dateStr);
        inquiryVo.sethQualification(EducationQualification.enumToString(inquiry.getHighestEducation()));
        inquiryVo.setEmail(inquiry.getEmail());
        inquiryVo.setMobile(inquiry.getPhoneNumber());
        inquiryVo.setId(inquiry.getId());
        inquiryVo.setInquiryDate(LocalizationUtil.getFormattedDate(inquiry.getInquiryDate()));
        inquiryVo.setGender(Gender.enumToString(inquiry.getGender()));
        inquiryVo.setComputerKnowledge(ComputerKnowledge.enumToString(inquiry.getComputerKnowledge()));
        if(inquiryVo.getAddress()!=null)
            getCreateAddressResponseData(inquiry.getInquiryAddress(),inquiryVo.getAddress());
        if(inquiryVo.getEducationVo()!=null)
            getCreateEducationResponseData(inquiry.getInquiryEducation(),inquiryVo.getEducationVo());
        return inquiryVo;
    }
    private static AddressVo getCreateAddressResponseData(InquiryAddress inquiryAddress,AddressVo addressVo){
        addressVo.setId(inquiryAddress.getId());
        addressVo.setPin(inquiryAddress.getPincode());
        addressVo.setCity(inquiryAddress.getCity());
        addressVo.setArea(inquiryAddress.getArea());
        addressVo.setAddressLine1(inquiryAddress.getAddressLine1());
        addressVo.setCountry(inquiryAddress.getCountry());
        addressVo.setState(inquiryAddress.getState());
        return addressVo;
   }
   private static EducationVo getCreateEducationResponseData(InquiryEducation inquiryEducation,EducationVo educationVo){
        educationVo.setAggregateMarks(inquiryEducation.getAggregateMarks());
        educationVo.setEducationQualification(EducationQualification.enumToString(inquiryEducation.getEducationQualification()));
        educationVo.setInstituteName(inquiryEducation.getInstituteName());
        educationVo.setMarkScheme(MarkScheme.enumToString(inquiryEducation.getMarkScheme()));
        educationVo.setStatus(Status.enumToString(inquiryEducation.getStatus()));
        educationVo.setStream(inquiryEducation.getStream());
        educationVo.setYear(inquiryEducation.getYear());
        educationVo.setType(inquiryEducation.getType());
        return educationVo;
    }

}
