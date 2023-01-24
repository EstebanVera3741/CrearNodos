package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.HabitacionesDelLaberinto;

public class ConexionNodos {

    private NodoPrincipal nodoPrincipal;
    private Controlador controlador;

    public ConexionNodos(Controlador controlador){
        this.nodoPrincipal = null;
        this.controlador = controlador;
    }

    public void insertarNuevoNodoPrincipal (){
        insertarNodosQueComponenAlNodoPrincipal();
    }

    private void insertarNodosQueComponenAlNodoPrincipal(){
        for (HabitacionesDelLaberinto filasLaberinto : controlador.getLaberinto().getListaHabitacionesDelLaberinto()){
            for (Habitacion habitacion: filasLaberinto.getListaHabitacionesLaberinto()){
                if (this.nodoPrincipal == null && habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA))
                {
                    this.nodoPrincipal = new NodoPrincipal(habitacion, controlador);
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO))
                {
                    if (this.nodoPrincipal == null){
                        this.nodoPrincipal = new NodoPrincipal(habitacion, controlador);
                    }
                    else {
                        this.nodoPrincipal.insertarNuevoNodo(habitacion);
                    }
                }
            }
        }
    }


    public void recorrerOrdenSolucionLaberinto (){
        recorrerOrdenLaberinto(nodoPrincipal);
    }
    public void recorrerOrdenLaberinto (NodoPrincipal nodoPrincipal){
        if(nodoPrincipal == null){
            return;
        }
        else {
            System.out.println("\n" + nodoPrincipal.getHabitacion().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoArriba());
            System.out.println("\n" + nodoPrincipal.getHabitacion().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoIzquierdo());
            System.out.println("\n" + nodoPrincipal.getHabitacion().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoAbajo());
            System.out.println("\n" + nodoPrincipal.getHabitacion().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoDerecho());
        }
    }
    public Controlador getControlador() {
        return controlador;
    }
    public NodoPrincipal getNodoPrincipal() {
        return nodoPrincipal;
    }
}
