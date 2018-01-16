package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    public static List<String> getEnumValue(){
        List<String> s= java.util.stream.Stream.of(EducationQualification.values()).map(educationQualification -> educationQualification.value).collect(Collectors.toList());
        return s;
    }
    private static final Map<String, EducationQualification> lookup = new HashMap<String,EducationQualification>();

    static {
        for ( EducationQualification educationQualification: EducationQualification.values()) {
            lookup.put(educationQualification.enumToString(educationQualification).toLowerCase(),educationQualification );
        }
    }

    public static String enumToString(EducationQualification educationQualification) {
        if(educationQualification==null){return  null;}
        return educationQualification.value;
    }

    public static EducationQualification stringToEnum(String value) {
        if(value==null){return  null;}
        return lookup.get(value.toLowerCase());
    }

}
