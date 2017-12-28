package creativei.dao;

import creativei.entity.InquiryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by user on 12/17/2017.
 */
@Transactional
public interface InquiryAddressDao extends JpaRepository<InquiryAddress,Long> {

}
