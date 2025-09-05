package me.gonzager.ex.TiposDeConduccion;

public interface TipoDeConduccion {
    Double consumo();
    Double velocidadMaxima();
    TipoDeConduccion siguiente();
    TipoDeConduccion anterior();
}
