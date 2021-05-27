package persistencia;

import modelo.RegistrarVentaRealizada;
import modelo.Venta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaEnMemoria implements RegistrarVentaRealizada {
    private String dato;

    @Override
    public void registrarVenta(Venta venta) {
        dato = venta.obtenerFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ", " + venta.obtenerLitros() + ", " + venta.obtenerPrecio() + "\n";
    }

    @Override
    public List<Venta> listadoPorFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Venta> listaDatos = new ArrayList<>();
        String[] info = dato.split(", ");
        Venta d = new Venta(LocalDateTime.parse(info[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                Double.parseDouble(info[1])
                , Double.parseDouble(info[2]));
        if (estaEntreFechas(fechaInicio,
                fechaFin,
                LocalDateTime.parse(info[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toLocalDate()))
            listaDatos.add(d);
        return listaDatos;
    }

    public boolean estaEntreFechas(LocalDate desde, LocalDate hasta, LocalDate actual) {
        return actual.isBefore(hasta) && actual.isAfter(desde) || (actual.equals(desde) || actual.equals(hasta));
    }

    public String obtenerInformacionAlmacenada() {
        return dato;
    }
}
