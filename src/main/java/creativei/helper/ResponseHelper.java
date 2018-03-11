package creativei.helper;

import creativei.entity.*;
import creativei.enums.*;
import creativei.vo.*;
import org.springframework.util.CollectionUtils;
import util.LocalizationUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aayush on 12/24/2017.
 */
public class ResponseHelper {

    public static BranchVo getCreateBranchResponseData(Branch branch, BranchVo branchVo) {
        branchVo.setAddress(branch.getAddress());
        branchVo.setName(branch.getName());
        branchVo.setEmail(branch.getEmail());
        branchVo.setAlternateName(branch.getAlternateName());
        branchVo.setFixedLineNumber(branch.getFixedLineNumber());
        branchVo.setMobile(branch.getMobile());
        branchVo.setId(branch.getId());
        return branchVo;
    }

    public static InquiryVo getCreateInquiryResponseData(Inquiry inquiry) {
        InquiryVo vo = new InquiryVo(inquiry);
        return vo;
    }

    public static InquiryVo getInquiryResponseById(Inquiry inquiry) {
        InquiryVo vo = new InquiryVo(inquiry);
        //follow-up
        if(!CollectionUtils.isEmpty(inquiry.getFollowUps())){
            List<FollowUpVo> followUps = new ArrayList<>();
            inquiry.getFollowUps().forEach(f ->{
                followUps.add(new FollowUpVo(f));
            });
            vo.setFollowUps(followUps);
        }
        return vo;
    }

    public static List<InquiryVo> getAllInquiryResponse(List<Inquiry> inquiries) {
        return getListOfInquiryVo(inquiries);
    }

    public static List<InquiryVo> getInquiryResponseByStatus(List<Inquiry> inquiries) {
        return getListOfInquiryVo(inquiries);
    }


    public static List<InquiryVo> getUnattendedInquiryResponse(List<Inquiry> inquiries) {
        return getListOfInquiryVo(inquiries);
    }

    public static List<InquiryVo> getByFiltersInquiryResponse(List<Inquiry> inquiries){
        return getListOfInquiryVo(inquiries);
    }

    private static List<InquiryVo> getListOfInquiryVo(List<Inquiry> inquiries){
        List<InquiryVo> inquiryVos=new ArrayList<>();
        inquiries.forEach(i -> {
            InquiryVo inquiryVo = new InquiryVo(i);
            FollowUp lastFollowUp = i.getFollowUps().stream().max((f1, f2) -> f1.getFollowUpDate().compareTo(f2.getFollowUpDate())).get();
            FollowUpVo followUpVo = new FollowUpVo(lastFollowUp);
            FollowUpVo[] followUpVos = {followUpVo};
            inquiryVo.setFollowUps(Arrays.asList(followUpVos));
            inquiryVos.add(inquiryVo);
        });
        return inquiryVos;
    }

    public static FollowUpVo getCreateFollowUpData(FollowUp followUp) {
        return new FollowUpVo(followUp);
    }

    public static ReminderVo getCreateReminderResponse(Reminder reminder) {
        return new ReminderVo(reminder);
    }

    public static List<ReminderVo> getReminderByDateRangeResponse(List<Reminder> reminders) {
        List<ReminderVo> reminderVos = new ArrayList<>();
        for (Reminder reminder : reminders) {
            reminderVos.add(new ReminderVo(reminder));
        }
        return reminderVos;
    }
}
