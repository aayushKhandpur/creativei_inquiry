package creativei.dao.impl;

import creativei.dao.InquiryCustomDao;
import creativei.dao.InquiryDao;
import creativei.dao.specifications.InquirySpecification;
import creativei.dao.util.HibernateUtil;
import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class InquiryCustomDaoImpl implements InquiryCustomDao {

    @Autowired
    InquiryDao inquiryDao;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Inquiry> findByInquiryStatus(InquiryStatus status) {
        return inquiryDao.findByInquiryStatus(status);
    }

    @Override
    public List<Inquiry> getFilteredInquiries(InquiryStatus status) {
        InquirySpecification spec = new InquirySpecification(status);
        return inquiryDao.findAll(spec);
    }
}
