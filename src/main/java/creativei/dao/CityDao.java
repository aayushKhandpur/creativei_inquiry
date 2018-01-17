package creativei.dao;

import creativei.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CityDao extends JpaRepository<City, Long > {
}
