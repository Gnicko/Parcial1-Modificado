package mains;


import modelo.EstacionDeServicio;
import persistencia.BaseDeDatos;
import ui.VentanaInicio;

public class MainBaseDeDatos {
    public static void main(String[] args) {

        VentanaInicio venta = new VentanaInicio(
                new EstacionDeServicio(
                        new BaseDeDatos()
                )
        );

    }
}
