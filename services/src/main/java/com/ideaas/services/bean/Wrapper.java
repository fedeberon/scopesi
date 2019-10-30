package com.ideaas.services.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by federicoberon on 29/10/2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wrapper {

    private List<MyObject> list = new ArrayList<>();

}
