package modelo;

import java.time.LocalDate;
import java.util.List;

public interface RegistrarVentaRealizada {
    public void registrarVenta(Venta venta);

    public List<Venta> listadoPorFechas(LocalDate fechaInicio, LocalDate fechaFin);
    
}
