package creativei.helper;

import creativei.entity.*;
import creativei.enums.*;
import creativei.vo.*;
import util.LocalizationUtil;

import java.util.ArrayList;
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
        InquiryVo inquiryVo = new InquiryVo(inquiry);
        return inquiryVo;
    }

    public static InquiryVo getInquiryResponseById(Inquiry inquiry) {
        InquiryVo inquiryVo = new InquiryVo(inquiry);
        return inquiryVo;
    }

    public static List<InquiryVo> getAllInquiryResponse(List<Inquiry> inquiries) {
        List<InquiryVo> inquiryVos = new ArrayList<>();
        for (Inquiry inquiry : inquiries) {
            InquiryVo inquiryVo = new InquiryVo(inquiry);
            inquiryVos.add(inquiryVo);
        }
        return inquiryVos;
    }

    public static List<InquiryVo> getInquiryResponseByStatus(List<Inquiry> inquiries) {
        List<InquiryVo> inquiryVos = new ArrayList<>();
        for (Inquiry inquiry : inquiries) {
            InquiryVo inquiryVo = new InquiryVo(inquiry);
            inquiryVos.add(inquiryVo);
        }
        return inquiryVos;
    }


    public static List<InquiryVo> getUnattendedInquiryResponse(List<Inquiry> inquiries) {
        List<InquiryVo> inquiryVos = new ArrayList<>();
        for (Inquiry inquiry : inquiries) {
            InquiryVo inquiryVo = new InquiryVo(inquiry);
            inquiryVos.add(inquiryVo);
        }
        return inquiryVos;
    }

    public static FollowUpVo getCreateFollowUpData(FollowUp followUp, FollowUpVo followUpVo) {
        followUpVo.setId(followUp.getId());
        followUpVo.setCaseIndex(CaseIndex.enumToString(followUp.getCaseIndex()));
        followUpVo.setFollowUpDate(LocalizationUtil.getFormattedDate(followUp.getFollowUpDate()));
        followUpVo.setFollowUpStatus(FollowUpStatus.enumToString(followUp.getStatus()));
        followUpVo.setFollowUpType(FollowUpType.enumToString(followUp.getType()));
        followUpVo.setRemark(followUp.getRemark());
        followUpVo.setSubStatus(FollowUpSubStatus.enumToString(followUp.getSubStatus()));
        return followUpVo;
    }

    public static ReminderVo getCreateReminderResponse(Reminder reminder) {
        ReminderVo reminderVo = new ReminderVo(reminder);
        return reminderVo;
    }

    public static List<ReminderVo> getReminderByDateRangeResponse(List<Reminder> reminders) {
        List<ReminderVo> reminderVos = new ArrayList<>();
        for (Reminder reminder : reminders) {
            ReminderVo reminderVo = new ReminderVo(reminder);
            reminderVos.add(reminderVo);
        }
        return reminderVos;
    }
}
