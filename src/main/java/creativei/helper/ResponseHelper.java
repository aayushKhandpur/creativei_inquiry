package creativei.helper;

import creativei.entity.Branch;
import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.vo.AddressVo;
import creativei.vo.BranchVo;
import creativei.vo.InquiryVo;
import org.springframework.beans.factory.annotation.Autowired;
import util.LocalizationUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        inquiryVo.setAreaOfInterest(inquiry.getAreaOfInterest());
        inquiryVo.setName(inquiry.getName());
        String dateStr = inquiry.getDob() == null ? "" : LocalizationUtil.getFormattedDate(inquiry.getDob());
        inquiryVo.sethQualification(inquiry.getHighestEducation());
        inquiryVo.setEmail(inquiry.getEmail());
        inquiryVo.setMobile(inquiry.getPhoneNumber());
        inquiryVo.setId(inquiry.getId());
        return inquiryVo;
    }
   public static AddressVo getCreateAddressResponseData(InquiryAddress inquiryAddress,AddressVo addressVo){
        addressVo.setId(inquiryAddress.getId());
        addressVo.setPin(inquiryAddress.getPincode());
        addressVo.setCity(inquiryAddress.getCity());
        addressVo.setArea(inquiryAddress.getArea());
        addressVo.setAddressLine1(inquiryAddress.getAddressLine1());
        return addressVo;
   }

}
