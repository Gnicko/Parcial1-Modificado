package mains;

import modelo.EstacionDeServicio;
import persistencia.ArchivoTexto;
import ui.VentanaInicio;

public class MainArchivo {
    public static void main(String[] args) {
        VentanaInicio venta = new VentanaInicio(
                new EstacionDeServicio(
                        new ArchivoTexto("archivo")));
    }
}
	
