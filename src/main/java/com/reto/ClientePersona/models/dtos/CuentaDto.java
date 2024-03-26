package com.reto.ClientePersona.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CuentaDto implements Serializable {

    private static final long serialVersionUID = -819821682286350033L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldo;
    private Boolean estado;
    private Long personaId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nombrePersona;
}
