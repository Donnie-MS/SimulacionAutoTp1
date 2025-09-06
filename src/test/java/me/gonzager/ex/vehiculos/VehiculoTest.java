package me.gonzager.ex.vehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzandoTiposDeConduccionDeberíaRetornarCorrectamenteLaVelocidad() {
        Vehiculo vehiculo = new Vehiculo(3.0);
        vehiculo.retrocederTipo();
        vehiculo.avanzarTipo();
        vehiculo.avanzarTipo();
        vehiculo.avanzarTipo();
        vehiculo.retrocederTipo();
        assertEquals(150.0, vehiculo.getVelocidadMaxima());
    }

    @Test
    void vehículoEnConduccionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {
        Vehiculo vehiculo = new Vehiculo(25.0);
        vehiculo.avanzarTipo();
        vehiculo.desplazar(200.0);
        assertEquals(200.0, vehiculo.getKilometraje());
        assertEquals(5.0, vehiculo.getCombustible());
    }

    @Test
    void vehiculoEnConduccionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {
        Vehiculo vehiculo = new Vehiculo(13.0);
        vehiculo.avanzarTipo();
        vehiculo.avanzarTipo();


        assertThrows(RuntimeException.class, () -> vehiculo.desplazar(75.0));
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {

        
        assertThrows(RuntimeException.class, () -> new Vehiculo(-10.0));
    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {
        Vehiculo vehiculo = new Vehiculo(10.0);
        Double velMaxEcologica = vehiculo.getVelocidadMaxima();
        vehiculo.avanzarTipo();
        Double velMaxEstandar = vehiculo.getVelocidadMaxima();
        vehiculo.avanzarTipo();
        Double velMaxDeportiva = vehiculo.getVelocidadMaxima();

        assertTrue(velMaxEcologica < velMaxEstandar, "Velocidad maxima estandar debe ser mayor a velocidad maxima ecologica");
        assertTrue(velMaxEstandar < velMaxDeportiva, "Veloicidad maxima deportiva debe ser mayor a velocidad maxima estandar");
        assertTrue(velMaxEstandar != velMaxDeportiva, "Velocidad maxima estandar no debe ser igual a velocidad maxima deportiva");
    }
}
