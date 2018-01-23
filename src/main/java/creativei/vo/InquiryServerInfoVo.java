package creativei.vo;

import creativei.enums.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InquiryServerInfoVo {
    private List<String> gender,areaOfInterest,highestEducation,occupation,computerKnowledge,educationStatus,markScheme,marketingSource,relation,stream,educationType;

    public InquiryServerInfoVo(){
        this.gender = Gender.getEnumValue();
        this.areaOfInterest =AreaOfInterest.getEnumValue();
        this.computerKnowledge = ComputerKnowledge.getEnumValue();
        this.educationStatus = EducationStatus.getEnumValue();
        this.highestEducation = EducationQualification.getEnumValue();
        this.markScheme = MarkScheme.getEnumValue();
        this.marketingSource = MarketingSource.getEnumValue();
        this.occupation = Occupation.getEnumValue();
        this.relation = Relation.getEnumValue();
        this.stream=Stream.getEnumValue();
        this.educationType=EducationType.getEnumValue();
    }

    public List<String> getGender() {
        return gender;
    }

    public List<String> getAreaOfInterest() {
        return areaOfInterest;
    }

    public List<String> getHighestEducation() {
        return highestEducation;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public List<String> getComputerKnowledge() {
        return computerKnowledge;
    }

    public List<String> getEducationStatus() {
        return educationStatus;
    }

    public List<String> getMarkScheme() {
        return markScheme;
    }

    public List<String> getMarketingSource() {
        return marketingSource;
    }

    public List<String> getRelation() {
        return relation;
    }

    public List<String> getStream(){return stream;}

    public List<String> getEducationType(){return educationType;}
}
