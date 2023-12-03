package com.ong.help.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SocioDTO extends PersonaDTO{

    private List<BancoDTO> bancos;
    private List<DonacionDTO> donaciones;

} 