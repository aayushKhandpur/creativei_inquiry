package creativei.dao;

import creativei.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LocalityDao extends JpaRepository<Locality,Long>{
    @Query("select distinct p.pincode from Locality p where p.pincode like concat(:pin,'%') order by p.pincode ")
    List<String> findByPincodeStartsWith(@Param("pin")String pin);
    List<Locality> findByPincode(@Param("pin")String pin);
}
