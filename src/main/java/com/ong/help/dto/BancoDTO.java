package com.ong.help.dto;

import lombok.Data;

@Data
public class BancoDTO {

    private Long id;
    private String tipoCuenta;
    private String numero;
    private Boolean estado;
    
}
