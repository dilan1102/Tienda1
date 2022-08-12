package com.Tienda1.dao;
import com.Tienda1.Domain.Cliente;

import org.springframework.data.repository.CrudRepository;
public interface ClienteDao extends CrudRepository<Cliente,Long>{
   
}
