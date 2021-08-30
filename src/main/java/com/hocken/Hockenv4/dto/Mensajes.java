package com.hocken.Hockenv4.dto;
/**Clase para mostrar mensajes en pantalla a front*/
public class Mensajes {
    private String mensaje;

    public Mensajes(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
