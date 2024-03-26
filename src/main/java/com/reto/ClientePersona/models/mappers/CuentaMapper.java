package com.reto.ClientePersona.models.mappers;
import com.reto.ClientePersona.models.Cuenta;
import com.reto.ClientePersona.models.dtos.CuentaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CuentaMapper {
    CuentaMapper INSTANCE = Mappers.getMapper(CuentaMapper.class);

    Cuenta dtoToCuenta(CuentaDto clienteDto);
    CuentaDto cuentaToDto(Cuenta cuenta);
}
