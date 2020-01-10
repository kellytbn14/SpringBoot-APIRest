package com.empresa.springboot.backend.apirest.controllers;

import com.empresa.springboot.backend.apirest.models.entity.Cliente;
import com.empresa.springboot.backend.apirest.models.services.ClienteDto;
import com.empresa.springboot.backend.apirest.models.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@Validated
public class ClienteRestController {

    private ClienteService clienteService;
    private ModelMapper modelMapper;

    public ClienteRestController(ClienteService clienteService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/clientes")
    public List<ClienteDto> index(){
        Type listType = new TypeToken<List<ClienteDto>>(){}.getType();
        List<ClienteDto> clienteDtoList = modelMapper.map(clienteService.findAll(),listType);
        return clienteDtoList;
    }

    @GetMapping("/clientes/{id}")
    public ClienteDto show(@PathVariable Long id){
        ClienteDto clienteDto = modelMapper.map(clienteService.findById(id), ClienteDto.class);
        return clienteDto;
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteDto> create(@RequestBody @Valid ClienteDto clienteDto){
        clienteDto.setFecha(new Date());
        Cliente clienteCreate = clienteService.save(clienteDto);
        ClienteDto clienteMapper = modelMapper.map(clienteCreate, ClienteDto.class);
        return new ResponseEntity<ClienteDto>(clienteMapper, null,HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto update(@RequestBody ClienteDto clienteDto, @PathVariable Long id){
        Cliente clienteActual = clienteService.findById(id);
        ClienteDto clienteDtoMapper = modelMapper.map(clienteActual, ClienteDto.class);

        clienteDtoMapper.setNombre(clienteDto.getNombre());
        clienteDtoMapper.setApellido(clienteDto.getApellido());
        clienteDtoMapper.setEmail(clienteDto.getEmail());

        Cliente clienteModificado = clienteService.save(clienteDtoMapper);
        clienteDtoMapper = modelMapper.map(clienteModificado, ClienteDto.class);

        return clienteDtoMapper;
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
