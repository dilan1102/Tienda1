/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda1.Service;

import com.Tienda1.Domain.Articulo;
import com.Tienda1.Domain.CarritoDetalle;
import java.util.List;

/**
 *
 * @author Dilan Aguilar
 */
public interface CarritoDetalleService {
    CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo);
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);
    public void save(CarritoDetalle carritoDetalle);
    public void delete(CarritoDetalle carritoDetalle);
    public void deleteAll(Long idCarrito);
}
