package creativei.dao.impl;

import creativei.dao.InquiryCustomDao;
import creativei.dao.InquiryDao;
import creativei.dao.specification.InquirySpecification;
import creativei.entity.City;
import creativei.entity.Inquiry;
import creativei.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class InquiryCustomDaoImpl implements InquiryCustomDao {

    @Autowired
    InquiryDao inquiryDao;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Inquiry> findByInquiryStatus(InquiryStatus status) {
        return inquiryDao.findByInquiryStatus(status);
    }

    @Override
    public List<Inquiry> getFilteredInquiries(InquiryStatus status, CaseIndex caseIndex, Long cityId) {
        InquirySpecification inquirySpecification = new InquirySpecification(status, caseIndex, cityId);
        return inquiryDao.findAll(inquirySpecification);

    }

    @Override
    public Inquiry save(Inquiry inquiry) {
        return inquiryDao.save(inquiry);
    }


    @Override
    public Inquiry findOne(Long aLong) {
        return inquiryDao.findOne(aLong);
    }


    @Override
    public List<Inquiry> findAll() {
        return inquiryDao.findAll();
    }


}
