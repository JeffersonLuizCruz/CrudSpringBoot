package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.interfaceService.IPessoaService;
import com.crud.demo.interfaces.IPessoa;
import com.crud.demo.model.Pessoa;

@Service
public class PessoaService implements IPessoaService{
	
	@Autowired
	IPessoa dadoRepository;

	@Override
	public List<Pessoa> listar() {
		return (List<Pessoa>) dadoRepository.findAll();
	}

	@Override
	public Optional<Pessoa> listarId(short id) {
		Optional<Pessoa> listarId = dadoRepository.findById(id);
		return listarId;
	}

	@Override
	public short salvar(Pessoa p) {
		int res = 0;
		Pessoa pessoa = dadoRepository.save(p);
		if(!pessoa.equals(null)) {
			res=1;
		}
		return (short) res;
	}

	@Override
	public void delete(short id) {
		 dadoRepository.deleteById(id);
		
	}

}
