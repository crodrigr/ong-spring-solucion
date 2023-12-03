package com.ong.help.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name="socios")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class SocioEntity extends PersonaEntity {

    @ManyToOne
    @JoinColumn(name="sedeId")
    private SedeEntity sede;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="id_socio")
    private List<BancoEntity> bancos;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="id_socio")
    private List<DonacionEntity> donaciones;
    
}
