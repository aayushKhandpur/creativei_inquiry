package creativei.entity;

import creativei.enums.*;
import creativei.vo.EducationVo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Inquiry_Education")
public class InquiryEducation extends BaseEntity implements Serializable {

    @OneToOne
    private Inquiry inquiry;
    @Column(name="education_qualificaton",nullable = false)
    private EducationQualification educationQualification;
    @Column(name="institue_name")
    private String instituteName;
    private Stream stream;
    private Status status;
    private Integer year;
    @Column(name="aggregate_marks")
    private Double aggregateMarks;
    @Column(name="mark_scheme")
    private MarkScheme markScheme;
    private String type;

    public InquiryEducation(EducationVo educationVo) {
        this.educationQualification=EducationQualification.stringToEnum(educationVo.getEducationQualification());
        this.instituteName=educationVo.getInstituteName()==null?null:educationVo.getInstituteName();
        this.stream=Stream.stringToEnum(educationVo.getStream());
        this.status=educationVo.getStatus()==null?null:Status.stringToEnum(educationVo.getStatus());
        this.year=educationVo.getYear()==null?null:educationVo.getYear();
        this.aggregateMarks=educationVo.getAggregateMarks()==null?null:educationVo.getAggregateMarks();
        this.markScheme=educationVo.getMarkScheme()==null?null:MarkScheme.stringToEnum(educationVo.getMarkScheme());
        this.type=educationVo.getType()==null?null:educationVo.getType();
    }

    public String getType() {return type;}

    public void setType(String type) { this.type = type;}

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
}
