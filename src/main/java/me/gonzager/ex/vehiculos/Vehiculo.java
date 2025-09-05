package me.gonzager.ex.vehiculos;

import me.gonzager.ex.TiposDeConduccion.ConduccionEcologica;
import me.gonzager.ex.TiposDeConduccion.TipoDeConduccion;
/*
La simulación a modelar es desplazar indicandole una 
cantidad de kilómetros a recorrer. Al desplazarse, deben:

Restar del combustible la cantidad consumida 
para recorrer la distancia solicitada.
Sumar los kilómetros recorridos al kilometraje total.

 */
public class Vehiculo {
    private Double cantDeCombustible;
    private Double kilometraje = 0.0;
    private TipoDeConduccion tipoDeConduccion = new ConduccionEcologica();

    public Vehiculo(Double cantDeCombustible) {
        this.cantDeCombustible = cantDeCombustible;
    }
    
    public void desplazar(Double cantKilometros) {

    }

    public void avanzarTipo() {
        if (tipoDeConduccion.siguiente() != null) {
            tipoDeConduccion = tipoDeConduccion.siguiente();
        }
    }

    public void retrocederTipo() {
        if (tipoDeConduccion.anterior() != null) {
            tipoDeConduccion = tipoDeConduccion.anterior();
        }
    }

    public Double getVelocidadMaxima() {
        return tipoDeConduccion.velocidadMaxima();
    }
}

