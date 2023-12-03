package com.ong.help.dto;

import lombok.Data;

@Data
public class PersonaDTO {

    private Long id;
    private String nombres;
    private String apellidos;
    private String email;
    private String direccion;
    private String ciudad;
    private String celular;

}
