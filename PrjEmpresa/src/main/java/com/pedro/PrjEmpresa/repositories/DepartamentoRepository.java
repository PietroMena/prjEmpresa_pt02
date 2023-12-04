package com.pedro.PrjEmpresa.repositories;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.pedro.PrjEmpresa.entities.Departamento;

	public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
		

	}

