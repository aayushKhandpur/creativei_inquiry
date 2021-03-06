package creativei.dao;

import creativei.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AppUserDao extends JpaRepository<AppUser, Long> {
}
