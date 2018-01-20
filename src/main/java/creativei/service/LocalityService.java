package creativei.service;

import creativei.entity.Locality;

import java.util.List;

/**
 * Created by user on 1/18/2018.
 */
public interface LocalityService {
    List<String> getListOfPincode(String pincode);
    List<Locality> getLocality(String pincode);
}
