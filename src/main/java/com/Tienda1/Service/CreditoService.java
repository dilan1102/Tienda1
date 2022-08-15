
package com.Tienda1.Service;

import com.Tienda1.domain.Credito;
import java.util.List;

/**
 *
 * @author Dilan Aguilar
 */
public interface CreditoService {
    public List<Credito> getCredito();
    public void save(Credito credito);
    public void delete(Credito credito);
    public Credito getCredito(Credito credito);

}
