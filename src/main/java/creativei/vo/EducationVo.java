package creativei.vo;

import creativei.entity.InquiryEducation;
import creativei.enums.EducationQualification;
import creativei.enums.EducationStatus;
import creativei.enums.MarkScheme;
import creativei.enums.Stream;

/**
 * Created by user on 1/3/2018.
 */
public class EducationVo {
    private Long id;
    private String educationQualification;
    private String instituteName;
    private String stream;
    private String status;
    private Integer year;
    private String type;
    private Double aggregateMarks;
    private String markScheme;

    public EducationVo(){}

    public EducationVo(InquiryEducation inquiryEducation){
        this.setId(inquiryEducation.getId());
        this.educationQualification= EducationQualification.enumToString(inquiryEducation.getEducationQualification());
        this.instituteName=inquiryEducation.getInstituteName();
        this.stream= Stream.enumToString(inquiryEducation.getStream());
        this.status= EducationStatus.enumToString(inquiryEducation.getStatus());
        this.year=inquiryEducation.getYear();
        this.type=inquiryEducation.getType();
        this.aggregateMarks=inquiryEducation.getAggregateMarks();
        this.markScheme= MarkScheme.enumToString(inquiryEducation.getMarkScheme());
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducationQualification() {
        return educationQualification;
    }

    public void setEducationQualification(String educationQualification) {this.educationQualification = educationQualification;}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAggregateMarks() {
        return aggregateMarks;
    }

    public void setAggregateMarks(Double aggregateMarks) { this.aggregateMarks = aggregateMarks;}

    public String getMarkScheme() {
        return markScheme;
    }

    public void setMarkScheme(String markScheme) {
        this.markScheme = markScheme;
    }
}
