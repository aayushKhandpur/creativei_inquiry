package creativei.dao;

import creativei.entity.AppUser;

import java.util.List;

/**
 * Created by DELL on 4/4/2018.
 */
public interface AppUserCustomDao {

    AppUser save(AppUser inquiry);

    List<AppUser> findAll();

    AppUser findOne(Long aLong);

}
