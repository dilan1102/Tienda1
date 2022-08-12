package com.Tienda1.Domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_Articulo")
    private long idCategoria;
    private Long idArticulo;
    private String descripcion;
    private double precio;
    private double existencias;
    private boolean activo;
    
    public Articulo() {
    }

    public Articulo(Long idArticulo, String descripcion, double precio, double existencias, boolean activo) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
    
   

   

}
