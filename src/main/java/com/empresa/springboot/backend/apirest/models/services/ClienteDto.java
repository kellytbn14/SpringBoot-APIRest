package com.empresa.springboot.backend.apirest.models.services;

import java.util.Date;

public class ClienteDto {

    private long id;
    private String nombre;
    private String apellido;
    private Date fecha;
    private String email;

    public ClienteDto(){}

    public ClienteDto(long id, String nombre, String apellido, Date fecha, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
