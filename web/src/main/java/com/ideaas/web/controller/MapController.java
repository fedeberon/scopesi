package com.ideaas.web.controller;

import com.ideaas.services.bean.Wrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by federicoberon on 08/10/2019.
 */
@Controller
@RequestMapping("maps")
public class MapController {

    @RequestMapping("show")
    public String maps(){
        return "maps";
    }


    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String findAll(@ModelAttribute("myWrapper") Wrapper wrapper, Model model){
        model.addAttribute("registros", wrapper.getSelectedElements());
        model.addAttribute("ubicacionRequest", wrapper.getRequest());

        return "ubicacion/map";
    }

    @ModelAttribute("myWrapper")
    public Wrapper wrapper(){
        return new Wrapper();
    }
}
