package com.reto.ClientePersona.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class
Persona implements Serializable {

    private static final long serialVersionUID = -5067143713270345344L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String genero;
    private int edad;
    @Column(unique = true)
    private String identificacion;
    private String direccion;
    private String telefono;
    @JsonIgnore
    @OneToOne(mappedBy = "persona")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Cuenta> cuentas;
}
