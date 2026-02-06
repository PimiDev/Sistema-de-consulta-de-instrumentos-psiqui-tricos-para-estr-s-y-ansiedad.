package com.example.demo;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Coleccion {

    ArrayList<Instrumento> instrumentos = new ArrayList<>();

    public Coleccion(){
    cargarDesdeArchivo();
    }
    public void agregarInstrumento(Instrumento instrumento){

        instrumentos.add(instrumento);
        guardarEnArchivo(instrumento);
    }

    public boolean eliminarInstrumento(int clave) {
        boolean eliminado = instrumentos.removeIf(i -> i.getClave() == clave);

        if (eliminado) {
            reescribirArchivo();
        }

        return eliminado;
    }


    public void mostrarTodosLosInstrumentos(){
        instrumentos.forEach(System.out::println);
    }

    public List<Instrumento> ordenarPorAutor(){
        return instrumentos.stream()
                .sorted(Comparator.comparing(ins -> ins.getAutores()))
                .toList();
    }

    public List<Instrumento> ordenarPorNombre(){
        return instrumentos.stream()
                .sorted(Comparator.comparing(ins -> ins.getNombre()))
                .toList();
    }

    public List<Instrumento> consultarPorTipo(Instrumento.Tipo tipo){
     return instrumentos.stream()
                    .filter(ins-> ins.getTipo().equals(tipo))
                    .toList();
    }
    public List <Instrumento>consultarPorCondicion(Instrumento.Condicion condicion){
     return instrumentos.stream()
             .filter(ins -> ins.getForma().equals(condicion))
             .toList();
    }
    public List <Instrumento>consultarPorForma(Instrumento.Forma forma){
        return  instrumentos.stream()
                    .filter(ins -> ins.getForma().equals(forma))
                    .toList();
    }
    public List <Instrumento> consultarPorValidacion(){
        return  instrumentos.stream()
                .filter(ins -> ins.isValidez())
                .toList();
    }

    public List <Instrumento> consultarPorConfiabilidad(){
        return instrumentos.stream()
                .filter(ins -> ins.isConfianza())
                .toList();
    }

    public List <Instrumento> ordenarPorID(){
        return  instrumentos.stream()
                .sorted(Comparator.comparing(ins -> ins.getClave()))
                .toList();
    }

    private void guardarEnArchivo(Instrumento instrumento) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("instrumentos.txt", true))) { // true = append

            writer.write(instrumento.toFileString());
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error al guardar el instrumento en archivo");
        }
    }

    private void reescribirArchivo() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("instrumentos.txt", false))) { // false = sobrescribir

            for (Instrumento i : instrumentos) {
                writer.write(i.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al reescribir el archivo");
        }
    }

    private void cargarDesdeArchivo() {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("instrumentos.txt"))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split("\\|");

                int clave = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                Instrumento.Condicion condicion =
                        Instrumento.Condicion.valueOf(datos[2]);
                Instrumento.Forma forma =
                        Instrumento.Forma.valueOf(datos[3]);
                Instrumento.Tipo tipo =
                        Instrumento.Tipo.valueOf(datos[4]);
                String autores = datos[5];
                boolean confianza = Boolean.parseBoolean(datos[6]);
                boolean validez = Boolean.parseBoolean(datos[7]);
                String cita = datos[8];

                Instrumento instrumento = new Instrumento(
                        clave, nombre, condicion, forma, tipo,
                        autores, confianza, validez, cita
                );

                instrumentos.add(instrumento);
            }

        } catch (IOException e) {
            System.out.println("Archivo no encontrado, iniciando colección vacía");
        }
    }
}

