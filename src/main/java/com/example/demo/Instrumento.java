package com.example.demo;

/* esta clase representa las  escalas, cuestionarios y tests (forma) que existen para
identificar y para manejar la ansiedad y el estrés.
 */

public class Instrumento {
    enum Tipo{
        Identificar, Tratar
    }
    enum Condicion{
        Estres, Ansiedad, Ambas
    }
    enum Forma{
        Test, Escala, Cuestionario
    }
    private String nombre;
    private Condicion condicion;//ansiedad, estres o ambas
    private Forma forma;//test, escala o cuestionario
    private Tipo tipo; // identificar o tratar
    private String autores;//autor o autores
    private boolean confianza;//evaluacion de confianza si o no
    private boolean validez;//evaluacion de validez si o no
    private String citaDeEvaluacion;
    private int clave;//id


    public Instrumento(){

    }

    public Instrumento(int clave, String nombre, Condicion condicion, Forma forma,Tipo tipo,
                       String autores, boolean confianza, boolean validez, String citaDeEvaluacion) {
        this.clave = clave;
        this.nombre = nombre;
        this.condicion = condicion;
        this.forma = forma;
        this.tipo=tipo;
        this.autores = autores;
        this.confianza = confianza;
        this.validez=validez;
        this.citaDeEvaluacion = citaDeEvaluacion;
    }


    //getters y setters
    public String getNombre(){return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Condicion getCondicion(){return condicion;}
    public void setCondicion(Condicion condicion) {this.condicion = condicion;}


    public Forma getForma() {return forma;}
    public void setForma(Forma forma) {this.forma = forma;}

    public Tipo getTipo() {return tipo;}
    public void setTipo(Tipo tipo) {this.tipo = tipo;}


    public String getAutores(){return autores;}
    public void setAutores(String autores) {this.autores = autores;}

    public int getClave() {return clave;}
    public void setClave(int clave) {this.clave = clave;}

    public String getCitaDeEvaluacion() {return citaDeEvaluacion;}
    public void setCitaDeEvaluacion(String citaDeEvaluacion) {this.citaDeEvaluacion = citaDeEvaluacion;}

    public boolean isConfianza() {return confianza;}
    public void setConfianza(boolean confianza) {this.confianza = confianza;}

    public boolean isValidez() {return validez;}
    public void setValidez(boolean validez) {this.validez = validez;}

    public String toString(){
        return "Instrumento {" +
                "clave=" + clave +
                ", \n nombre='" + nombre + '\'' +
                ", \n tipo=" + tipo +
                ", \n condicion=" + condicion +
                ", \n forma=" + forma +
                ", \n autor(es)='" + autores + '\'' +
                ", \n confiabilidad=" + (confianza ? "Sí" : "No") +
                ", \n validez=" + (validez ? "Sí" : "No") +
                ", \n cita='" + citaDeEvaluacion + '\'' +
                '}';
    }
}