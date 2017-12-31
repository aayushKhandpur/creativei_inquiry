package creativei.enums;

/**
 * Created by user on 12/20/2017.
 */
public enum EducationQualification {
        SSC("SSC"),
        HSC("HSC"),
        UNDERGRADUATE("Undergraduate"),
        GRADUATE("Graduate"),
        POSTGRADUATE("Post Graduate"),
        ENGINEER("Engineer"),
        DIPLOMA("Diploma");
        private String val;

        private EducationQualification(String educationQualification) {
                this.val=educationQualification;
        }

        public static String enumToString(EducationQualification educationQualification){
                return educationQualification.val;
        }

        public static EducationQualification stringToEnum(String s){
          for(EducationQualification x:EducationQualification.values()){
                if(x.val.equalsIgnoreCase(s)) return x;
            }
            return null;
    }

}
