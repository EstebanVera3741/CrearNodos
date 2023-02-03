package LaberintoGlobant.Laberinto;

public class Habitacion {
    private Integer valor;
    private TIPO_HABITACION tipoHabitacion;
    private String estadoHabitacion;
    public enum TIPO_HABITACION {
        PARED,
        CAMINO,
        ENTRADA,
        SALIDA
    }
    public Habitacion(Integer valor, TIPO_HABITACION tipoHabitacion, String estadoHabitacion) {
        this.valor = valor;
        this.tipoHabitacion = tipoHabitacion;
        this.estadoHabitacion = estadoHabitacion;
    }
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public TIPO_HABITACION getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
}