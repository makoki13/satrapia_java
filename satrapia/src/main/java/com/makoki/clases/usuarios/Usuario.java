package com.makoki.clases.usuarios;

import java.time.LocalDate;

public class Usuario {
    private final long ID;
    private final String correo;
    private final String nombre;
    private final String password;
    private final LocalDate fechaIngreso;
    private LocalDate ultimoAcceso;
    private boolean activo;

    public Usuario(
                long ID, String correo, String nombre, String password, 
                LocalDate fechaIngreso, LocalDate ultimoAcceso, boolean activo) {
        this.ID = ID;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
        this.fechaIngreso = fechaIngreso;
        this.ultimoAcceso = ultimoAcceso;
        this.activo = activo;
    }

    public long getID() {
        return ID;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }       

    public String getPassword() {
        return password;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getUltimoAcceso() {
        return ultimoAcceso;
    }

    public boolean isActivo() {
        return activo;
    }   

    public void setUltimoAcceso(LocalDate ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
