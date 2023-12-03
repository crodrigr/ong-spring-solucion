package com.ong.help.util.convert;


import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ong.help.dto.DetalleEnvioDTO;
import com.ong.help.dto.EnvioDTO;
import com.ong.help.dto.EnvioSaveDTO;
import com.ong.help.dto.SedeDTO;
import com.ong.help.repositories.entities.DetalleEnvio;
import com.ong.help.repositories.entities.EnvioEntity;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class EnvioDTOConvert {

    private ModelMapper dbm;

    public EnvioDTO converEnvioDTO(EnvioEntity envioEntity){

        List<DetalleEnvioDTO> detallesDTO=envioEntity.getDetallesEnvios().stream()
                                         .map(detalle->dbm.map(detalle,DetalleEnvioDTO.class))
                                         .toList();
        List<SedeDTO> sedesDTO=envioEntity.getSedes().stream()
                                                     .map(sede->dbm.map(sede,SedeDTO.class))
                                                     .toList();
        EnvioDTO envioDTO=dbm.map(envioEntity,EnvioDTO.class);
        envioDTO.setDetalleEnvios(detallesDTO);
        envioDTO.setSedes(sedesDTO);
        return envioDTO;
    }

    public EnvioEntity converEnvioEntity(EnvioDTO envioDTO){
        return dbm.map(envioDTO,EnvioEntity.class);
        
    }

    public EnvioEntity converEnvioEntity(EnvioSaveDTO envioDTO) {
        EnvioEntity envioEntity = dbm.map(envioDTO, EnvioEntity.class);
        
        List<DetalleEnvio> detalleEnvios = envioDTO.getDetalleEnvios().stream()
                .map(detalle -> {
                    DetalleEnvio detalleEntity = dbm.map(detalle, DetalleEnvio.class);
                    detalleEntity.setEnvio(envioEntity);
                    return detalleEntity;
                })
                .toList();
        
        envioEntity.setDetallesEnvios(detalleEnvios);        
        return envioEntity;
    }
    
}
