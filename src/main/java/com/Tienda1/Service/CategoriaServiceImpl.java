package com.Tienda1.Service;


import com.Tienda1.Dao.CategoriaDao;
import com.Tienda1.Domain.Categoria;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    public CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);

    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);

    }

}
