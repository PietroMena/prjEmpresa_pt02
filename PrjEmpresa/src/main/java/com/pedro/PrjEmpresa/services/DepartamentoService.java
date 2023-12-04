package com.pedro.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.PrjEmpresa.entities.Departamento;
import com.pedro.PrjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {


	private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	public Departamento getDepartamentoById(Long Id) {
		return departamentoRepository.findById(Id).orElse(null);
	}
	
	public Departamento saveDepartamento(Departamento Departamento) {
		return departamentoRepository.save(Departamento);
	}
	
	public List<Departamento> getAllDepartamento(){
		return departamentoRepository.findAll();
	}
	
	public void deleteDepartamento(Long id) {
		departamentoRepository.deleteById(id);
	}
	
	public Departamento updateDepartamento(Long id, Departamento novoDepartamento) {
        Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
        if (departamentoOptional.isPresent()) {
        	Departamento departamentoExistente = departamentoOptional.get();
        	departamentoExistente.setDepnome(novoDepartamento.getDepnome());          
            return departamentoRepository.save(departamentoExistente); 
        } else {
            return null; 
        }
    }
	
}

