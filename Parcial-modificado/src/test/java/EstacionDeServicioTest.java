import modelo.EstacionDeServicio;
import modelo.Venta;
import org.junit.jupiter.api.Test;
import persistencia.PersistenciaEnMemoria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EstacionDeServicioTest {
    static final String SUPER = "Super";
    static final String COMUN = "Comun";
    
    PersistenciaEnMemoria enMemoria = new PersistenciaEnMemoria();
    EstacionDeServicio estacionDeServicio = new EstacionDeServicio(enMemoria);

    @Test
    public void registrarVentaSinDescuentoTest() {
//        PersistenciaEnMemoria enMemoria = new PersistenciaEnMemoria();
//        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(enMemoria);
        LocalDateTime fecha = LocalDateTime.parse("26/05/2021 00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        estacionDeServicio.registrarVenta(new Venta(fecha, 15, SUPER));

        assertEquals(1350, estacionDeServicio.obtenerVentasEntreFecha("26/05/2021", "26/05/2021")
                .get(0).obtenerPrecio());

    }

    @Test
    public void registrarVentaConDescuentoDomigoSuperTest() {
//        PersistenciaEnMemoria enMemoria = new PersistenciaEnMemoria();
//        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(enMemoria);
        LocalDateTime fecha = LocalDateTime.parse("23/05/2021 00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        estacionDeServicio.registrarVenta(new Venta(fecha, 15, SUPER));

        assertEquals(1215, estacionDeServicio.obtenerVentasEntreFecha("23/05/2021", "23/05/2021")
                .get(0).obtenerPrecio());

    }

    @Test
    public void registrarVentaConDescuentoSabadoSuperTest() {
//        PersistenciaEnMemoria enMemoria = new PersistenciaEnMemoria();
//        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(enMemoria);
        LocalDateTime fecha = LocalDateTime.parse("22/05/2021 00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        estacionDeServicio.registrarVenta(new Venta(fecha, 25, SUPER));

        assertEquals(1980, estacionDeServicio.obtenerVentasEntreFecha("22/05/2021", "22/05/2021")
                .get(0).obtenerPrecio());

    }

    @Test
    public void registrarVentaSinDescuentoComunTest() {
//        PersistenciaEnMemoria enMemoria = new PersistenciaEnMemoria();
//        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(enMemoria);
        LocalDateTime fecha = LocalDateTime.parse("23/05/2021 00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        estacionDeServicio.registrarVenta(new Venta(fecha, 15, COMUN));

        assertEquals(1050, estacionDeServicio.obtenerVentasEntreFecha("23/05/2021", "23/05/2021")
                .get(0).obtenerPrecio());

    }

    @Test
    public void registrarVentaConDescuentoComunTest() {
//        PersistenciaEnMemoria enMemoria = new PersistenciaEnMemoria();
//        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(enMemoria);
        LocalDateTime fecha = LocalDateTime.parse("23/05/2021 09:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        estacionDeServicio.registrarVenta(new Venta(fecha, 15, COMUN));

        assertEquals(997.5, estacionDeServicio.obtenerVentasEntreFecha("23/05/2021", "23/05/2021")
                .get(0).obtenerPrecio());

    }

//
//    @Test
//    public void obtenerEntreFechaTest() {
//        List<Venta> lista = new ArrayList<>();
//        LocalDateTime fecha = LocalDateTime.parse("23/05/2021 09:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
//        lista.add(new Venta(fecha, 15, COMUN));
//
//        assertArrayEquals(List < Venta > lista, estacionDeServicio.obtenerVentasEntreFecha("23/05/2021", "23/05/2021"));
    //}


}
