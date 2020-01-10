package com.empresa.springboot.backend.apirest.models.dao;

import com.empresa.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRep extends CrudRepository<Cliente, Long> {
}
