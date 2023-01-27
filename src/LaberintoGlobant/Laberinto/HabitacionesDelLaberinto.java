package LaberintoGlobant.Laberinto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HabitacionesDelLaberinto {

    private List<Habitacion> listaHabitacionesLaberinto = new ArrayList<>();
    public HabitacionesDelLaberinto(Integer cantidadColumnas) {
        Integer numeroHabitacion = 0;
        for (int i = 0; i < cantidadColumnas; i ++){
            numeroHabitacion ++;
            listaHabitacionesLaberinto.add(new Habitacion(numeroHabitacion,
                    /**HabitacionLaberinto.TIPO_HABITACION.PARED)**/ seleccionHabitacion()));
        }
    }
    private Habitacion.TIPO_HABITACION seleccionHabitacion (){
        Scanner scanner = new Scanner(System.in);
        Habitacion.TIPO_HABITACION aux = null;
        switch (scanner.nextLine()){
            case "c":
                aux = Habitacion.TIPO_HABITACION.CAMINO;
                break;
            case "e":
                aux = Habitacion.TIPO_HABITACION.ENTRADA;
                break;
            case "p":
                aux = Habitacion.TIPO_HABITACION.PARED;
                break;
            case "s":
                aux = Habitacion.TIPO_HABITACION.SALIDA;
                break;
        }
        return aux;
    }

    public List<Habitacion> getHabitaciones()
    {
        return listaHabitacionesLaberinto;
    }
}
