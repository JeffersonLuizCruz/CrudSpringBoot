package com.crud.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.crud.demo.model.Pessoa;

public interface IPessoaService{
	
	public List<Pessoa> listar();
	public Optional<Pessoa> listarId(short id);
	public short salvar(Pessoa p);
	public void delete(short id);
	

}
