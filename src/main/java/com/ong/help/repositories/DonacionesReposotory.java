package com.ong.help.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ong.help.repositories.entities.DonacionEntity;

public interface DonacionesReposotory extends CrudRepository<DonacionEntity,Long> {
    
}
