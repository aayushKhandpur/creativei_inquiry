package creativei.manager.impl;

import creativei.entity.City;
import creativei.entity.Locality;
import creativei.entity.State;
import creativei.manager.LocalityManager;
import creativei.service.LocalityService;
import creativei.vo.AddressVo;
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

        List<Locality> localities = localityService.getLocalities(pincode);
        if (localities.size() == 0)
            return ResponseObject.getResponse(null);
        List<LocalityVo> loc = new ArrayList<>();
        Iterator iterator = localities.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            loc.add(new LocalityVo(localities.get(i).getId(), localities.get(i).getName()));
            iterator.next();
            i++;
        }
        City city = localities.get(0).getCity();
        CityVo cityVo = new CityVo(city.getId(),city.getName(),city.getState().getCountry(),city.getState().getName(),loc);
        return ResponseObject.getResponse(cityVo);
    }

}
