package LaberintoGlobant.Laberinto;

import java.util.ArrayList;
import java.util.List;

public class Laberinto {

    private List<HabitacionesDelLaberinto> listaHabitacionesDelLaberinto = new ArrayList<>();


    public Laberinto (Integer cantidadFila, Integer cantidadHabitaciones) {
        for (int i = 0; i < cantidadFila; i ++){
            listaHabitacionesDelLaberinto.add(new HabitacionesDelLaberinto(cantidadHabitaciones));
        }
        crearAutomaticamenteElNumeroConsecutivoDeLasHabitacionesDelLaberinto();
    }
    private void crearAutomaticamenteElNumeroConsecutivoDeLasHabitacionesDelLaberinto (){
        Integer cont = 0;
        for (HabitacionesDelLaberinto habitacionesDelLaberinto : listaHabitacionesDelLaberinto){
            for (Habitacion habitacion : habitacionesDelLaberinto.getHabitaciones()){
                cont ++;
                habitacion.setValor(cont);
            }
        }
     }

    public void visualizarElNumeroDeLasHabitacionesDelLaberinto(){
        for (HabitacionesDelLaberinto fila: listaHabitacionesDelLaberinto){
            System.out.println(" ");
            for (Habitacion habitacion : fila.getHabitaciones()){
                System.out.print(habitacion.getValor() + " ");
            }
        }
    }

    public List<HabitacionesDelLaberinto> getListaHabitacionesDelLaberinto() {
        return listaHabitacionesDelLaberinto;
    }
}
