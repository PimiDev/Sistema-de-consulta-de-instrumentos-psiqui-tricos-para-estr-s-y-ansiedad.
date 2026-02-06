package com.example.demo;

import java.util.Scanner;

public class Control {

    Coleccion coleccion = new Coleccion();

    public Control() {

        Scanner sc = new Scanner(System.in);

        int opcionMenuPrincipal = 0;

        do {
            System.out.println("Bienvenido al sistema de consultad de la American Psychology Association)\n");

            System.out.println("Que desea hacer? \n 1. Consultar instrumento \n 2. Agregar instrumento \n 3. Eliminar Instrumento \n 4. Salir\n");

            opcionMenuPrincipal = sc.nextInt();

            if (opcionMenuPrincipal < 1 || opcionMenuPrincipal > 4) {
                System.out.println("Opcion no encontrada.");
            }

            switch (opcionMenuPrincipal) {
                case 1:
                    coleccion.agregarInstrumento(new Instrumento());

            }
        } while (opcionMenuPrincipal != 4);
    }
}
