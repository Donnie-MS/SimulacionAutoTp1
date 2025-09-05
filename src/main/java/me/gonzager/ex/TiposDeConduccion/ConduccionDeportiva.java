package me.gonzager.ex.TiposDeConduccion;

public class ConduccionDeportiva implements TipoDeConduccion{
    @Override
    public Double consumo() {
        return 5.0;
    }
    @Override
    public Double velocidadMaxima() {
        return 200.0;
    }
    @Override
    public TipoDeConduccion siguiente() {
        return null;
    }
    @Override
    public TipoDeConduccion anterior() {
        return new ConduccionEstandar();
    }
}
