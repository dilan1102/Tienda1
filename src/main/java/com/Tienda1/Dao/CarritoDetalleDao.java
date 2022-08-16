/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda1.Dao;

import com.Tienda1.Domain.Articulo;
import com.Tienda1.Domain.CarritoDetalle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dilan Aguilar
 */
public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long> {
    public Optional<CarritoDetalle> findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);
    public List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    public void deleteByIdCarrito(Long idCarrito);
}
