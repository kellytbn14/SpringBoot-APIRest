package com.empresa.springboot.backend.apirest.models.services;

import com.empresa.springboot.backend.apirest.models.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente save(ClienteDto clienteDto);

    public void delete(Long id);

}
