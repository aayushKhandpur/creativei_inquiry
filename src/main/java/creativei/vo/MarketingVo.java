package creativei.vo;

public class MarketingVo {

    private Long id;
    private String source;
    private Boolean isReferred;
    private String referant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getReferred() {
        return isReferred;
    }

    public void setReferred(Boolean referred) {
        isReferred = referred;
    }

    public String getReferant() {
        return referant;
    }

    public void setReferant(String referant) {
        this.referant = referant;
    }
}
