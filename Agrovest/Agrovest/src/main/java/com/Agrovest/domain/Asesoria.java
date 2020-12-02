package com.Agrovest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asesorias")
public class Asesoria {

    @Id
    private String id;

    private String asunto;
    private String descripcion;
    private String respuesta;
    private String userId;
    private String userName;

    public Asesoria(String asunto, String descripcion, String respuesta, String user, String userName) {
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.respuesta = respuesta;
        this.userId = user;
        this.userName = userName;
    }

    public Asesoria() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

}

