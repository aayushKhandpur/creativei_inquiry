package creativei.manager.impl;

import creativei.entity.City;
import creativei.entity.Locality;
import creativei.entity.State;
import creativei.manager.LocalityManager;
import creativei.service.LocalityService;
import creativei.vo.CityVo;
import creativei.vo.LocalityVo;
import creativei.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class LocalityMangerImpl implements LocalityManager {

    @Autowired
    LocalityService localityService;

    @Override
    public ResponseObject getPincodes(String pincode) {
        List<String> pin = localityService.getPincodes(pincode);
        return ResponseObject.getResponse(pin);
    }

    @Override
    public ResponseObject getLocalityDataByPincode(String pincode) {
        CityVo city=new CityVo();
        List<Locality> localities = localityService.getLocalities(pincode);
        if (localities.size() == 0)
            return ResponseObject.getResponse(null);
        City cityId = localities.get(0).getCity();
        city.setCity(cityId.getName());
        city.setId(cityId.getId());
        State stateId = cityId.getState();
        String state = stateId.getName();
        String country = stateId.getCountry();
        List<LocalityVo> loc = new ArrayList<>();
        Iterator iterator = localities.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            loc.add(new LocalityVo(localities.get(i).getId(), localities.get(i).getName()));
            iterator.next();
            i++;
        }
        city.setLocality(loc);
        city.setCountry(country);
        city.setState(state);
        return ResponseObject.getResponse(city);
    }
}
