
package com.Tienda1.Service;


import com.Tienda1.Dao.CreditoDao;

import com.Tienda1.domain.Credito;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditoServiceImpl implements CreditoService {
@Autowired
public CreditoDao creditoDao;


    @Override
    public void save(Credito credito) {
        creditoDao.save(credito);
    }

    @Override
    public void delete(Credito credito) {
                creditoDao.delete(credito);

    }

    @Override
    public Credito getCredito(Credito credito) {
                return creditoDao.findById(credito.getIdCredito()).orElse(null);

    }

    @Override
    public List<Credito> getCredito() {
        var lista= (List<Credito>)creditoDao.findAll();
        return lista;
    }
    
}
