/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author camil
 */
public class Cine {

    //**Atributos**
    //matriz para la sala 1 y sala 2
    private String[][] sala1;
    private String[][] sala2;
    //peliculas de la salas
    private String pelicula1;
    private String pelicula2;

    //static para usarlos sin instanciar la clase
    //de 30 asientos cada sala
    private static int FILAS = 5;
    private static int COLUMNAS = 6;

    //**Constructor**
    //inicializa la matriz, asigna pelicula y llama al metodo para llenar la sala de asientos libres
    public Cine(String pelicula1Inicial, String pelicula2Inicial) {
        sala1 = new String[FILAS][COLUMNAS];
        sala2 = new String[FILAS][COLUMNAS];
        this.pelicula1 = pelicula1Inicial;
        this.pelicula2 = pelicula2Inicial;
        inicializarSala(sala1);
        inicializarSala(sala2);
    }

    //**Metodos**
    //metodo para inicializar los asientos "L"
    private void inicializarSala(String[][] sala) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                sala[i][j] = "L"; // L = libre
            }
        }
    }

    //metodo para mostrar el estado de las salas
    public void mostrarSalas() {
        //sala 1
        System.out.println("Pelicula Sala 1: " + pelicula1);
        System.out.println("L: libre");
        System.out.println("O: ocupado");
        System.out.println("_________ Pantalla");

        for (int i = 0; i < FILAS; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(sala1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int j = 1; j <= COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        //sala 2
        System.out.println("\nPelicula Sala 2: " + pelicula2);
        System.out.println("L: libre");
        System.out.println("O: ocupado");
        System.out.println("_________ Pantalla");

        for (int i = 0; i < FILAS; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(sala2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int j = 1; j <= COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    //metodo para asignar asiento a un empleado
    public void asignarAsiento(int salaNum, int fila, int columna, String nombreEmpleado) {
        String[][] salaSeleccionada;

        //asignar un asiento en una sala específica
        if (salaNum == 1) {
            salaSeleccionada = sala1;
        } else if (salaNum == 2) {
            salaSeleccionada = sala2;
        } else {
            //si el numero de sala no existe se sale
            System.out.println("Numero de sala invalido");
            return; 
        }

        //se verifica que el asiento elegido exista
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            System.out.println("Asiento invalido");
            return;
        }

        //se asigna el asiento si no esta ocupado
        if (salaSeleccionada[fila][columna].equals("L")) {
            salaSeleccionada[fila][columna] = "O";
        //se calcula el numero del campo dentro de los 30 que hay de acuerdo a la fila y columna
            int numeroCampo = (fila * COLUMNAS) + (columna + 1);
            System.out.println("Campo " + numeroCampo + " asignado a " + nombreEmpleado);
        } else {
            System.out.println("El campo ya esta ocupado");
        }
    }

    //metodo para cambiar las peliculas que se muestran en las salas
    public void setPelicula(int sala, String nuevaPelicula) {
        if (sala == 1) {
            this.pelicula1 = nuevaPelicula;
        } else if (sala == 2) {
            this.pelicula2 = nuevaPelicula;
        } else {
            System.out.println("Numero de sala invalido");
        }
    }
}

