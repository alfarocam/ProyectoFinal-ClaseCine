/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class ProyectoFinal {


    // Información de empleados precargados id/nombre
    private static Empleado[] empleados = {
        new Empleado(1, "Camila"),
        new Empleado(2, "Joseph"),
        new Empleado(3, "Felipe"),
        new Empleado(4, "Santiago")
    };

    public static void main(String[] args) {
        ///instancia de cine con dos películas iniciales para las dos salas
        Cine cine = new Cine("Pelicula Default Sala 1", "Pelicula Default Sala 2");

        //scanner para leer la respuesta del usuario y variable que guarda la opción del usuario para el menú
        
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // ciclo do while para el menú
        // do while para que solo se salga del menú si elige salir
        do {
            System.out.println("\nMenu:");
            System.out.println("1-Mostrar salas");
            System.out.println("2-Modificar pelicula");
            System.out.println("3-Asignar asiento");
            System.out.println("4-Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            //Menu con switch
            switch (opcion) {
                //case 1 llama metodo mostrarSalas y enseña los asientos
                case 1: 
                    System.out.println("\nEstado de las salas:");
                    cine.mostrarSalas();
                    break;
                    
                //case 2 llama al metodo setPelicula para cambiar la película de la sala
                case 2: 
                    System.out.print("Ingrese el numero de sala (1 o 2): ");
                    int sala = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Ingrese el nuevo nombre de la pelicula: ");
                    String nuevaPelicula = scanner.nextLine();
                    cine.setPelicula(sala, nuevaPelicula);
                    break;
                //case 3 para elegir el asiento  
                case 3: //asigna asiento
                    System.out.print("Ingrese el numero de sala (1 o 2): ");
                    int salaAsignar = scanner.nextInt();
                    System.out.print("Ingrese la fila (A-E): ");
                    
                    //lee una letra de fila y la convierte a mayuscula para que no importe si el usuario pone a o A
                    char filaChar = scanner.next().toUpperCase().charAt(0); 
                    System.out.print("Ingrese la columna (1-6): ");
                    int columna = scanner.nextInt();

                    //if para cambiar/transformar la fila de carácter a numéros
                    //se inicia con un valor que no es válido para asegurar que la entrada del usuario si esta dentro del rango de letra
                    int fila = -1;  
                    if (filaChar == 'A') {
                        fila = 0;
                    } else if (filaChar == 'B') {
                        fila = 1;
                    } else if (filaChar == 'C') {
                        fila = 2;
                    } else if (filaChar == 'D') {
                        fila = 3;
                    } else if (filaChar == 'E') {
                        fila = 4;
                    } else {
                        System.out.println("Letra de fila invalida");
                    }

                    //valida el id y asiga el asiento elegido a el empleado
                    if (fila >= 0 && fila < 5 && columna >= 1 && columna <= 6) {
                        System.out.print("Ingrese el ID del empleado: ");
                        int idEmpleado = scanner.nextInt();

                        Empleado empleado = buscarEmpleadoPorId(idEmpleado);
                        if (empleado != null) {
                            //el columna-1 convierte las columnas de 1-6 a indices de 0-5
                            cine.asignarAsiento(salaAsignar, fila, columna - 1, empleado.getNombre());
                        } else {
                            System.out.println("Empleado no encontrado");
                        }
                    } else {
                        System.out.println("El asiento no es valido,intente de nuevo");
                    }
                    break;

                case 4: //case 4 para salir del switch 
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida, intente de nuevo");
            }
        } while (opcion != 4);

        scanner.close(); 
    }

    //metodo para buscar empleado por id
    private static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        //si no se encuentra el empleado
        return null; 
    }
}