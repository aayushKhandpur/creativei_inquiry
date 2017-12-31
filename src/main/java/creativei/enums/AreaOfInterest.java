package creativei.enums;

public enum  AreaOfInterest  {
    WEB_DESIGNING("Web Designing"),
    VFX("VFX"),
    WEB_DEVELOPMENT("Web Development");

    private String value;

    private AreaOfInterest(String areaOfInterst) {
        this.value=areaOfInterst;
    }

    public static String enumToString(AreaOfInterest areaOfInterest){
        return areaOfInterest.value;
    }

    public static AreaOfInterest stringToEnum(String s){
        for(AreaOfInterest x:AreaOfInterest.values())
            if(x.value.equalsIgnoreCase(s)) return x;
             return null;

    }
}
