package com.ong.help.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmpleadoDTO extends PersonaDTO {

    private String cargo;
    private String profesion;
    private Boolean estado;
   
    
}
