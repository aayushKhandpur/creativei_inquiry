package creativei.enums;

import java.util.HashMap;
import java.util.Map;

public enum EducationQualification {
        SSC("SSC"),
        HSC("HSC"),
        UNDERGRADUATE("Undergraduate"),
        GRADUATE("Graduate"),
        POSTGRADUATE("Post Graduate"),
        ENGINEER("Engineer"),
        DIPLOMA("Diploma");

    private String value;

    private EducationQualification(String value) {
        this.value = value;
    }

    private static final Map<String, EducationQualification> lookup = new HashMap<String, EducationQualification>();

    static {
        for ( EducationQualification educationQualification: EducationQualification.values()) {
            lookup.put(educationQualification.enumToString(educationQualification),educationQualification );
        }
    }

    public static String enumToString(EducationQualification educationQualification) {
        return educationQualification.value;
    }

    public static EducationQualification stringToEnum(String value) {
        return lookup.get(value);
    }

}
