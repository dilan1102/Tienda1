/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda1.Controller;

import com.Tienda1.Domain.Cliente;
import com.Tienda1.Service.ArticuloService;
import com.Tienda1.dao.ClienteDao;
import com.Tienda1.service.ClienteService;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Dilan Aguilar
 */
@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ArticuloService articuloService;
    @GetMapping("/")
    public String inicio(Model model){
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos",articulos);
        return "index";
    }
    
     
}
