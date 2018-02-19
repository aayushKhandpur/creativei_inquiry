package creativei.dao.impl;

import creativei.dao.InquiryCustomDao;
import creativei.dao.util.HibernateUtil;
import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class InquiryCustomDaoImpl implements InquiryCustomDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Inquiry> getFilteredInquiries() {
        Session session = HibernateUtil.getHibernateSession();
        Criteria cr = session.createCriteria(Inquiry.class, "inquiry");
        cr.setFetchMode("InquiryAddress", FetchMode.JOIN);
        cr.createAlias("Inquiry_Address", "address");
        cr.createAlias("Follow_Up", "followUp");
        cr.add(Restrictions.eq("inquiry.status", InquiryStatus.OPEN));

        //TODO incomplete method
        
        return null;
    }
}
