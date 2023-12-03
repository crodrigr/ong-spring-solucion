package com.ong.help.dto;

import lombok.Data;

@Data
public class DetalleEnvioSaveDTO {

    private Long id;
    private String categoria;
    private String subcategoria;
    private String descripcion;
    private Integer cantidad;
    private String unidadMedida;
    private EnvioDTO envio;
       
    
    
    
}
