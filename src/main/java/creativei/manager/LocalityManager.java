package creativei.manager;

import creativei.vo.ResponseObject;

public interface LocalityManager {
    ResponseObject getPincodes(String pincode);
    ResponseObject getLocalityDataByPincode(String pincode);
}
