package LaberintoGlobant.Laberinto;

public class Habitacion {
    private Integer valor;
    private TIPO_HABITACION tipoHabitacion;
    public enum TIPO_HABITACION {
        PARED,
        CAMINO,
        ENTRADA,
        SALIDA
    }
    public Habitacion(Integer valor, TIPO_HABITACION tipoHabitacion) {
        this.valor = valor;
        this.tipoHabitacion = tipoHabitacion;
    }
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public TIPO_HABITACION getTipoHabitacion() {
        return tipoHabitacion;
    }
}