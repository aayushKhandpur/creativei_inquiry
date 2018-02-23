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
@Transactional(readOnly=true)
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
        InquirySpecification inquirySpecification=new InquirySpecification(status,caseIndex,cityId);
            return inquiryDao.findAll(inquirySpecification);

    }

    @Override
    public <S extends Inquiry> S save(S s) {
        return inquiryDao.save(s);
    }

    @Override
    public Inquiry findOne(Long aLong) {
        return inquiryDao.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return inquiryDao.exists(aLong);
    }

    @Override
    public List<Inquiry> findAll() {
        return inquiryDao.findAll();
    }

    @Override
    public List<Inquiry> findAll(Sort sort) {
        return  inquiryDao.findAll(sort);
    }

    @Override
    public Page<Inquiry> findAll(Pageable pageable) {
        return inquiryDao.findAll(pageable);
    }

    @Override
    public List<Inquiry> findAll(Iterable<Long> iterable) {
        return inquiryDao.findAll(iterable);
    }

    @Override
    public long count() {
        return inquiryDao.count();
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Inquiry inquiry) {

    }

    @Override
    public void delete(Iterable<? extends Inquiry> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<Inquiry> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Inquiry getOne(Long aLong) {
        return inquiryDao.getOne(aLong);
    }

    @Override
    public <S extends Inquiry> List<S> findAll(Example<S> example, Sort sort) {
        return inquiryDao.findAll(example,sort);
    }

    @Override
    public <S extends Inquiry> List<S> findAll(Example<S> example) {
        return inquiryDao.findAll(example);
    }

    @Override
    public <S extends Inquiry> S saveAndFlush(S s) {
        return inquiryDao.saveAndFlush(s);
    }

    @Override
    public <S extends Inquiry> List<S> save(Iterable<S> iterable) {
        return inquiryDao.save(iterable);
    }

    @Override
    public <S extends Inquiry> S findOne(Example<S> example) {
        return inquiryDao.findOne(example);
    }

    @Override
    public <S extends Inquiry> Page<S> findAll(Example<S> example, Pageable pageable) {
        return inquiryDao.findAll(example, pageable);
    }

    @Override
    public <S extends Inquiry> long count(Example<S> example) {
        return inquiryDao.count(example);
    }

    @Override
    public <S extends Inquiry> boolean exists(Example<S> example) {
        return inquiryDao.exists(example);
    }
}
