package com.ideaas.services.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.ideaas.services.bean.GoogleMapsProperties;
import com.ideaas.services.service.interfaces.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by federicoberon on 04/12/2019.
 */
@Service
public class GoogleMapsServiceImpl implements GoogleMapsService {

    private GeoApiContext context;
    private String apiKey;

    @Autowired
    public GoogleMapsServiceImpl(GoogleMapsProperties googleMapsProperties) {
        apiKey = googleMapsProperties.getMapKey();
        this.context = new GeoApiContext.Builder().apiKey("AIzaSyANGywbfxItEbdle738SiU-AVJGIjadVYM").build();
    }

    @Override
    public GeocodingResult[] getByAddress(String address){
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context, address).await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

}
