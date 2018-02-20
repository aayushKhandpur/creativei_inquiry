package creativei.dao.specifications;

import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Aayush on 2/21/2018.
 */
public class InquirySpecification implements Specification<Inquiry> {
    private InquiryStatus status;

    public InquirySpecification(InquiryStatus status) {
        this.status = status;
    }

    @Override
    public Predicate toPredicate(Root<Inquiry> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.<String>get("inquiryStatus"), this.status);
    }
}
