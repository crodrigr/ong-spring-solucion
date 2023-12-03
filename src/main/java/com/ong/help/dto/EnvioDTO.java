package com.ong.help.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class EnvioDTO {
   
    private Long id;
    private LocalDate fecha;
    private String codigo;    
    private RefugioDTO refugio;
    private List<DetalleEnvioDTO> detalleEnvios=new ArrayList<>();   
    private List<SedeDTO> sedes=new ArrayList<>();    
   
    
}
