package creativei.vo;

import creativei.enums.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InquiryServerInfoVo {
    private List<String> gender;
    private List<String> areaOfInterest,highestEducation,occupation,computerKnowledge,educationStatus,markScheme,marketingSource,relation;



    public InquiryServerInfoVo(){
        setGender();
        setAreaOfInterest();
        setComputerKnowledge();
        setEducationStatus();
        setHighestEducation();
        setMarketingSource();
        setMarkScheme();
        setOccupation();
        setRelation();
    }

    public List<String> getGender() {
        return gender;
    }

    public void setGender() {
        this.gender = Gender.getEnumValue();
    }

    public List<String> getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest() {
        this.areaOfInterest =AreaOfInterest.getEnumValue();
    }

    public List<String> getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation() {
        this.highestEducation = EducationQualification.getEnumValue();
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation() {
        this.occupation = Occupation.getEnumValue();
    }

    public List<String> getComputerKnowledge() {
        return computerKnowledge;
    }

    public void setComputerKnowledge() {
        this.computerKnowledge = ComputerKnowledge.getEnumValue();
    }

    public List<String> getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus() {
        this.educationStatus = EducationStatus.getEnumValue();
    }

    public List<String> getMarkScheme() {
        return markScheme;
    }

    public void setMarkScheme() {
        this.markScheme = MarkScheme.getEnumValue();
    }

    public List<String> getMarketingSource() {
        return marketingSource;
    }

    public void setMarketingSource() {
        this.marketingSource = MarketingSource.getEnumValue();
    }

    public List<String> getRelation() {
        return relation;
    }

    public void setRelation() {
        this.relation = Relation.getEnumValue();
    }
}
