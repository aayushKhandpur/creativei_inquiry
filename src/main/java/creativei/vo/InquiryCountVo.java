package creativei.vo;

public class InquiryCountVo {
    int dailyCount;
    int weekCount;
    int monthCount;
    int hotLeadCount;
    int enrolledCount;

    public int getHotLeadCount() {
        return hotLeadCount;
    }

    public void setHotLeadCount(int hotLeadCount) {
        this.hotLeadCount = hotLeadCount;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    public void setEnrolledCount(int enrolledCount) {
        this.enrolledCount = enrolledCount;
    }

    public int getDailyCount() {
        return dailyCount;
    }

    public void setDailyCount(int dailyCount) {
        this.dailyCount = dailyCount;
    }

    public int getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(int weekCount) {
        this.weekCount = weekCount;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }
}
