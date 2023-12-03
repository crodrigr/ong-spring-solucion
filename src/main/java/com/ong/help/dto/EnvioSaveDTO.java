package com.ong.help.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class EnvioSaveDTO {
   
    private Long id;
    private LocalDate fecha;
    private String codigo;    
    private Long idRefugio;
    private List<DetalleEnvioDTO> detalleEnvios=new ArrayList<>();   
    private Iterable<Long> sedesId=new ArrayList<>();    
   
    
}
