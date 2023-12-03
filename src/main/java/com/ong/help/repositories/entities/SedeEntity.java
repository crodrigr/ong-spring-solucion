package com.ong.help.repositories.entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name="sedes")
@EqualsAndHashCode(callSuper=false)
public class SedeEntity  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String direccion;
    private String ciudad;
    private String pais;
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocioEntity> socios;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="sede_envios",
               joinColumns = {@JoinColumn(name="sede_id")},
               inverseJoinColumns = {@JoinColumn(name="envio_id")})
    private List<EnvioEntity> envios;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval =true, fetch = FetchType.LAZY)
    @JoinColumn(name="sede_id")
    private List<EmpleadoEntity> empleados;

    
}
