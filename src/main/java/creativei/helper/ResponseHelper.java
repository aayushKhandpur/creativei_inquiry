package creativei.helper;

import creativei.entity.*;
import creativei.enums.*;
import creativei.vo.*;
import util.LocalizationUtil;

import javax.validation.constraints.Size;
import java.util.Iterator;
import java.util.List;

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
        if(inquiryVo.getMarketing()!=null)
            getCreateMarketingResponseData(inquiry.getInquiryMarketing(),inquiryVo.getMarketing());
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
   private static List<EducationVo> getCreateEducationResponseData(List<InquiryEducation> inquiryEducation, List<EducationVo> educationVo) {
       Iterator iterator = inquiryEducation.iterator();
       Integer i=0;
       while (iterator.hasNext()) {
           educationVo.get(i).setId(inquiryEducation.get(i).getId());
           educationVo.get(i).setAggregateMarks(inquiryEducation.get(i).getAggregateMarks() == null ? null : inquiryEducation.get(i).getAggregateMarks());
           educationVo.get(i).setEducationQualification(EducationQualification.enumToString(inquiryEducation.get(i).getEducationQualification()));
           educationVo.get(i).setInstituteName(inquiryEducation.get(i).getInstituteName() == null ? null : inquiryEducation.get(i).getInstituteName());
           educationVo.get(i).setMarkScheme(MarkScheme.enumToString(inquiryEducation.get(i).getMarkScheme()));
           educationVo.get(i).setStatus(EducationStatus.enumToString(inquiryEducation.get(i).getStatus()));
           educationVo.get(i).setStream(Stream.enumToString(inquiryEducation.get(i).getStream()));
           educationVo.get(i).setYear(inquiryEducation.get(i).getYear() == null ? null : inquiryEducation.get(i).getYear());
           educationVo.get(i).setType(inquiryEducation.get(i).getType() == null ? null : inquiryEducation.get(i).getType());
           iterator.next();
           i++;
       }
       return educationVo;
   }

    private static GuardianVo getCreateGuardianResponseData(InquiryGuardian inquiryGuardian,GuardianVo guardianVo){
        guardianVo.setId(inquiryGuardian.getId());
        guardianVo.setName(inquiryGuardian.getName());
        guardianVo.setRelation(Relation.enumToString(inquiryGuardian.getRelation()));
        guardianVo.setEmail(inquiryGuardian.getEmail());
        guardianVo.setPhoneNumber(inquiryGuardian.getPhoneNumber());
        guardianVo.setOccupation(Occupation.enumToString(inquiryGuardian.getOccupation()));
        return guardianVo;
    }
    private static MarketingVo getCreateMarketingResponseData(InquiryMarketing inquiryMarketing,MarketingVo marketingVo){
        marketingVo.setId(inquiryMarketing.getId());
        marketingVo.setSource(MarketingSource.enumToString(inquiryMarketing.getMarketingSource()));
        marketingVo.setReferant(inquiryMarketing.getReferant()==null?null:inquiryMarketing.getReferant());
        marketingVo.setReferred(inquiryMarketing.getIsReferred()==null?null:inquiryMarketing.getIsReferred());
        return marketingVo;
    }

}
