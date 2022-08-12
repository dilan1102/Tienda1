/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda1.Service;


import com.Tienda1.Domain.Categoria;
import java.util.List;

/**
 *
 * @author karen
 */
public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos);
    public void save(Categoria categoria);
    public void delete(Categoria categoria);
    public Categoria getCategoria(Categoria categoria);
}
