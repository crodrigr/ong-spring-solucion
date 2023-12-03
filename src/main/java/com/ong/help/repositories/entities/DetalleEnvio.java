package com.ong.help.repositories.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="detalles_envio")
public class DetalleEnvio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String subcategoria;
    private String descripcion;
    private Integer cantidad;
    private String unidadMedida;
    @ManyToOne()
    @JoinColumn(name="envio_id")
    private EnvioEntity envio;
    @ManyToMany
    @JoinTable(name="misiones",
               joinColumns={@JoinColumn(name="detalle_id")},
               inverseJoinColumns = {@JoinColumn(name = "voluntario_id")})    
    private Set<EmpleadoEntity> voluntarios;
    @ManyToOne
    @JoinColumn(name="sede_id")
    private SedeEntity sede;
    
    
}
