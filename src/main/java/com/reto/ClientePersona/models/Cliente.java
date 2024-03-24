package com.reto.ClientePersona.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente  implements Serializable {


    private static final long serialVersionUID = -1524517454421043716L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contrasena;
    private boolean estado;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "personaId", unique = true)
    private Persona persona;
}
