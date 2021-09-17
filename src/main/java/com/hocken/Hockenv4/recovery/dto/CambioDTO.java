package com.hocken.Hockenv4.recovery.dto;

import javax.validation.constraints.NotBlank;

public class CambioDTO {
    @NotBlank
    private String contrasena;
    @NotBlank
    private String confirmacion;
    @NotBlank
    private String token;
    public CambioDTO() {
    }
    public CambioDTO(String contrasena, String confirmacion, String token) {
        this.contrasena = contrasena;
        this.confirmacion = confirmacion;
        this.token = token;
    }
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
