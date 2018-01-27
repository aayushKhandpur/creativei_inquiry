package creativei.enums;

public enum FollowUpSubStatus {
    MORE_COUNSELLING("Need More Cunselling"),
    ENROLLMENT_IN_THIRTY_DAYS("Possible Enrollment In A Month"),
    NOT_DECIDED("Not Decided Yet ,Will Decide Later"),
    NOT_REACHABLE("Not Reachable"),
    MAY_JOIN_LATER("Interested to join later"),
    NOT_ELIGIBLE("Not Eligible"),
    BATCH_TIMING("Batch Timing Not Suitable"),
    FINANCIAL_INADEQUATE("Financial Issue"),
    COURSE_NOT_OFFERED("Course Not Offered"),
    OUTSTATION("Outstation Candidate"),
    DEGREE_COURSE("No Degree Course"),
    DEMO_CLASS("Demo Class Not Good Enough"),
    COMPETITOR_FEE_STRUCTURE("COmpetitor Offered Better Fee Structure"),
    COMPETITOR_INFRA("Competitor better Infrastructure"),
    INFRA("Inadequate Infrastructure"),
    ENROLLED("Enrolled");

    private String value;

    private FollowUpSubStatus(String value){this.value=value;}

    public String getValue() {
        return value;
    }
}
