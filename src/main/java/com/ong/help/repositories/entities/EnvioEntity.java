package com.ong.help.repositories.entities;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="envios")
public class EnvioEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String codigo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_refugio")
    private RefugioEntity refugio;
    @ManyToMany(mappedBy = "envios", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<SedeEntity> sedes;    
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL,  orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleEnvio> detallesEnvios;
    
    
}
