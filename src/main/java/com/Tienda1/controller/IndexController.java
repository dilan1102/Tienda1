/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda1.Controller;

import com.Tienda1.Dao.UsuarioDao;
import com.Tienda1.Domain.Carrito;
import com.Tienda1.Domain.CarritoDetalle;
import com.Tienda1.Domain.Cliente;
import com.Tienda1.Domain.Usuario;
import com.Tienda1.Service.ArticuloService;
import com.Tienda1.Service.CarritoDetalleService;
import com.Tienda1.Service.CarritoService;
import com.Tienda1.dao.ClienteDao;
import com.Tienda1.service.ClienteService;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired    
    private CarritoService carritoService;
    @Autowired    
    private CarritoDetalleService carritoDetalleService;
    @Autowired    
    private UsuarioDao usuarioDao;
    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {        
        //Obtener el usuario llegado        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }
        //Validar si es usuario de un cliente        
        boolean esCliente = false;
        if (user.getAuthorities().size() == 1) {
            for (var rol : user.getAuthorities()) {
                if (rol.getAuthority().equals("ROLE_USER")) {
                    esCliente = true;
                }
            }
        }
        if (esCliente) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());
            request.getSession().setAttribute("idCliente", usuario.getIdCliente());
            request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
            //Consultar los items            
            List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
            int cantidadArticulosCarrito = carritoDetalles.size();
            model.addAttribute("cantidadArticulosCarrito", cantidadArticulosCarrito);
        }
        log.info("Ahora se usa arquitectura MVC");
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        model.addAttribute("esCliente", esCliente);
        return "index";
    }
}