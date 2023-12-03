package com.ong.help.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DonacionDTO {

    private Long id;
    private LocalDateTime fecha;
    private String categoria;
    private Double valor; 
    
}
