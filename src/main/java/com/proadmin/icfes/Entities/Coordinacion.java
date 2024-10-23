package com.proadmin.icfes.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coordinadores")
public class Coordinacion {

    @Id
    private String id;
    private String usuario;
    private String contra;

    public Coordinacion() {
    }

    public Coordinacion(String id, String usuario, String contra) {
        this.id = id;
        this.usuario = usuario;
        this.contra = contra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}