package creativei.service.impl;

import creativei.dao.LocalityDao;
import creativei.entity.Locality;
import creativei.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LocalityService")
public class LocalityServiceImpl implements LocalityService {
    @Autowired
    LocalityDao localityDao;


    @Override
    public List<String> getListOfPincode(String pincode) {
        return localityDao.findByPincodeStartsWith(pincode);
    }

    @Override
    public List<Locality> getLocality(String pincode) {
        return localityDao.findByPincode(pincode);
    }
}
