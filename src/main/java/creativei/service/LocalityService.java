package creativei.service;

import creativei.entity.Locality;

import java.util.List;

public interface LocalityService {
    List<String> getPincodes(String pincode);
    List<Locality> getLocalities(String pincode);
}
