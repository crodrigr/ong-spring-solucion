package com.ong.help.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ong.help.repositories.entities.SocioEntity;

public interface SocioRepository extends CrudRepository<SocioEntity,Long> {
    
}
