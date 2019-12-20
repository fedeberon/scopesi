package com.ideaas.services.bean;

import com.ideaas.services.request.MapUbicacionRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by federicoberon on 29/10/2019.
 */
 @Component
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

    private Integer page = 0;


    public List<MyObject> getList() {
        return list;
    }

    public void setList(List<MyObject> list) {
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
