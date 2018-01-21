package creativei.helper;

import creativei.entity.*;
import creativei.enums.*;
import creativei.vo.*;
import util.LocalizationUtil;

import javax.validation.constraints.Size;
import java.util.ArrayList;
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
        inquiryVo.setInquiryStatus(InquiryStatus.enumToString(inquiry.getInquiryStatus()));
        if(inquiryVo.getAddress()!=null)
            inquiryVo.setAddress(getCreateAddressResponseData(inquiry.getInquiryAddress(),inquiryVo.getAddress()));
        if(inquiryVo.getEducation()!=null)
            inquiryVo.setEducation(getCreateEducationResponseData(inquiry.getInquiryEducation(),inquiryVo.getEducation()));
        if(inquiryVo.getGuardian()!=null)
            inquiryVo.setGuardian(getCreateGuardianResponseData(inquiry.getInquiryGuardian(),inquiryVo.getGuardian()));
        if(inquiryVo.getMarketing()!=null)
            inquiryVo.setMarketing(getCreateMarketingResponseData(inquiry.getInquiryMarketing(),inquiryVo.getMarketing()));
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
   private static List<EducationVo> getCreateEducationResponseData(List<InquiryEducation> inquiryEducation, List<EducationVo> educationVos) {
       EducationVo educationVo=new EducationVo();
       Iterator iterator = inquiryEducation.iterator();
       Integer i=0;
       while (iterator.hasNext()) {
           educationVo.setId(inquiryEducation.get(i).getId());
           educationVo.setAggregateMarks(inquiryEducation.get(i).getAggregateMarks() == null ? null : inquiryEducation.get(i).getAggregateMarks());
           educationVo.setEducationQualification(EducationQualification.enumToString(inquiryEducation.get(i).getEducationQualification()));
           educationVo.setInstituteName(inquiryEducation.get(i).getInstituteName() == null ? null : inquiryEducation.get(i).getInstituteName());
           educationVo.setMarkScheme(MarkScheme.enumToString(inquiryEducation.get(i).getMarkScheme()));
           educationVo.setStatus(EducationStatus.enumToString(inquiryEducation.get(i).getStatus()));
           educationVo.setStream(Stream.enumToString(inquiryEducation.get(i).getStream()));
           educationVo.setYear(inquiryEducation.get(i).getYear() == null ? null : inquiryEducation.get(i).getYear());
           educationVo.setType(inquiryEducation.get(i).getType() == null ? null : inquiryEducation.get(i).getType());
           iterator.next();
           i++;
           educationVos.add(educationVo);
       }
       return educationVos;
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

    public static InquiryVo getInquiryResponseById(Inquiry inquiry,InquiryVo inquiryVo){
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
        inquiryVo.setAddress(getCreateAddressResponseData(inquiry.getInquiryAddress(),new AddressVo()));
        List<EducationVo> educationVos=new ArrayList<>();
        if(inquiry.getInquiryEducation()!=null)
            inquiryVo.setEducation(getCreateEducationResponseData(inquiry.getInquiryEducation(),educationVos));
        if(inquiry.getInquiryGuardian()!=null)
            inquiryVo.setGuardian(getCreateGuardianResponseData(inquiry.getInquiryGuardian(),new GuardianVo()));
        if(inquiry.getInquiryMarketing()!=null)
            inquiryVo.setMarketing(getCreateMarketingResponseData(inquiry.getInquiryMarketing(),new MarketingVo()));
        return inquiryVo;
    }

    public static List<InquiryVo> getAllInquiryResponse(List<Inquiry> inquiries,InquiryVo inquiryVo){
        List<InquiryVo> inquiryVos=new ArrayList<>();
        Iterator iterator=inquiries.iterator();
        int i=0;
        while(iterator.hasNext()){
            inquiryVo.setAreaOfInterest(AreaOfInterest.enumToString(inquiries.get(i).getAreaOfInterest()));
            inquiryVo.setName(inquiries.get(i).getName());
            inquiryVo.setDob(LocalizationUtil.getFormattedDate(inquiries.get(i).getDob()));
            inquiryVo.sethQualification(EducationQualification.enumToString(inquiries.get(i).getHighestEducation()));
            inquiryVo.setEmail(inquiries.get(i).getEmail());
            inquiryVo.setMobile(inquiries.get(i).getPhoneNumber());
            inquiryVo.setId(inquiries.get(i).getId());
            inquiryVo.setInquiryDate(LocalizationUtil.getFormattedDate(inquiries.get(i).getInquiryDate()));
            inquiryVo.setGender(Gender.enumToString(inquiries.get(i).getGender()));
            inquiryVo.setComputerKnowledge(ComputerKnowledge.enumToString(inquiries.get(i).getComputerKnowledge()));
            inquiryVo.setAddress(getCreateAddressResponseData(inquiries.get(i).getInquiryAddress(),new AddressVo()));
            List<EducationVo> educationVos=new ArrayList<>();
            if(inquiries.get(i).getInquiryEducation()!=null)
                inquiryVo.setEducation(getCreateEducationResponseData(inquiries.get(i).getInquiryEducation(),educationVos));
            if(inquiries.get(i).getInquiryGuardian()!=null)
                inquiryVo.setGuardian(getCreateGuardianResponseData(inquiries.get(i).getInquiryGuardian(),new GuardianVo()));
            if(inquiries.get(i).getInquiryMarketing()!=null)
                inquiryVo.setMarketing(getCreateMarketingResponseData(inquiries.get(i).getInquiryMarketing(),new MarketingVo()));
            iterator.next();
            i++;
            inquiryVos.add(inquiryVo);
        }
        return inquiryVos;
    }

    public static List<InquiryVo> getInquiryResponseByStatus(List<Inquiry> inquiries,InquiryVo inquiryVo){
        List<InquiryVo> inquiryVos=new ArrayList<>();
        Iterator iterator=inquiries.iterator();
        int i=0;
        while(iterator.hasNext()){
            inquiryVo.setAreaOfInterest(AreaOfInterest.enumToString(inquiries.get(i).getAreaOfInterest()));
            inquiryVo.setName(inquiries.get(i).getName());
            inquiryVo.setDob(LocalizationUtil.getFormattedDate(inquiries.get(i).getDob()));
            inquiryVo.sethQualification(EducationQualification.enumToString(inquiries.get(i).getHighestEducation()));
            inquiryVo.setEmail(inquiries.get(i).getEmail());
            inquiryVo.setInquiryStatus(InquiryStatus.enumToString(inquiries.get(i).getInquiryStatus()));
            inquiryVo.setMobile(inquiries.get(i).getPhoneNumber());
            inquiryVo.setId(inquiries.get(i).getId());
            inquiryVo.setInquiryDate(LocalizationUtil.getFormattedDate(inquiries.get(i).getInquiryDate()));
            inquiryVo.setGender(Gender.enumToString(inquiries.get(i).getGender()));
            inquiryVo.setComputerKnowledge(ComputerKnowledge.enumToString(inquiries.get(i).getComputerKnowledge()));
            inquiryVo.setAddress(getCreateAddressResponseData(inquiries.get(i).getInquiryAddress(),new AddressVo()));
            List<EducationVo> educationVos=new ArrayList<>();
            if(inquiries.get(i).getInquiryEducation()!=null)
                inquiryVo.setEducation(getCreateEducationResponseData(inquiries.get(i).getInquiryEducation(),educationVos));
            if(inquiries.get(i).getInquiryGuardian()!=null)
                inquiryVo.setGuardian(getCreateGuardianResponseData(inquiries.get(i).getInquiryGuardian(),new GuardianVo()));
            if(inquiries.get(i).getInquiryMarketing()!=null)
                inquiryVo.setMarketing(getCreateMarketingResponseData(inquiries.get(i).getInquiryMarketing(),new MarketingVo()));
            iterator.next();
            i++;
            inquiryVos.add(inquiryVo);
        }
        return inquiryVos;
    }


    }
