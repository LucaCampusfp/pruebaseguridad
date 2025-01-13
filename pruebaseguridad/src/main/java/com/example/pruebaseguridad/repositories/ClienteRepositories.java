package com.example.pruebaseguridad.repositories;

import com.example.pruebaseguridad.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepositories extends JpaRepository<Cliente, String> {

}
