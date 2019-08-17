package mj.apps.demo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class RestClient {
    
    private Context context;
    
    RestClient(Context context) {
        this.context = context;
    }
    
    public List<String> searchForCity(String searchString) {
        return getMatchingCities(searchString);
    }
    
    private List<String> getMatchingCities(String searchString) {
        List<String> matchingCities = new ArrayList<>();
        if (searchString.isEmpty()) {
            return matchingCities;
        }
        
        String[] cities = context.getResources().getStringArray(R.array.city_list);
        for (String city : cities) {
            if (city.toLowerCase().startsWith(searchString.toLowerCase())) {
                matchingCities.add(city);
            }
        }
        return matchingCities;
    }
}
