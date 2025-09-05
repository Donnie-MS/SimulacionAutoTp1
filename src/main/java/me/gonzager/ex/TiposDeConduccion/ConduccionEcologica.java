package me.gonzager.ex.TiposDeConduccion;

public class ConduccionEcologica implements TipoDeConduccion{
    @Override
    public Double consumo() {
        return 16.0;
    }
    @Override
    public Double velocidadMaxima() {
        return 120.0;
    }
    @Override
    public TipoDeConduccion siguiente() {
        return new ConduccionEstandar();
    }
    @Override 
    public TipoDeConduccion anterior() {
        return null;
    }
}
