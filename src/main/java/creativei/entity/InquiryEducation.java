package creativei.entity;

import creativei.enums.*;
import creativei.vo.EducationVo;

import javax.persistence.*;
import java.io.Serializable;
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

    public InquiryEducation(List<EducationVo> educationVo) {
        Iterator iterator = educationVo.iterator();
        Integer i=0;
        while (iterator.hasNext()) {
            this.setId(educationVo.get(i).getId());
            this.educationQualification = EducationQualification.stringToEnum(educationVo.get(i).getEducationQualification());
            this.instituteName = educationVo.get(i).getInstituteName() == null || educationVo.get(i).getInstituteName().isEmpty() ? null : educationVo.get(i).getInstituteName();
            this.stream = Stream.stringToEnum(educationVo.get(i).getStream());
            this.status = EducationStatus.stringToEnum(educationVo.get(i).getStatus());
            this.year = educationVo.get(i).getYear() == null ? null : educationVo.get(i).getYear();
            this.aggregateMarks = educationVo.get(i).getAggregateMarks() == null ? null : educationVo.get(i).getAggregateMarks();
            this.markScheme = MarkScheme.stringToEnum(educationVo.get(i).getMarkScheme());
            this.type = educationVo.get(i).getType() == null || educationVo.get(i).getType().isEmpty() ? null : educationVo.get(i).getType();
            iterator.next();
            i++;
        }
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
