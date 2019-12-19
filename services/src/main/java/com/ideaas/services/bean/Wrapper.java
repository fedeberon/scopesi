package com.ideaas.services.bean;

import com.ideaas.services.request.MapUbicacionRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by federicoberon on 29/10/2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wrapper {

    private List<MyObject> list = new ArrayList<>();

    private MapUbicacionRequest request = new MapUbicacionRequest();

    public List<MyObject> getSelectedElements() {
        return list.stream().filter(line -> line.getChecked()).collect(Collectors.toList());
    }

    public MapUbicacionRequest getRequest() {
        return request;
    }

    public void setRequest(MapUbicacionRequest request) {
        this.request = request;
    }

}
