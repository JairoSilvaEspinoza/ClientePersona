package com.reto.ClientePersona.services;

import com.reto.ClientePersona.models.Cuenta;
import com.reto.ClientePersona.models.Movimiento;
import com.reto.ClientePersona.models.dtos.MovimientoDto;
import com.reto.ClientePersona.models.dtos.ReporteClienteMovDto;
import com.reto.ClientePersona.models.mappers.MovimientoMaper;
import com.reto.ClientePersona.repositories.CuentaRepository;
import com.reto.ClientePersona.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }



    @Transactional
    public MovimientoDto saveMovimiento(MovimientoDto movimientoDto) {
        Cuenta cuenta = cuentaRepository.findById(movimientoDto.getCuentaId()).orElseThrow(() ->
                new RuntimeException("Cuenta no encontrada"));
        BigDecimal nuevoSaldo = cuenta.getSaldo().add(movimientoDto.getValor());
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Saldo insuficiente");
        }
        cuenta.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);
        movimientoDto.setSaldo(nuevoSaldo);
        Movimiento movimiento = MovimientoMaper.INSTANCE.dtoToMovimiento(movimientoDto);
        movimiento.setCuenta(cuenta);
        movimientoRepository.save(movimiento);
        movimientoDto.setId(movimiento.getId());
        movimientoDto.setNumeroCuenta(cuenta.getNumeroCuenta());
        return movimientoDto ;
    }


    public List<ReporteClienteMovDto> getReportByPersonaId(Date fechaInicio, Date fechaFin, Long personaId) {
        if (fechaInicio.equals(fechaFin)){
            LocalDateTime localDateTime = fechaInicio.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            fechaFin = Date.from(localDateTime
                    .with(LocalTime.MAX)
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
        }
        return movimientoRepository.getReportByPersonaId(fechaInicio, fechaFin, personaId);
    }
}