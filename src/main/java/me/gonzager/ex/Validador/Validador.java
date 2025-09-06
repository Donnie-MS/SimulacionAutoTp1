package me.gonzager.ex.Validador;

public class Validador {
    public static Double positivo(Double valor, String mensajeError) {
        if (valor <= 0) {
            throw new RuntimeException(mensajeError);
        }
        return valor;
    }
}
