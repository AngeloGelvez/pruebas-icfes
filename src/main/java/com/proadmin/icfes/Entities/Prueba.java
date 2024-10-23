package com.proadmin.icfes.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="prueba")
public class Prueba {

    @Id
    private String id;
    private String numeroRegistro;
    private int puntajeTotal;
    private int puntajeComunicacionEscrita;
    private int puntajeRazonamientoCuantitativo;
    private int puntajeLecturaEscrita;
    private int puntajeCompetenciasCiudadanas;
    private int puntajeIngles;
    private int puntajeFPI;
    private int puntajePCME;
    private int puntajeDDS;

    //LOGICA

    public int calcularPuntajeTotal() {
        int totalPuntajes = puntajeComunicacionEscrita + puntajeRazonamientoCuantitativo +
                puntajeLecturaEscrita + puntajeCompetenciasCiudadanas +
                puntajeIngles + puntajeFPI + puntajePCME + puntajeDDS;
        int cantidadPuntajes = 8; // Número de puntajes que estás promediando
        return totalPuntajes / cantidadPuntajes;
    }


    //FIN LOGICA


    public Prueba() {
    }

    public Prueba(String id, String numeroRegistro, int puntajeTotal, int puntajeComunicacionEscrita, int puntajeRazonamientoCuantitativo, int puntajeLecturaEscrita, int puntajeCompetenciasCiudadanas, int puntajeIngles, int puntajeFPI, int puntajePCME, int puntajeDDS) {
        this.id = id;
        this.numeroRegistro = numeroRegistro;
        this.puntajeTotal = puntajeTotal;
        this.puntajeComunicacionEscrita = puntajeComunicacionEscrita;
        this.puntajeRazonamientoCuantitativo = puntajeRazonamientoCuantitativo;
        this.puntajeLecturaEscrita = puntajeLecturaEscrita;
        this.puntajeCompetenciasCiudadanas = puntajeCompetenciasCiudadanas;
        this.puntajeIngles = puntajeIngles;
        this.puntajeFPI = puntajeFPI;
        this.puntajePCME = puntajePCME;
        this.puntajeDDS = puntajeDDS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public int getPuntajeComunicacionEscrita() {
        return puntajeComunicacionEscrita;
    }

    public void setPuntajeComunicacionEscrita(int puntajeComunicacionEscrita) {
        this.puntajeComunicacionEscrita = puntajeComunicacionEscrita;
    }

    public int getPuntajeRazonamientoCuantitativo() {
        return puntajeRazonamientoCuantitativo;
    }

    public void setPuntajeRazonamientoCuantitativo(int puntajeRazonamientoCuantitativo) {
        this.puntajeRazonamientoCuantitativo = puntajeRazonamientoCuantitativo;
    }

    public int getPuntajeLecturaEscrita() {
        return puntajeLecturaEscrita;
    }

    public void setPuntajeLecturaEscrita(int puntajeLecturaEscrita) {
        this.puntajeLecturaEscrita = puntajeLecturaEscrita;
    }

    public int getPuntajeCompetenciasCiudadanas() {
        return puntajeCompetenciasCiudadanas;
    }

    public void setPuntajeCompetenciasCiudadanas(int puntajeCompetenciasCiudadanas) {
        this.puntajeCompetenciasCiudadanas = puntajeCompetenciasCiudadanas;
    }

    public int getPuntajeIngles() {
        return puntajeIngles;
    }

    public void setPuntajeIngles(int puntajeIngles) {
        this.puntajeIngles = puntajeIngles;
    }

    public int getPuntajeFPI() {
        return puntajeFPI;
    }

    public void setPuntajeFPI(int puntajeFPI) {
        this.puntajeFPI = puntajeFPI;
    }

    public int getPuntajePCME() {
        return puntajePCME;
    }

    public void setPuntajePCME(int puntajePCME) {
        this.puntajePCME = puntajePCME;
    }

    public int getPuntajeDDS() {
        return puntajeDDS;
    }

    public void setPuntajeDDS(int puntajeDDS) {
        this.puntajeDDS = puntajeDDS;
    }
}