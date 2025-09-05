package me.gonzager.ex.vehiculos;

import me.gonzager.ex.TiposDeConduccion.TipoDeConduccion;

public class Vehiculo {
    private Integer cantDeCombustible;
    private Integer kilometraje;
    private final Integer tipoDeConduccion;

    public Vehiculo(Integer cantDeCombustible, Integer kilometraje,
        TipoDeConduccion tipoDeConduccion) {
        
        this.cantDeCombustible = cantDeCombustible;
        this.kilometraje = kilometraje;
        this.tipoDeConduccion = tipoDeConduccion;
    }

    public Integer getVelocidadMaxima() {
        return tipoDeConduccion.getVelocidadMaxima();
    }
}

