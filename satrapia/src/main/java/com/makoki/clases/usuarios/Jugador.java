package com.makoki.clases.usuarios;

import java.time.LocalDateTime;

public class Jugador  {
    private Usuario usuario;
    private String nick;
    private LocalDateTime ultimoAcceso;
    private boolean activo;

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNick() {
        return nick;
    }

    public LocalDateTime getUltimoAcceso() {
        return ultimoAcceso;
    }

    public boolean isActivo() {
        return activo;
    }
}
