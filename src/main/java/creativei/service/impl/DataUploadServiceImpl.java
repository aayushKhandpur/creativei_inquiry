package creativei.service.impl;

import com.opencsv.CSVReader;
import creativei.dao.CityDao;
import creativei.dao.LocalityDao;
import creativei.dao.StateDao;
import creativei.entity.City;
import creativei.entity.Locality;
import creativei.entity.State;
import creativei.service.DataUploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("DataUploadService")
public class DataUploadServiceImpl implements DataUploadService{
    @Autowired
    StateDao stateDao;
    @Autowired
    CityDao cityDao;
    @Autowired
    LocalityDao localityDao;

    @Override
    public boolean uploadLoaclityData(File localityCsv) throws IOException {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(localityCsv), ';');
            Map<String, City> cityMap = new HashMap<>();
            Map<String, State> stateMap = new HashMap<>();
            populateCityAndStateMap(cityMap, stateMap);
            String[] record = null;
            List<Locality> localityList = new ArrayList<>();
            String[] headerLine = reader.readNext();
            while ((record = reader.readNext()) != null) {
                System.out.println(record);
                //hardcoding as we have 5 columns in the csv
                String localityName = getStringFieldValue(record[0]);
                String pincode = getStringFieldValue(record[1]);
                String city = getStringFieldValue(record[2]);
                String state = getStringFieldValue(record[3]);
                String country = getStringFieldValue(record[4]);
                //Early fail in case of null values
                if(localityName == null || pincode == null || city == null || state == null || country == null) return false;
                localityList.add(getLocality(localityName, pincode, city, state, country, cityMap, stateMap));
                if(localityList.size() == 50){
                    localityDao.save(localityList);
                    localityList.clear();
                }
            }
           if(localityList.size() > 0) localityDao.save(localityList);
            return true;
        }finally {
            if(reader != null){
                reader.close();;
            }
        }

    }
    private void populateCityAndStateMap(Map<String, City> cityMap, Map<String, State> stateMap){
        for(City city : cityDao.findAll()){
            cityMap.put(city.getName(), city);
        }
        for(State state : stateDao.findAll()){
            stateMap.put(state.getName(), state);
        }
    }

    private Locality getLocality(String localityName, String pincode, String city, String state, String country, Map<String, City> cityMap, Map<String, State> stateMap){
        Locality locality = new Locality();
        City cityObj = null;
        State stateObj = null;
        if (stateMap.containsKey(state)){
            stateObj = stateMap.get(state);
        }else {
            stateObj = new State();
            stateObj.setCountry(country);
            stateObj.setName(state);
            stateObj = stateDao.save(stateObj);
            stateMap.put(state, stateObj);
        }
        if(cityMap.containsKey(city)){
            cityObj = cityMap.get(city);
        }else {
            cityObj = new City();
            cityObj.setName(city);
            cityObj.setState(stateObj);
            cityObj = cityDao.save(cityObj);
            cityMap.put(city, cityObj);
        }
        locality.setCity(cityObj);
        locality.setName(localityName);
        locality.setPincode(pincode);
        return locality;
    }

    private String getStringFieldValue(String val){
        return StringUtils.isNotBlank(val) ? val.trim().toLowerCase() : null;
    }
}
