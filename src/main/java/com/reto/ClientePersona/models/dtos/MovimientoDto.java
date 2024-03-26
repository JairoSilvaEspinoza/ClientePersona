package com.reto.ClientePersona.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovimientoDto implements Serializable {

    private static final long serialVersionUID = -4647260539881957189L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Date fecha;
    private String tipoMovimiento;
    private BigDecimal valor;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal saldo;
    private Long cuentaId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String numeroCuenta;
}
