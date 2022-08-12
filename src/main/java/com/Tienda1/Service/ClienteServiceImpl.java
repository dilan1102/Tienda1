/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda1.service;

import com.Tienda1.Domain.Cliente;
import com.Tienda1.dao.ClienteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dilan Aguilar
 */
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    public ClienteDao clienteDao;
    @Autowired

    
    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }
    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }
    
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);

    }
}
