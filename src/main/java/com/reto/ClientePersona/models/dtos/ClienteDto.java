package com.reto.ClientePersona.models.dtos;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDto implements Serializable {

    private static final long serialVersionUID = -8753236640427408612L;
    private Long id;
    private String contrasena;
    private boolean estado;
    private Long personaId;
}
