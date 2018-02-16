package creativei.entity;

import creativei.enums.*;
import creativei.vo.EducationVo;
import util.StringUtil;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Inquiry_Education")
public class InquiryEducation extends BaseEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;
    @Column(name = "education_qualificaton", nullable = false)
    private EducationQualification educationQualification;
    @Column(name = "institue_name")
    private String instituteName;
    private Stream stream;
    private EducationStatus status;
    private Integer year;
    @Column(name = "aggregate_marks")
    private Double aggregateMarks;
    @Column(name = "mark_scheme")
    private MarkScheme markScheme;
    private String type;

    public InquiryEducation() {
    }

    public InquiryEducation(EducationVo educationVo, Inquiry inquiry) {
        this.setId(educationVo.getId());
        this.inquiry = inquiry;
        this.educationQualification = EducationQualification.stringToEnum(educationVo.getEducationQualification());
        this.instituteName = StringUtil.validateEmpty(educationVo.getInstituteName());
        this.stream = Stream.stringToEnum(educationVo.getStream());
        this.status = EducationStatus.stringToEnum(educationVo.getStatus());
        this.year =educationVo.getYear();
        this.aggregateMarks =educationVo.getAggregateMarks();
        this.markScheme = MarkScheme.stringToEnum(educationVo.getMarkScheme());
        this.type = StringUtil.validateEmpty(educationVo.getType());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EducationQualification getEducationQualification() {
        return educationQualification;
    }

    public void setEducationQualification(EducationQualification educationQualification) {
        this.educationQualification = educationQualification;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public EducationStatus getStatus() {
        return status;
    }

    public void setStatus(EducationStatus status) {
        this.status = status;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getAggregateMarks() {
        return aggregateMarks;
    }

    public void setAggregateMarks(Double aggregateMarks) {
        this.aggregateMarks = aggregateMarks;
    }

    public MarkScheme getMarkScheme() {
        return markScheme;
    }

    public void setMarkScheme(MarkScheme markScheme) {
        this.markScheme = markScheme;
    }

    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }
}
