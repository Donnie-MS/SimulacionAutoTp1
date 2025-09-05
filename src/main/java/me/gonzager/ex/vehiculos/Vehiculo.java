package me.gonzager.ex.vehiculos;

import me.gonzager.ex.TiposDeConduccion.ConduccionEcologica;
import me.gonzager.ex.TiposDeConduccion.TipoDeConduccion;


public class Vehiculo {
    private Double combustible;
    private Double kilometraje = 0.0;
    private TipoDeConduccion tipoDeConduccion = new ConduccionEcologica();

    public Vehiculo(Double combustible) {
        this.combustible = combustible;
    }
    /*
    Si el combustible no es suficiente para recorrer la distancia 
    solicitada, el vehículo se desplazará hasta donde le alcance el
     combustible, actualizará sus atributos correspondientes 
     (combustible y kilometraje) e informará con un error que 
     no pudo completar el recorrido solicitado con el siguiente mensaje:
    "Combustible insuficiente, solo pude recorrer X del total de Y kilometros.";
     */
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
    
    public boolean puedeRecorrer(Double kmARecorrer) {
        return kmARecorrer >= this.kmQuePuedeRecorrer();
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
}

