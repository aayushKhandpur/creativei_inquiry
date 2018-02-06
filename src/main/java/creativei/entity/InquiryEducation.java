package creativei.entity;

import creativei.enums.*;
import creativei.helper.ResponseHelper;
import creativei.vo.EducationVo;
import creativei.vo.ResponseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name="Inquiry_Education")
public class InquiryEducation extends BaseEntity implements Serializable {

    @ManyToOne
    private Inquiry inquiry;
    @Column(name="education_qualificaton",nullable = false)
    private EducationQualification educationQualification;
    @Column(name="institue_name")
    private String instituteName;
    private Stream stream;
    private EducationStatus status;
    private Integer year;
    @Column(name="aggregate_marks")
    private Double aggregateMarks;
    @Column(name="mark_scheme")
    private MarkScheme markScheme;
    private String type;

    public InquiryEducation(){}

    public InquiryEducation(EducationVo educationVo) {

            this.setId(educationVo.getId());
            this.educationQualification = EducationQualification.stringToEnum(educationVo.getEducationQualification());
            this.instituteName = educationVo.getInstituteName() == null || educationVo.getInstituteName().isEmpty() ? null : educationVo.getInstituteName();
            this.stream = Stream.stringToEnum(educationVo.getStream());
            this.status = EducationStatus.stringToEnum(educationVo.getStatus());
            this.year = educationVo.getYear() == null ? null : educationVo.getYear();
            this.aggregateMarks = educationVo.getAggregateMarks() == null ? null : educationVo.getAggregateMarks();
            this.markScheme = MarkScheme.stringToEnum(educationVo.getMarkScheme());
            this.type = educationVo.getType() == null || educationVo.getType().isEmpty() ? null : educationVo.getType();
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
}
