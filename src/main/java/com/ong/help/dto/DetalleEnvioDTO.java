package com.ong.help.dto;

import lombok.Data;

@Data
public class DetalleEnvioDTO {

    private Long id;
    private String categoria;
    private String subcategoria;
    private String descripcion;
    private Integer cantidad;
    private String unidadMedida;    
    
    
    
}
