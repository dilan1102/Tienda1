package com.Tienda1.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credito")
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito")
    private Long idCredito ;
    public double limiteTotal;

    public Credito() {
    }

    public Credito(Long idCredito, Long limiteTotal) {
        this.idCredito = idCredito;
        this.limiteTotal = limiteTotal;
    }

    public Credito(long limiteTotal) {
        this.limiteTotal = limiteTotal;
    }

   

}
