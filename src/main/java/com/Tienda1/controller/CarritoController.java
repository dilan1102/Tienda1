
import com.Tienda1.Domain.Articulo;
import com.Tienda1.Domain.CarritoDetalle;
import com.Tienda1.Service.ArticuloService;
import com.Tienda1.Service.CarritoDetalleService;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@Controller
public class CarritoController {
    @Autowired    
    private CarritoDetalleService carritoDetalleService;
    @Autowired   
    private ArticuloService articuloService;
    @GetMapping("/carrito/agregar/{idArticulo}")
    public String agregar(Articulo articulo, HttpSession session) {
        Long idCarrito = (Long)session.getAttribute("idCarrito");
        articulo = articuloService.getArticulo(articulo);
        //Verificar si ya existe        
        CarritoDetalle carritoDetalle = carritoDetalleService.getCarritoDetalle(idCarrito, articulo);
        if(carritoDetalle != null) {
            carritoDetalle.setCantidad(carritoDetalle.getCantidad() + 1);
        } else {
            carritoDetalle = new CarritoDetalle(idCarrito, articulo.getPrecio(), 1, articulo);
        }
        carritoDetalleService.save(carritoDetalle);
        return "redirect:/";
    }
    @GetMapping("/carrito/listado")
    public String listado(Model model, Articulo articulo, HttpSession session) {
        Long idCarrito = (Long)session.getAttribute("idCarrito");
        List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(idCarrito);
        int cantidadArticulosCarrito = carritoDetalles.size();
        var montoTotal=0;
        var montoImpuestos = 0.0;
        for (var c: carritoDetalles) {
            montoTotal += c.getCantidad() * c.getPrecio();
        }
        montoImpuestos = montoTotal * 0.15;
        model.addAttribute("carritoDetalles", carritoDetalles);
        model.addAttribute("cantidadArticulosCarrito", cantidadArticulosCarrito);
        model.addAttribute("montoImpuestos", montoImpuestos);
        model.addAttribute("montoTotal", montoTotal);
        return "/carrito/listado";
    }
}
