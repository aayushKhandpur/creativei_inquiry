package creativei.enums;

/**
 * Created by user on 12/20/2017.
 */
public enum Occupation {

        STUDENT("Student"),
        SERVICE("Service"),
        BUSINESS("Business"),
        PROFESSIONAL("Professional"),
        HOUSEWIFE("House Wife");

        private String occupationValue;
        private Occupation(String occupationValue){
                this.occupationValue=occupationValue;
        }
        public static String enumToString(Occupation occupation){
                return occupation.occupationValue;
        }
        public static  Occupation stringToEnum(String s){
                for(Occupation x:Occupation.values())
                        if(x.occupationValue.equalsIgnoreCase(s)) return x;
                return null;
        }
    }


