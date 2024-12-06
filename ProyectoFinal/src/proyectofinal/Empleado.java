/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author camil
 */
public class Empleado {
    private int ID;
    private String Nombre;

    public Empleado(int id, String nombre) {
        this.ID = id;
        this.Nombre = nombre;
    }

    public int getId() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    @Override
    public String toString() {
        return "Empleado{id=" + ID + ", nombre='" + Nombre + "'}";
    }
    
}
