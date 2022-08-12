package com.Tienda1.Domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_Categoria")

    private Long idCategoria ;
private String descripcion;
private boolean activo;

    public Categoria() {
    }

    public Categoria(Long idCategoria, String descripcion, boolean activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Categoria(String descripcion,boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

   

}
