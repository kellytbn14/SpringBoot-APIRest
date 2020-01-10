package com.empresa.springboot.backend.apirest.models.services;

import com.empresa.springboot.backend.apirest.models.dao.ClienteRep;
import com.empresa.springboot.backend.apirest.models.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImple implements ClienteService {

    @Autowired
    private ClienteRep clienteRep;
    private ModelMapper modelMapper;

    public ClienteServiceImple(ClienteRep clienteRep, ModelMapper modelMapper) {
        this.clienteRep = clienteRep;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRep.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRep.findById(id).orElse(null);
    }

    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        return clienteRep.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRep.deleteById(id);
    }

}
