package creativei.entity;

import creativei.enums.*;
import creativei.vo.EducationVo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by user on 12/19/2017.
 */
@Entity
@Table(name="Inquiry_Education")
public class InquiryEducation extends BaseEntity implements Serializable {

    @OneToOne
    private Inquiry inquiry;
    @Column(name="education_qualificaton",nullable = false)
    private EducationQualification educationQualification;
    @Column(name="institue_name")
    private String instituteName;
    private String stream;
    private Status status;
    private int year;
    @Column(name="aggregate_marks")
    private int aggregateMarks;
    @Column(name="mark_scheme")
    private MarkScheme markScheme;
    private String type;

    public InquiryEducation(EducationVo educationVo) {
        this.educationQualification=EducationQualification.stringToEnum(educationVo.getEducationQualification());
        this.instituteName=educationVo.getInstituteName();
        this.stream=educationVo.getStream();
        this.status=Status.stringToEnum(educationVo.getStatus());
        this.year=educationVo.getYear();
        this.aggregateMarks=educationVo.getAggregateMarks();
        this.markScheme=MarkScheme.stringToEnum(educationVo.getMarkScheme());
        this.type=educationVo.getType();
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAggregateMarks() {
        return aggregateMarks;
    }

    public void setAggregateMarks(int aggregateMarks) {
        this.aggregateMarks = aggregateMarks;
    }

    public MarkScheme getMarkScheme() {
        return markScheme;
    }

    public void setMarkScheme(MarkScheme markScheme) {
        this.markScheme = markScheme;
    }
}
