/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda1.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 *
 * @author Dilan Aguilar
 */
@Data
@Entity
@Table (name = "cliente")

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idCliente ;
    String nombre;
    String apellidos;
    String correo;
    String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
}
