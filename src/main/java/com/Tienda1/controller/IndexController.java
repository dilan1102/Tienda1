/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class IndexController {
    @GetMapping("/")
    public String inicio(){
        log.info("Ahora se usa arquitectura MVC");
        return "index";
    }
}
