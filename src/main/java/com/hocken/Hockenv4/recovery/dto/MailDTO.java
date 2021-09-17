package com.hocken.Hockenv4.recovery.dto;

public class MailDTO {
    private String mailTo;
    private String mailFrom;
    private String mailSubject;
    private String nombre;
    private String token;

    public MailDTO() {
    }

    public MailDTO(String mailTo, String mailFrom, String mailSubject, String nombre, String token) {
        this.mailTo = mailTo;
        this.mailFrom = mailFrom;
        this.mailSubject = mailSubject;
        this.nombre = nombre;
        this.token = token;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
