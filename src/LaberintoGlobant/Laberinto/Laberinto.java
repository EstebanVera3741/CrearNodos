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
            for (Habitacion habitacion : habitacionesDelLaberinto.getListaHabitacionesLaberinto()){
                cont ++;
                habitacion.setValor(cont);
            }
        }
     }

    public void visualizarElNumeroDeLasHabitacionesDelLaberinto(){
        for (HabitacionesDelLaberinto fila: listaHabitacionesDelLaberinto){
            System.out.println(" ");
            for (Habitacion habitacion : fila.getListaHabitacionesLaberinto()){
                System.out.print(habitacion.getTipoHabitacion() + " ");
            }
        }
    }
    public List<HabitacionesDelLaberinto> getListaHabitacionesDelLaberinto() {
        return listaHabitacionesDelLaberinto;
    }
}
