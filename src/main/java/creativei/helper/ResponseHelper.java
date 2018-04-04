package creativei.helper;

import creativei.entity.*;
import creativei.vo.*;
import org.springframework.util.CollectionUtils;
import creativei.util.LocalizationUtil;

import java.util.*;

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
        //reminders
        if(!CollectionUtils.isEmpty(inquiry.getReminders())){
            List<ReminderVo> reminders = new ArrayList<>();
            inquiry.getReminders().forEach(r -> {
                reminders.add(new ReminderVo(r));
            });
            vo.setReminders(reminders);
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
            FollowUp lastFollowUp = i.getFollowUps().stream().max(Comparator.comparing(FollowUp::getFollowUpDate)).orElse(null);
            List<FollowUpVo>followUpVos = new ArrayList<>(1);
            if(lastFollowUp != null) followUpVos.add(new FollowUpVo(lastFollowUp));
            inquiryVo.setFollowUps(followUpVos);
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
