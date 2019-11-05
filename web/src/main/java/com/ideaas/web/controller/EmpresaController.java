package com.ideaas.web.controller;

import com.ideaas.services.domain.AudEmpresa;
import com.ideaas.services.service.interfaces.AudEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("empresa")
public class EmpresaController {

    private AudEmpresaService empresaService;

    @Autowired
    public EmpresaController(AudEmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        AudEmpresa empresa = empresaService.get(id);

        model.addAttribute("empresa", empresa);

        return "empresa/show";
    }

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<AudEmpresa> empresas = empresaService.findAll(size, page,"id");

        model.addAttribute("empresas", empresas);
        model.addAttribute("page" , page);

        return "empresa/list";
    }


    @GetMapping("create")
    public String create() {
        return "empresa/create";
    }


    @PostMapping("addEmpresa")
    public String save(@ModelAttribute AudEmpresa empresa, RedirectAttributes redirectAttributes){
        empresaService.save(empresa);
        redirectAttributes.addAttribute("id", empresa.getId());

        return "redirect:/{id}";
    }

    @ModelAttribute("empresa")
    public AudEmpresa get(){
        return new AudEmpresa();
    }

}
