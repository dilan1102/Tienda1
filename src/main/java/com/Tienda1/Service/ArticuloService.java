
package com.Tienda1.Service;


import com.Tienda1.Domain.Articulo;
import java.util.List;

public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos);
    public void save(Articulo articulo);
    public void delete(Articulo articulo);
    public Articulo getArticulo(Articulo articulo);
}
