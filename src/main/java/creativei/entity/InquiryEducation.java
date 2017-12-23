package creativei.entity;

import creativei.enums.EducationQualification;
import creativei.enums.Status;
import creativei.enums.Stream;

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
    private Stream stream;
    private Status status;
    private int year;
    @Column(name="aggregate_marks")
    private int aggregateMarks;
    @Column(name="mark_scheme")
    private int markScheme;

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

    public int getMarkScheme() {
        return markScheme;
    }

    public void setMarkScheme(int markScheme) {
        this.markScheme = markScheme;
    }
}
