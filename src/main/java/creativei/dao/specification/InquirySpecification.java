package creativei.dao.specification;

import creativei.entity.FollowUp;
import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.enums.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;
import javax.persistence.criteria.*;

public class InquirySpecification implements Specification<Inquiry> {

    private InquiryStatus inquiryStatus;
    private CaseIndex caseIndex;
    private Long cityId;

    public InquirySpecification(InquiryStatus status, CaseIndex caseIndex, Long cityId) {
        this.inquiryStatus = status;
        this.caseIndex = caseIndex;
        this.cityId = cityId;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicateInquiryStatus, predicateCaseIndex, predicateCityId;

        if (inquiryStatus == null)
            predicateInquiryStatus = criteriaBuilder.isNotNull(root.get("inquiryStatus"));
        else
            predicateInquiryStatus = criteriaBuilder.equal(root.get("inquiryStatus"), inquiryStatus);

        if (cityId == null)
            predicateCityId = criteriaBuilder.isNotNull(root.join("inquiryAddress").join("location").join("city").get("id"));
        else
            predicateCityId = criteriaBuilder.equal(root.join("inquiryAddress").join("location").join("city").get("id"), cityId);

        if (caseIndex == null)
            predicateCaseIndex = criteriaBuilder.isNotNull(root.join("followUps").get("caseIndex"));
        else
            predicateCaseIndex = criteriaBuilder.equal(root.join("followUps").get("caseIndex"), caseIndex);
        criteriaQuery.distinct(true);
        return criteriaBuilder.and(predicateInquiryStatus, predicateCityId, predicateCaseIndex);
    }
}