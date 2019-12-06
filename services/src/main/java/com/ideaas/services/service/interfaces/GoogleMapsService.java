package com.ideaas.services.service.interfaces;

import com.google.maps.model.GeocodingResult;

/**
 * Created by federicoberon on 04/12/2019.
 */
public interface GoogleMapsService {
    GeocodingResult[] getByAddress(String address);
}
