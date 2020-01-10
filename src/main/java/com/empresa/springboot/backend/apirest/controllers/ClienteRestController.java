package com.empresa.springboot.backend.apirest.controllers;

import com.empresa.springboot.backend.apirest.models.entity.Cliente;
import com.empresa.springboot.backend.apirest.models.services.ClienteDto;
import com.empresa.springboot.backend.apirest.models.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@Validated
public class ClienteRestController {

    private ClienteService clienteService;
    /*private ModelMapper modelMapper;

    public ClienteRestController(ClienteService clienteService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.modelMapper = modelMapper;
    }*/

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id){
        return clienteService.findById(id);
    }

   /* @PostMapping
    @RequestMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDto> create(@RequestBody @Valid ClienteDto clienteDto){
        clienteDto.setFecha(new Date());
        Cliente clienteCreate = clienteService.save(clienteDto);
        ClienteDto clienteMapper = modelMapper.map(clienteCreate, ClienteDto.class);
        return new ResponseEntity<ClienteDto>(clienteMapper, null);
    }*/

   /* @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteActual = clienteService.findById(id);

        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setEmail(cliente.getEmail());

        return clienteService.save(clienteActual);
    }*/

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
