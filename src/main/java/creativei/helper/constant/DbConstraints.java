package creativei.helper.constant;

/**
 * Created by Aayush on 12/24/2017.
 */
public class DbConstraints {
    /*constraints*/
    public static final String BRANCH_NAME_UNIQUE = "BRANCH_NAME_UNIQUE";
    public static final String BRANCH_MOBILE_UNIQUE = "BRANCH_MOBILE_UNIQUE";
    public static final String INQUIRY_EMAIL_UNIQUE="INQUIRY_EMAIL_UNIQUE";
    public static final String INQUIRY_PHONE_UNIQUE="INQUIRY_PHONE_UNIQUE";
    /* fields*/
    public static final String BRANCH_NAME = "name";
    public static final String BRANCH_MOBILE = "mobile";
    public static final String INQUIRY_EMAIL="email";
    public static final String INQUIRY_PHONE="phone_number";
    /*error messages*/
    public static final String BRANCH_NAME_UNIQUE_MSG = "Branch Name already exist.";
    public static final String BRANCH_MOBILE_UNIQUE_MSG = "Branch Mobile already exist.";
    public static final String INQUIRY_EMAIL_UNIQUE_MSG="Email already exist";
    public static final String INQUIRY_PHONE_UNIQUE_MSG="Phone Number already exist";
}
