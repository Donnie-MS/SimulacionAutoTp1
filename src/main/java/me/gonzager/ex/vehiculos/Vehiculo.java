package me.gonzager.ex.vehiculos;

import me.gonzager.ex.TiposDeConduccion.ConduccionEcologica;
import me.gonzager.ex.TiposDeConduccion.TipoDeConduccion;
import me.gonzager.ex.Validador.Validador;


public class Vehiculo {
    private Double combustible;
    private Double kilometraje = 0.0;
    private TipoDeConduccion tipoDeConduccion = new ConduccionEcologica();

    public Vehiculo(Double combustible) {
        this.combustible = Validador.positivo(combustible, "Ingrese un valor positivo");
    }

    public void desplazar(Double kmADesplazar) {
        if (puedeRecorrer(kmADesplazar)) {
            combustible -= (kmADesplazar / tipoDeConduccion.consumo());
            kilometraje += kmADesplazar;
        }
        else {
            Double kmQuePudoRecorrer = this.kmQuePuedeRecorrer();
            kilometraje += this.kmQuePuedeRecorrer();
            combustible = 0.0;
            throw new RuntimeException("Combustible insuficiente," +
            "solo puede recorrer" + kmQuePudoRecorrer + "Del total de " + 
            kmADesplazar + "kilometros.");
        }
        
    }
    
    public Double getKilometraje() {
        return kilometraje;
    }

    public boolean puedeRecorrer(Double kmARecorrer) {
        return kmARecorrer <= this.kmQuePuedeRecorrer();
    }

    public Double kmQuePuedeRecorrer() {
        return tipoDeConduccion.consumo() * combustible;
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

    public Double getCombustible() {
        return combustible;
    }
}

