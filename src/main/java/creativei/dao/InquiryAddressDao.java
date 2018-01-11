package creativei.dao;
import creativei.entity.InquiryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface InquiryAddressDao extends JpaRepository<InquiryAddress,Long> {
}
