package com.ong.help.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ong.help.repositories.entities.EmpleadoEntity;

public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity,Long> {
     
}
