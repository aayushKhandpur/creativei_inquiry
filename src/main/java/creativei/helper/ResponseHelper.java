package creativei.helper;

import creativei.entity.*;
import creativei.enums.*;
import creativei.vo.*;
import util.LocalizationUtil;

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
        inquiryVo.setAreaOfInterest(AreaOfInterest.enumToString(inquiry.getAreaOfInterest()));
        inquiryVo.setName(inquiry.getName());
        inquiryVo.setDob(LocalizationUtil.getFormattedDate(inquiry.getDob()));
        inquiryVo.sethQualification(EducationQualification.enumToString(inquiry.getHighestEducation()));
        inquiryVo.setEmail(inquiry.getEmail());
        inquiryVo.setMobile(inquiry.getPhoneNumber());
        inquiryVo.setId(inquiry.getId());
        inquiryVo.setInquiryDate(LocalizationUtil.getFormattedDate(inquiry.getInquiryDate()));
        inquiryVo.setGender(Gender.enumToString(inquiry.getGender()));
        inquiryVo.setComputerKnowledge(ComputerKnowledge.enumToString(inquiry.getComputerKnowledge()));
        if(inquiry.getInquiryAddress()!=null)
            getCreateAddressResponseData(inquiry.getInquiryAddress(),inquiryVo.getAddress());
        if(inquiryVo.getEducation()!=null)
            getCreateEducationResponseData(inquiry.getInquiryEducation(),inquiryVo.getEducation());
        if(inquiryVo.getGuardian()!=null)
            getCreateGuardianResponseData(inquiry.getInquiryGuardian(),inquiryVo.getGuardian());
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
        educationVo.setAggregateMarks(inquiryEducation.getAggregateMarks()==null?null:inquiryEducation.getAggregateMarks());
        educationVo.setEducationQualification(EducationQualification.enumToString(inquiryEducation.getEducationQualification()));
        educationVo.setInstituteName(inquiryEducation.getInstituteName()==null?null:inquiryEducation.getInstituteName());
        educationVo.setMarkScheme(MarkScheme.enumToString(inquiryEducation.getMarkScheme()));
        educationVo.setStatus(EducationStatus.enumToString(inquiryEducation.getStatus()));
        educationVo.setStream(Stream.enumToString(inquiryEducation.getStream()));
        educationVo.setYear(inquiryEducation.getYear()==null?null:inquiryEducation.getYear());
        educationVo.setType(inquiryEducation.getType()==null?null:inquiryEducation.getType());
        return educationVo;
    }

    private static GuardianVo getCreateGuardianResponseData(InquiryGuardian inquiryGuardian,GuardianVo guardianVo){
       guardianVo.setName(inquiryGuardian.getName());
       guardianVo.setRelation(Relation.enumToString(inquiryGuardian.getRelation()));
       guardianVo.setEmail(inquiryGuardian.getEmail());
       guardianVo.setPhoneNumber(inquiryGuardian.getPhoneNumber());
       guardianVo.setOccupation(Occupation.enumToString(inquiryGuardian.getOccupation()));
       return guardianVo;
    }
    private static MarketingVo getCreateMarketingResponseData(InquiryMarketing inquiryMarketing,MarketingVo marketingVo){
        marketingVo.setSource(Source.enumToString(inquiryMarketing.getSource()));
        marketingVo.setReferant(inquiryMarketing.getReferant());
        marketingVo.setReferred(inquiryMarketing.getIsReferred());
        return marketingVo;
    }

}
