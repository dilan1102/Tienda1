/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda1.Controller;

import com.Tienda1.Domain.Cliente;
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
    private ClienteDao clienteDao;
     @GetMapping("/")
     public String inicio (Model model){
         Cliente cliente = new Cliente("Dilan","Aguilar","dilanagui11@gmail.com","8820-2655");   
         var clientes = clienteService.getClientes();
         model.addAttribute("clientes", clientes);
         return "index";
         
     }
     @GetMapping("/nuevoCliente")
     public String nuevoCliente(Cliente cliente){
         return "modificarCliente";
     }
     @GetMapping("/guardarCliente")
     public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/nuevoCliente"
     }
}
