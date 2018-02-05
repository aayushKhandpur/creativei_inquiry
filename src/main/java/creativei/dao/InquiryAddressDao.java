package creativei.dao;
import creativei.entity.InquiryAddress;
import creativei.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface InquiryAddressDao extends JpaRepository<InquiryAddress,Long> {
    @Query("select loc from InquiryAddress add join add.location loc where loc.id=:id")
    Locality getLocationData(@Param("id")Long id);
}
