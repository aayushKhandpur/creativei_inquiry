package creativei.dao.impl;

import creativei.dao.AppUserCustomDao;
import creativei.dao.AppUserDao;
import creativei.entity.AppUser;

import java.util.List;

public class AppUserCustomDaoImpl implements AppUserCustomDao {
    AppUserDao appUserDao;


    @Override
    public AppUser save(AppUser appUser) {
        return appUserDao.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserDao.findAll();
    }

    @Override
    public AppUser findOne(Long id) {
        return appUserDao.findOne(id);
    }
}
