package com.ong.help.repositories.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name="empleados")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class EmpleadoEntity extends PersonaEntity{

    private String cargo;
    private String profesion;
    private Boolean estado;
    @ManyToMany(mappedBy = "voluntarios")
    private Set<DetalleEnvio> mision;

    
    
}
