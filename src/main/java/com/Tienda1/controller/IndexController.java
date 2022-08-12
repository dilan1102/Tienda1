/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda1.Controller;

import com.Tienda1.Domain.Cliente;
import com.Tienda1.dao.ClienteDao;
import java.util.Arrays;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
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
         /*model.addAttribute("cliente", cliente);
         
         Cliente cliente2 = new Cliente("Dilan","Aguilar","dilanagui11@gmail.com","8820-2655");*/
         Iterable<Cliente> clientes = clienteDao.findAll();
         model.addAttribute("clientes", clientes);
         return "index";
         
     }
}
