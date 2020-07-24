package com.crud.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.model.Pessoa;

@Repository
public interface IPessoa extends CrudRepository<Pessoa, Short>{
	
}
