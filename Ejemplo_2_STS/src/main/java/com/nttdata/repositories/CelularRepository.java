package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Celular;

@Repository
public interface CelularRepository extends CrudRepository<Celular,Long>{
	List<Celular> findAll();
}
