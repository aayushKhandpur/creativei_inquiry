package creativei.dao.specification;

import creativei.entity.Reminder;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class ReminderSpecification {


    public static Specification<Reminder> reminderBetweenDateRange(Date fromDate,Date toDate) {
        return new Specification<Reminder>() {
            @Override
            public Predicate toPredicate(Root<Reminder> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (fromDate == null) {
                    Predicate startDate = criteriaBuilder.lessThanOrEqualTo(root.get("reminderTime"), toDate);
                    return startDate;
                } else if (toDate == null) {
                    Predicate endDate = criteriaBuilder.greaterThanOrEqualTo(root.get("reminderTime"), fromDate);
                    return endDate;
                } else {
                    Predicate betweenDate = criteriaBuilder.between(root.get("reminderTime"),fromDate,toDate);
                    return betweenDate;
                }
            }
        };
    }
}