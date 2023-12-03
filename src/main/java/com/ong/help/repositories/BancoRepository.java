package com.ong.help.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ong.help.repositories.entities.BancoEntity;

public interface BancoRepository extends CrudRepository<BancoEntity,Long>{
    
}
