package com.reto.ClientePersona.repositories;

import com.reto.ClientePersona.models.Movimiento;
import com.reto.ClientePersona.models.dtos.ReporteClienteMovDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    @Query("SELECT new com.reto.ClientePersona.models.dtos.ReporteClienteMovDto(" +
            "m.fecha, p.id, p.nombre, c.id, c.numeroCuenta, c.tipoCuenta,  c.estado, m.id, m.valor, m.saldo) " +
            "FROM Cuenta c " +
            "JOIN c.persona p " +
            "JOIN c.movimientos m " +
            "WHERE p.id = :personaId AND m.fecha >= :fechaInicio AND m.fecha <= :fechaFin")
    List<ReporteClienteMovDto> getReportByPersonaId(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("personaId") Long personaId);
}
