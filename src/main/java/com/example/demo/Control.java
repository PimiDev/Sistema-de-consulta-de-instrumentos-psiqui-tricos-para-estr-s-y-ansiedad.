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
                   consultarInstrumentos();
                    break;

                case 2:

                menuAgregarInstrumento();

                break;

                case 3:

                    System.out.println("Escribir clave del instrumento\n");
                    int clave = sc.nextInt();
                    sc.nextLine();
                    coleccion.eliminarInstrumento(clave);

                    break;

                case 4:

                    System.out.println("Hasta luego!");

                    break;
            }
        } while (opcionMenuPrincipal != 4);
    }









   private void menuAgregarInstrumento(){
       Instrumento instrumentoNuevo = new Instrumento();

       Scanner sc = new Scanner(System.in);

       System.out.println("Inserta la clave del nuevo instrumento");
       int clave = sc.nextInt();
       sc.nextLine();

       instrumentoNuevo.setClave(clave);

       System.out.println("Inserta el nombre del instrumento");
       String nombre = sc.nextLine();

       instrumentoNuevo.setNombre(nombre);

       System.out.println("Eliga la condicion correspondiente: \n 1. Estres \n 2. Ansiedad \n 3. Ambdas");
       int condicion = sc.nextInt();
       sc.nextLine();

       if(condicion == 1){ instrumentoNuevo.setCondicion(Instrumento.Condicion.Estres);}
       else if (condicion == 2){instrumentoNuevo.setCondicion(Instrumento.Condicion.Ansiedad);}
       else if(condicion == 3){instrumentoNuevo.setCondicion(Instrumento.Condicion.Ambas);  }


       System.out.println("Eliga la forma correspondiente: \n 1. Test \n 2. Escala \n 3. Cuestionario");
       int forma = sc.nextInt();
       sc.nextLine();

       if (forma == 1) {
           instrumentoNuevo.setForma(Instrumento.Forma.Test);
       } else if (forma == 2) {
           instrumentoNuevo.setForma(Instrumento.Forma.Escala);
       } else if (forma == 3) {
           instrumentoNuevo.setForma(Instrumento.Forma.Cuestionario);
       }

       System.out.println("Eliga el tipo correspondiente: \n 1. Identificar \n 2. Tratar\n");
       int tipo = sc.nextInt();
       sc.nextLine();

       if (tipo == 1) {
           instrumentoNuevo.setTipo(Instrumento.Tipo.Identificar);
       } else if (tipo == 2) {
           instrumentoNuevo.setTipo(Instrumento.Tipo.Tratar);
       }

       System.out.println("Inserte el autor/autores");
       String autor = sc.nextLine();

       instrumentoNuevo.setAutores(autor);

       System.out.println("El instrumento posee certificado de confiabilidad? 1= si, 2= no");
       int confiable = sc.nextInt();
       sc.nextLine();

       if(confiable == 1){instrumentoNuevo.setConfianza(true);}
       else{instrumentoNuevo.setConfianza(false);}

       System.out.println("El instrumento posee certificado de validez? 1= si, 2= no");
       int validez = sc.nextInt();
       sc.nextLine();

       if(validez == 1){instrumentoNuevo.setValidez(true);}
       else{instrumentoNuevo.setValidez(false);}

       System.out.println("Inserte la cita de evaluacion");
       String cita = sc.nextLine();

       instrumentoNuevo.setCitaDeEvaluacion(cita);

       coleccion.agregarInstrumento(instrumentoNuevo);

   }


   private void consultarInstrumentos(){

        Scanner sc = new Scanner(System.in);

       int opcionConsulta = 0;

       do {

           System.out.println("Que desea hacer?\n");

           System.out.println("1. Mostrar todos los instrumentos");
           System.out.println("2. Ordenar por autor");
           System.out.println("3. Ordenar por nombre");
           System.out.println("4. Consultar por tipo");
           System.out.println("5. Consultar por condicion");
           System.out.println("6. Consultar por forma");
           System.out.println("7. Consultar por validacion");
           System.out.println("8. Consultar por confiabilidad");
           System.out.println("9. Ordenar por ID");

           opcionConsulta = sc.nextInt();

           switch (opcionConsulta){
               case 1:
                   coleccion.mostrarTodosLosInstrumentos();
                   break;
               case 2:
                   coleccion.ordenarPorAutor()
                           .forEach(System.out::println);
                   break;
               case 3:
                   coleccion.ordenarPorNombre()
                           .forEach(System.out::println);
                   break;

               case 4:
                   System.out.println("Eliga el tipo correspondiente: \n 1. Identificar \n 2. Tratar\n");
                   int tipo = sc.nextInt();
                   sc.nextLine();

                   if(tipo == 1){coleccion.consultarPorTipo(Instrumento.Tipo.Identificar)
                           .forEach(System.out::println);
                   }
                   else if(tipo ==2){coleccion.consultarPorTipo(Instrumento.Tipo.Tratar)
                           .forEach(System.out::println);

                   }
                   break;
               case 5:
                   System.out.println("Eliga la condicion correspondiente: \n 1. Estres \n 2. Ansiedad\n 3. Ambas");
                   int condicion = sc.nextInt();
                   sc.nextLine();

                   if(condicion == 1){coleccion.consultarPorCondicion(Instrumento.Condicion.Estres)
                           .forEach(System.out::println);

                   }
                   else if(condicion ==2){coleccion.consultarPorCondicion(Instrumento.Condicion.Ansiedad)
                           .forEach(System.out::println);
                   }
                   else if (condicion == 3) {coleccion.consultarPorCondicion(Instrumento.Condicion.Ambas)
                           .forEach(System.out::println);
                   }
                   break;
               case 6:
                   System.out.println("Eliga la forma correspondiente: \n 1. Test \n 2. Escala \n 3. Cuestionario");
                   int forma = sc.nextInt();
                   sc.nextLine();

                   if(forma == 1){coleccion.consultarPorForma(Instrumento.Forma.Test)
                           .forEach(System.out::println);
                   }
                   else if(forma ==2){coleccion.consultarPorForma(Instrumento.Forma.Escala)
                           .forEach(System.out::println);
                   }
                   else if (forma == 3) {coleccion.consultarPorForma(Instrumento.Forma.Cuestionario)
                        .forEach(System.out::println);
                   }
                   break;
               case 7:
                   coleccion.consultarPorValidacion()
                           .forEach(System.out::println);
                   break;
               case 8:
                   coleccion.consultarPorConfiabilidad()
                           .forEach(System.out::println);
                   break;
               case 9:
                   coleccion.ordenarPorID()
                           .forEach(System.out::println);
                   break;
           }
       }while(opcionConsulta < 1 || opcionConsulta >9 );
   }


}
