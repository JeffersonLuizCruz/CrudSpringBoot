package com.crud.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.model.Pessoa;

@Repository
public interface IPessoa extends JpaRepository<Pessoa, Short>{
	
}
