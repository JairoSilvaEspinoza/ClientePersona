package com.reto.ClientePersona.models.dtos;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReporteClienteMovDto implements Serializable {

    private static final long serialVersionUID = 2985719295022637689L;

    private Date fecha;
    private Long PersonaId;
    private String nombrePersona;
    private Long cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private Boolean estado;
    private Long MovimientoId;
    private BigDecimal valor;
    private BigDecimal saldo;

    public ReporteClienteMovDto(Date fecha, Long personaId, String nombrePersona, Long cuentaId, String numeroCuenta, String tipoCuenta, Boolean estado, Long movimientoId, BigDecimal valor, BigDecimal saldo) {
        this.fecha = fecha;
        PersonaId = personaId;
        this.nombrePersona = nombrePersona;
        this.cuentaId = cuentaId;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldo.add(valor.negate());
        this.estado = estado;
        MovimientoId = movimientoId;
        this.valor = valor;
        this.saldo = saldo;
    }
}
