package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EstacionDeServicio {
    private RegistrarVentaRealizada registroDeVenta;


    public EstacionDeServicio(RegistrarVentaRealizada registroDeVenta) {
        this.registroDeVenta = registroDeVenta;
    }

    public void registrarVenta(Venta venta) {
        registroDeVenta.registrarVenta(venta);
    }

    public double obtenerPrecio(Venta venta) {
        return venta.obtenerPrecio();
    }

    public List<Venta> obtenerVentasEntreFecha(String inicio, String fin) {
        if (inicio == null || inicio.isEmpty())
            throw new RuntimeException("Debe ingresar una fecha de inicio.");
        if (fin == null || fin.isEmpty())
            throw new RuntimeException("Debe ingresar una fecha de fin.");
        LocalDate fechaInicio = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fechaFin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (fechaInicio.isAfter(fechaFin))
            throw new RuntimeException("La fecha de inicio debe ser menor a la fecha de fin.");
        return registroDeVenta.listadoPorFechas(fechaInicio, fechaFin);
    }

}
