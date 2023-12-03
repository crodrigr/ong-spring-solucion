package com.ong.help.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.help.dto.EnvioDTO;
import com.ong.help.dto.EnvioSaveDTO;
import com.ong.help.repositories.EnvioRepository;
import com.ong.help.repositories.RefugioRepository;
import com.ong.help.repositories.SedeRepository;
import com.ong.help.repositories.entities.EnvioEntity;
import com.ong.help.repositories.entities.RefugioEntity;
import com.ong.help.repositories.entities.SedeEntity;
import com.ong.help.services.EnvioService;
import com.ong.help.util.convert.EnvioDTOConvert;
import com.ong.help.util.exceptions.ExceptionNotFoundEnvio;
import com.ong.help.util.exceptions.ExceptionNotFoundRefugio;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnvioServiceImp implements EnvioService {

    private EnvioRepository envioReposotory;

    private EnvioDTOConvert envioDTOConvert;

    private RefugioRepository refugioRepository;

    private SedeRepository sedeRepository;

    @Override
    @Transactional(readOnly = true)
    public EnvioDTO findById(Long id) throws ExceptionNotFoundEnvio {
        EnvioEntity envioEntity = envioReposotory.findById(id)
                .orElseThrow(() -> new ExceptionNotFoundEnvio("No existe envío por ese id: " + id));
        return envioDTOConvert.converEnvioDTO(envioEntity);
    }

    @Override
    @Transactional
    public Long save(EnvioSaveDTO envio) {
        RefugioEntity refugio = obtenerRefugio(envio.getIdRefugio());
        List<SedeEntity> sedes = obtenerSedes(envio.getSedesId());
        EnvioEntity envioEntity = envioDTOConvert.converEnvioEntity(envio);
        envioEntity.setRefugio(refugio);
        configurarSedesEnvios(envioEntity, sedes);
        envioReposotory.save(envioEntity);
        return envioEntity.getId();
    }

    private RefugioEntity obtenerRefugio(Long idRefugio) {
        return refugioRepository.findById(idRefugio)
                .orElseThrow(() -> new ExceptionNotFoundRefugio("No existe el refugio con ese id:" + idRefugio));
    }

    private List<SedeEntity> obtenerSedes(Iterable<Long> sedesIds) {
        return (List<SedeEntity>) sedeRepository.findAllById(sedesIds);
    }

    private void configurarSedesEnvios(EnvioEntity envioEntity, List<SedeEntity> sedes) {
        sedes.forEach(sede -> sede.getEnvios().add(envioEntity));
        envioEntity.setSedes(sedes);
    }

}
