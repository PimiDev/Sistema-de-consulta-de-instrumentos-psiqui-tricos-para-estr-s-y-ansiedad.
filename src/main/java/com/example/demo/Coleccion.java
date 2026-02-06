package com.example.demo;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Coleccion {

    ArrayList<Instrumento> instrumentos = new ArrayList<>();

    public Coleccion(){

    }
    public void agregarInstrumento(Instrumento instrumento){
        instrumentos.add(instrumento);
    }

    public void eliminarInstrumento(Instrumento instrumento){
        instrumentos.remove(instrumento);
    }

    public ArrayList<Instrumento> consultarPorAutor(String autor ){
        return (ArrayList<Instrumento>) instrumentos.stream()
                .filter(ins -> ins.getAutores().equals(autor))
                .toList();
    }

    public ArrayList<Instrumento> consultarPorNombre(String nombre){
        return (ArrayList<Instrumento>) instrumentos.stream()
                .filter(ins -> ins.getNombre().equals(nombre))
                .toList();
    }

    public ArrayList<Instrumento> consultarPorTipo(Instrumento.Tipo tipo){
     return (ArrayList<Instrumento>)   instrumentos.stream()
                    .filter(ins-> ins.getTipo().equals(tipo))
                    .toList();
    }
    public ArrayList <Instrumento>consultarPorCondicion(Instrumento.Condicion condicion){
     return (ArrayList<Instrumento>) instrumentos.stream()
             .filter(ins -> ins.getForma().equals(condicion))
             .toList();
    }
    public ArrayList <Instrumento>consultarPorForma(Instrumento.Forma forma){
        return (ArrayList<Instrumento>) instrumentos.stream()
                    .filter(ins -> ins.getForma().equals(forma))
                    .toList();
    }
    public ArrayList <Instrumento> consultarPorValidacion(Boolean isValidado){
        return (ArrayList<Instrumento>) instrumentos.stream()
                .filter(ins -> ins.isValidez())
                .toList();
    }

    public ArrayList <Instrumento> consultarPorConfiabilidad(Boolean isConfiable){
        return (ArrayList<Instrumento>) instrumentos.stream()
                .filter(ins -> ins.isConfianza())
                .toList();
    }

    public ArrayList <Instrumento> ordenarPorID(){
        return (ArrayList<Instrumento>) instrumentos.stream()
                .sorted(Comparator.comparing(ins -> ins.getClave()))
                .toList();
    }

}

