package com.ong.help.services;

import com.ong.help.dto.EnvioDTO;
import com.ong.help.dto.EnvioSaveDTO;

public interface EnvioService {

    EnvioDTO findById(Long id);

    Long save(EnvioSaveDTO envio);
    
}
