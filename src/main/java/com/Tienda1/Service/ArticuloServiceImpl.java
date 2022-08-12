
package com.Tienda1.Service;


import com.Tienda1.Dao.ArticuloDao;
import com.Tienda1.Domain.Articulo;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {
@Autowired
public ArticuloDao articuloDao;

    @Override
    public List<Articulo> getArticulos(boolean activos) {
        var lista= (List<Articulo>)articuloDao.findAll();
        return lista;
    }

    @Override
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
                articuloDao.delete(articulo);

    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
                return articuloDao.findById(articulo.getIdArticulo()).orElse(null);

    }
    
}
