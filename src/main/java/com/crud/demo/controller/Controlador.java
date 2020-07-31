package com.crud.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.demo.interfaceService.IPessoaService;
import com.crud.demo.model.Pessoa;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IPessoaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Pessoa> pessoas = service.listar();
		model.addAttribute("pessoas", pessoas);
		return "index";
	}
	@GetMapping("/new")
	public String adicionar(Model model) {
		model.addAttribute("pessoa", new Pessoa());
		return "form";
	}
	@PostMapping("/salvo")
	public String salvar(@Validated Pessoa p) {
		service.salvar(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable short id, Model model) {
		Optional<Pessoa> pessoa = service.listarId(id);
		model.addAttribute("pessoa", pessoa);
		return "form";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable short id, Model model) {
		Optional<Pessoa> pessoa = service.listarId(id);
		service.delete(id);
		model.addAttribute("pessoa", pessoa);
		return "redirect:/listar";
	}

}
