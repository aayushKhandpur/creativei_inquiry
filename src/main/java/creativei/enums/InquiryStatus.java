package creativei.enums;

import creativei.entity.Inquiry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum InquiryStatus {
    OPEN("Open"),
    CLOSE("Close");

    private String value;
    private InquiryStatus(String value){
        this.value=value;
    }


    private static final Map<String, InquiryStatus> lookup = new HashMap<String, InquiryStatus>();


    static {
        for (InquiryStatus inquiryStatus : InquiryStatus.values()) {
            lookup.put(inquiryStatus.enumToString(inquiryStatus).toLowerCase(), inquiryStatus);
        }
    }

    public static String enumToString(InquiryStatus inquiryStatus) {
        if (inquiryStatus == null) {
            return null;
        }
        return inquiryStatus.value;
    }

    public static InquiryStatus stringToEnum(String value) {
        if (value == null) {
            return OPEN;
        }
        return lookup.get(value.toLowerCase());
    }

}
