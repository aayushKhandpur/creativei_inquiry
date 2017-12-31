package creativei.enums;

/**
 * Created by user on 12/20/2017.
 */
public enum Gender {

        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private String genderValue;

        private Gender(String genderValue){
                this.genderValue=genderValue;
        }
        public static String enumToString(Gender gender){
                return gender.genderValue;
        }
        public static Gender stringToEnum(String s){
                for(Gender x:Gender.values())
                        if(x.genderValue.equalsIgnoreCase(s)) return x;

                return null;
        }
}
