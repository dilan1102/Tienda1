/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda1.Dao;

import com.Tienda1.Domain.Carrito;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dilan Aguilar
 */
public interface CarritoDao extends CrudRepository<Carrito, Long>  {
    Optional<Carrito> findByIdCliente(Long idCliente);
}
