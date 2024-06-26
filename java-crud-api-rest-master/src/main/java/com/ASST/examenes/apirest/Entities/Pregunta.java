package com.ASST.examenes.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String iA;
    private String iB;
    private String iC;
    private String opD;
    private int puntaje;
    private String iOk;

    public String getiOk() {
        return iOk;
    }

    public void setiOk(String iOk) {
        this.iOk = iOk;
    }


    public String getiA() {
        return iA;
    }

    public void setiA(String iA) {
        this.iA = iA;
    }

    public String getiB() {
        return iB;
    }

    public void setiB(String iB) {
        this.iB = iB;
    }

    public String getiC() {
        return iC;
    }

    public void setiC(String iC) {
        this.iC = iC;
    }

    public String getopD() {
        return opD;
    }

    public void setOpD(String opD) {
        this.opD = opD;
    }


    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
