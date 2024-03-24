package com.reto.ClientePersona.models.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaDto implements Serializable {

    private static final long serialVersionUID = 4507141783538097650L;
    private Long id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
