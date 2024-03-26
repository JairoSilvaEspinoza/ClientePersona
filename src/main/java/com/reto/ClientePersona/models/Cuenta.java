package com.reto.ClientePersona.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 2383275470189579954L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldo;
    private Boolean estado;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "personaId")
    private Persona persona;
    @JsonIgnore
    @OneToMany(mappedBy = "cuenta")
    private List<Movimiento> movimientos;
}
