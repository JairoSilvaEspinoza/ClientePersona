package com.reto.ClientePersona.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientePersonaDto implements Serializable {
    private static final long serialVersionUID = -6830674463769062486L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long clienteId;
    private String contrasena;
    private boolean estado;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long personaId;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
