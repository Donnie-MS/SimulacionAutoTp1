package me.gonzager.ex.TiposDeConduccion;

public class ConduccionEstandar implements TipoDeConduccion {

    @Override
    public Double consumo() {
        return 10.0;
    }
    @Override
    public Double velocidadMaxima() {
        return 150.0;
    }
    @Override
    public TipoDeConduccion siguiente() {
        return new ConduccionDeportiva();
    }
    @Override
    public TipoDeConduccion anterior() {
        return new ConduccionEcologica();
    }
}
