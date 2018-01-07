package creativei.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    private static final Map<String, EducationQualification> lookup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER
    );

    static {
        for ( EducationQualification educationQualification: EducationQualification.values()) {
            lookup.put(educationQualification.enumToString(educationQualification),educationQualification );
        }
    }

    public static String enumToString(EducationQualification educationQualification) {
        if(educationQualification==null){return  null;}
        return educationQualification.value;
    }

    public static EducationQualification stringToEnum(String value) {
        if(value==null){return  null;}
        return lookup.get(value);
    }

}
